package com.libertadores.pensiones.utils;

import com.libertadores.pensiones.persistence.repository.SemanasMinimasRepository;
import com.libertadores.pensiones.persistence.entity.*;
import com.libertadores.pensiones.persistence.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static com.libertadores.pensiones.utils.Constantes.M;
import static com.libertadores.pensiones.utils.Constantes.MASCULINO;

@Component
public class UtilidadesAplicacion {

    @Autowired
    SalarioMinimoRepository salarioRepository;

    @Autowired
    EdadRefenciaRepository edadRefenciaRepository;

    @Autowired
    SalarioMedioNacionalRepository salarioMedio;

    @Autowired
    FactorActuarial1Repository factorActuarial1;

    @Autowired
    FactorActuarial2Repository factorActuarial2;
    @Autowired
    SemanasMinimasRepository semanasMinimasRepository;


    public BigDecimal validarSalarioBaseLiquidacion(BigDecimal salarioBaseLiquidacion,LocalDate fechaCorte){
        int anoCorte = fechaCorte.getYear();
        SalarioEntity salario = salarioRepository.findAllByAno(anoCorte);
        double calculoSalarior = salario.getSalario();
        BigDecimal salarioBigdecimal = BigDecimal.valueOf(calculoSalarior);
        double valorSMLV = calculoSalarior * 25;
        BigDecimal salarioBigdecimalSuperior = BigDecimal.valueOf(valorSMLV);
        int menora1Salario = salarioBaseLiquidacion.compareTo(salarioBigdecimal);
        int mayora25Salario = salarioBaseLiquidacion.compareTo(salarioBigdecimalSuperior);
        if (menora1Salario < 0) {
            System.out.println("El salario base de liquidacion no debe ser inferior a 1 SMLV : " + salarioBigdecimal);
             throw new IllegalStateException("El salario base de liquidacion no debe ser inferior a 1 SMLV : " + salarioBigdecimal + " "+"Salario Base Liquidacion ingresado: " + salarioBaseLiquidacion );
        } else if (mayora25Salario > 0) {
            throw new IllegalStateException("Salario Base Liquidacion ingresado no debe superar 25 SMLV: " + salarioBaseLiquidacion ) ;
        }
        return salarioBaseLiquidacion;
    }

    /**
     * Tiempo de convalidacion
     * @param fechainicioNoPago
     * @param fechaCorte
     * @return tiempoConvalidado
     * @throws ParseException
     */
    public double tiempoConvalidacion(LocalDate fechainicioNoPago, LocalDate fechaCorte) throws ParseException {
        double diferenciaEnDiasResta = ChronoUnit.DAYS.between(fechainicioNoPago, fechaCorte);
        double tiempoConvalidado = (diferenciaEnDiasResta / 365.25);
        System.out.println("Tiempo convalidacion: " + reduceDouble(tiempoConvalidado));
        return reduceDouble(tiempoConvalidado);
    }

    /**
     * Validacion del ultimo cumpleaños Salarios minimo
     * @param fechaCumplea
     * @param fechaCorte
     * @return fechaUltimoCumpleaños
     */

    public LocalDate ultimoCumpleanos(LocalDate fechaCumplea, LocalDate fechaCorte) {
        LocalDate fechaUltimoCumpleaños = null;
        if (fechaCumplea.getMonthValue() > fechaCorte.getMonthValue() ||
                (fechaCumplea.getMonthValue() == fechaCorte.getMonthValue() &&
                        fechaCumplea.getDayOfMonth() > fechaCorte.getDayOfMonth())) {
            // El último cumpleaños fue el año anterior
            int ultimoCumpleaños = fechaCorte.getYear() - 1;
            fechaUltimoCumpleaños = fechaCumplea.withYear(ultimoCumpleaños);
            System.out.println("Fecha de tu último cumpleaños: " + fechaUltimoCumpleaños);

        } else {
            // El último cumpleaños es en el año actual
            fechaUltimoCumpleaños = fechaCumplea.withYear(fechaCorte.getYear());
            System.out.println("Fecha de tu último cumpleaños: " + fechaUltimoCumpleaños);
            return fechaUltimoCumpleaños;
        }
        return fechaUltimoCumpleaños;
    }

    /**
     * Validacion del proximo cumpleaños Salarios minimo
     * @param fechaCumple
     * @param fechaCorte
     * @return proximoCumpleaños
     */

    public LocalDate proximoCumpleanos(LocalDate fechaCumple, LocalDate fechaCorte) {
        LocalDate proximoCumpleaños = fechaCumple.withYear(fechaCorte.getYear());
        if (proximoCumpleaños.isBefore(fechaCorte) || proximoCumpleaños.isEqual(fechaCorte)) {
            proximoCumpleaños = proximoCumpleaños.plusYears(1);
        }
        System.out.println("Fecha de tu próximo cumpleaños: " + proximoCumpleaños);
        return proximoCumpleaños;
    }

    /**
     * Obtener salario en la base de tabla correspondiente
     * @return userModelIterable
     */

    public List<SalarioEntity> obtenerSalirioMinimo() {
        List<SalarioEntity> entity = new ArrayList<>();
        Iterable<SalarioEntity> userModelIterable;
        userModelIterable = salarioRepository.findAll();
        userModelIterable.forEach(entity::add);
        System.out.println("Fecha de tu próximo cumpleaños: " + (List<SalarioEntity>) userModelIterable);
        return (List<SalarioEntity>) userModelIterable;
    }

    /**
     * Obtener salario minimo a la fecha de corte
     * @param fechaCorte
     * @return entity.getSalario()
     */

    public double salarioMinimoFechaCorte(LocalDate fechaCorte) {
        Integer añoActual = fechaCorte.getYear();
        SalarioEntity entity = salarioRepository.findAllByAno(añoActual);
        System.out.println("Salario minimo fecha corte: " + entity.getSalario());
        return entity.getSalario();
    }


    /**
     * Obtener numero Salarios Minimos a la fecha de corte
     * @param salarioBaseLiquidacion
     * @param salarioMinimoFechaCorte
     * @return numeroSalariosMinimos
     * @throws ParseException
     */

    public BigDecimal numeroSalariosMinimos(BigDecimal salarioBaseLiquidacion, double salarioMinimoFechaCorte) throws ParseException {
        BigDecimal salarioMinimoParseado = BigDecimal.valueOf(salarioMinimoFechaCorte);
        BigDecimal numeroSalariosMinimos = (salarioBaseLiquidacion.divide(salarioMinimoParseado, 4, RoundingMode.HALF_UP));
        //BigDecimal redondeoEntero = BigDecimal.valueOf(numeroSalariosMinimos).setScale(4, RoundingMode.HALF_UP);
        System.out.println("Numero de salarios minimos legales vigentes: " + numeroSalariosMinimos);
        return numeroSalariosMinimos;
    }

    /**
     * Obtener edad de referencia en la tabla edad_referencia
     * @param genero
     * @return edad
     */
    public Integer edadReferencia(String genero) {
        EdadReferenciaEntity edadReferencia = edadRefenciaRepository.findAllByGenero(genero);
        System.out.println("Edad referencia: " + edadReferencia.getEdad());
        return edadReferencia.getEdad();
    }

    /**
     * Calcular fecha de referencia
     * @param fechaNacimiento
     * @param edadReferencia
     * @return fechaSumada
     */
    public LocalDate fechaReferencia(LocalDate fechaNacimiento, Integer edadReferencia) {
        LocalDate fechaSumada = fechaNacimiento.plusYears(edadReferencia);
        System.out.println("Fecha Referencia: " + fechaSumada);
        return fechaSumada;
    }

    /**
     * Calcular semanas minimas en base a la fecha de referencia
     * @param fechaReferencia
     * @return entity.get().getSemMin()
     */
    public Integer semanasMinimas(LocalDate fechaReferencia) {
        int anoReferencia = fechaReferencia.getYear();
        if (anoReferencia >= (2023)) {
            Optional<SemanasMinimasEntity> entity = semanasMinimasRepository.findByAno(2023);
            entity.get().getSemMin();
            System.out.println("Semanas minimas: " + entity.get().getSemMin());
            return entity.get().getSemMin();
        } else {
            Optional<SemanasMinimasEntity> entity = semanasMinimasRepository.findByAno(anoReferencia);
            entity.get().getSemMin();
            System.out.println("Semanas minimas: " + entity.get().getSemMin());
            return entity.get().getSemMin();
        }
    }

    /**
     * Calcular fecha de Cumplimiento
     * @param fechaCorte
     * @param tiempoConvalidado
     * @return fechaResultado
     */
    public LocalDate fechaCumplimiento(Integer semanasMinimas, LocalDate fechaCorte, double tiempoConvalidado) {

        //la formula Fc + [(7días * SemMin) - (t * 365,25 días)]
        double primeraOperacion = (tiempoConvalidado * 365.25);
        double segundaOperacion = 7 * semanasMinimas;
        double terceraOperacion = segundaOperacion - primeraOperacion;
        long diasAgregadosComoLong = (long) terceraOperacion;
        LocalDate fechaResultado = fechaCorte.plus(diasAgregadosComoLong, ChronoUnit.DAYS);
        System.out.println("Fecha Cumplimiento: " + fechaResultado);
        return fechaResultado;

    }

    /**
     * Eleccion de fecha de referencia
     * @param fechaRefencia
     * @param fechaCumplimiento
     * @return fechaRefencia
     * @throws ParseException
     */
    public LocalDate eleccioFechaReferencia(LocalDate fechaRefencia, LocalDate fechaCumplimiento) throws ParseException {
        int comparacion = fechaRefencia.compareTo(fechaCumplimiento);

        if (comparacion < 0) {
            System.out.println("La fecha de cumplimietno es mayor " + fechaCumplimiento);
            return fechaCumplimiento;
        } else if (comparacion > 0) {
            System.out.println("La fecha de referencia es mayor " + fechaRefencia);
            return fechaRefencia;
        }
        return null;
    }

    /**
     * Calculo de la edad que tiene en la fecha de referencia
     * @param fechaNacimiento
     * @param fechaFR
     * @return añosDiferencia
     * @throws ParseException
     */
    public Integer edadFechaReferencia(LocalDate fechaNacimiento, LocalDate fechaFR) throws ParseException {
        Period periodo = Period.between(fechaNacimiento, fechaFR);

        int añosDiferencia = periodo.getYears();
        System.out.println("La edad que tiene a la fecha de referencia es: " + añosDiferencia);
        return añosDiferencia;

    }


    /**
     * Calcular tiempo Faltante para pension--Años
     * @param fechaRefencia
     * @param fechaCorte
     * @return tiempoFaltantePension
     * @throws ParseException
     */
    public double tiempoFaltantePension(LocalDate fechaRefencia, LocalDate fechaCorte) throws ParseException {
        double diferenciaEnDiasResta = ChronoUnit.DAYS.between(fechaCorte, fechaRefencia);
        double tiempoFaltantePension = (diferenciaEnDiasResta / 365.25);

        System.out.println("Tiempo Faltante Pension: " + tiempoFaltantePension);
        return tiempoFaltantePension;

    }

    /**
     * Calcular fecha a la edad de corte
     * @param fechaCumpleaños
     * @param fechaCorte
     * @return resultadoEntero
     */
    public Integer fechaEdadCorte(LocalDate fechaCumpleaños, LocalDate fechaCorte) {
        double diferenciaEnDiasResta = ChronoUnit.DAYS.between(fechaCumpleaños, fechaCorte);

        double valor = 365.25;
        int resultadoEntero = (int) (diferenciaEnDiasResta / valor);

        System.out.println("Edad a la fecha de Corte: " + resultadoEntero);

        return resultadoEntero;

    }

    /**
     * Salario medio nacional a la edad años completos en la fecha de corte
     * @param edadFechaCorte
     * @return salarioMedioParseado
     */
    public BigDecimal salarioMedioNacionalFechaCorte(Integer edadFechaCorte) {
        SalarioMedioNacionalEntity salarioEntity = salarioMedio.findAllByEdad(edadFechaCorte);
        System.out.println("Salario medio nacional a la edad años completos V1 : " + salarioEntity.getSalarioMedio());
        BigDecimal salarioMedioParseado = BigDecimal.valueOf(salarioEntity.getSalarioMedio());
        return salarioMedioParseado;

    }

    /**
     * Salario Medio Nacional a la edad posterior a la fecha corte
     * @param edadFechaCorte
     * @return salarioEntity.getSalarioMedio()
     */
    public double salarioMedioNacionalPosteriorFechaCorte(Integer edadFechaCorte) {
        Integer fechaPosterior = edadFechaCorte + 1;
        SalarioMedioNacionalEntity salarioEntity = salarioMedio.findAllByEdad(fechaPosterior);
        System.out.println("Salario Medio Nacional a la edad posterior a la fecha corte V2: " + salarioEntity.getSalarioMedio());
        return salarioEntity.getSalarioMedio();

    }

    /**
     * Número de días trascurridos desde la fecha del último cumpleaños hasta la fecha intermedia
     * @param ultimoCumpleaños
     * @param fechaCorte
     * @return diferenciaEnDiasResta
     */
    public Integer diasTrancurridosUltiCumFechaCor(LocalDate ultimoCumpleaños, LocalDate fechaCorte) {

        if (ultimoCumpleaños.isAfter(fechaCorte)) {
            LocalDate temp = ultimoCumpleaños;
            ultimoCumpleaños = fechaCorte;
            fechaCorte = temp;
        }
        int diferenciaEnDiasResta = (int) ChronoUnit.DAYS.between(ultimoCumpleaños, fechaCorte);
        System.out.println("Número de días trascurridos desde la fecha del último cumpleaños hasta la fecha intermedia D1: " + diferenciaEnDiasResta);

        return diferenciaEnDiasResta;

    }

    /**
     * Número de días faltantes desde la fecha intermedia hasta la fecha del siguiente cumpleaños
     * @param proximoCumpleaños
     * @param fechaCorte
     * @return diferenciaEnDiasResta
     */
    public Integer diasTrancurridosProxiCumFechaCor(LocalDate proximoCumpleaños, LocalDate fechaCorte) {
        if (proximoCumpleaños.isAfter(fechaCorte)) {
            LocalDate temp = proximoCumpleaños;
            proximoCumpleaños = fechaCorte;
            fechaCorte = temp;
        }
        int diferenciaEnDiasResta = (int) ChronoUnit.DAYS.between(proximoCumpleaños, fechaCorte);
        System.out.println("Número de días faltantes desde la fecha intermedia hasta la fecha del siguiente cumpleaños D2: " + diferenciaEnDiasResta);
        return diferenciaEnDiasResta;

    }

    /**
     * Salario de referencia
     * @param salarioBaseLiquidacion
     * @param edadReferencia
     * @param salarioEdadFechaCrte
     * @return salarioReferencia
     */
    public BigDecimal salarioReferencia(BigDecimal salarioBaseLiquidacion, Integer edadReferencia, BigDecimal salarioEdadFechaCrte) {
        SalarioMedioNacionalEntity entity = salarioMedio.findAllByEdad(edadReferencia);
        BigDecimal salarioEdadReferencia = BigDecimal.valueOf(entity.getSalarioMedio());
        BigDecimal numeroDivididos = salarioEdadReferencia.divide(salarioEdadFechaCrte, 10, RoundingMode.HALF_UP);
        BigDecimal salarioReferencia = salarioBaseLiquidacion.multiply(numeroDivididos);
        System.out.println("salario referencia SR: " + salarioReferencia);
        return salarioReferencia;
    }

    /**
     * Tasa de reemplazo
     * @param numeroSalariosMinimos
     * @return tasaReemplazo
     * @throws ParseException
     */
    public double tasaReemplazo(BigDecimal numeroSalariosMinimos) throws ParseException {
        double doubleValue = numeroSalariosMinimos.doubleValue();
        double tasaReemplazo = 65.50 - 0.50 * doubleValue;
        System.out.println("tasa Reemplazo TR: " + tasaReemplazo);
        return tasaReemplazo;
    }

    /**
     * Pensión de Referencia
     * @param salarioReferencia
     * @param tasaReemplazo
     * @return pensionReferenciaRedondeado
     */
    public BigDecimal pensionReferencia(BigDecimal salarioReferencia, double tasaReemplazo) {
        BigDecimal porcentajeTasa = BigDecimal.valueOf(tasaReemplazo / 100);
        BigDecimal pensionReferenciaMul = salarioReferencia.multiply(porcentajeTasa);
        BigDecimal pensionReferenciaRedondeado = pensionReferenciaMul.setScale(2, RoundingMode.HALF_UP);
        System.out.println("Pensión de Referencia PR: " + pensionReferenciaRedondeado);

        return pensionReferenciaRedondeado;
    }

    /**
     * Auxilio Funerario
     * @param pensionReferencia
     * @return bigDecimalValueCinco
     */
    public BigDecimal auxilioFunerario(BigDecimal pensionReferencia) throws ParseException {

        Calendar actual = Calendar.getInstance();
        Integer anoActual = actual.get(Calendar.YEAR);
        SalarioEntity salario = salarioRepository.findAllByAno(anoActual);
        double calculoSalarior = salario.getSalario();
        double valorSMLVCinco = calculoSalarior * 5;
        BigDecimal bigDecimalValueCinco = BigDecimal.valueOf(valorSMLVCinco);
        double valorSMLVDiez = reduceDouble(calculoSalarior * 10);
        BigDecimal bigDecimalValueDiez = new BigDecimal(valorSMLVDiez);
        int comparisonResult = pensionReferencia.compareTo(bigDecimalValueCinco);
        int comparisonResult1 = pensionReferencia.compareTo(bigDecimalValueDiez);
        if (comparisonResult < 0) {
            System.out.println("Auxilio Funerario PR: " + bigDecimalValueCinco);
            return bigDecimalValueCinco;
        } else if ( comparisonResult1 > 0) {
            System.out.println("Auxilio Funerario PR: " + bigDecimalValueDiez);
            return bigDecimalValueDiez;
        } else {
            System.out.println("Auxilio Funerario PR: " + pensionReferencia);
            return pensionReferencia;
        }

    }

    /**
     * Factor actuarial 1
     * @param edadReferencia
     * @param genero
     * @return bigDecimalValue
     */
    public BigDecimal factorActuarial1(Integer edadReferencia, String genero) {
        FactorActuarial1Entity entity = factorActuarial1.findAllByEdad(edadReferencia);
        if (genero.equals(MASCULINO) || genero.equals(M)) { // ------------------------------------------------CAMBIAMOS A M Y H?
            BigDecimal bigDecimalValue = BigDecimal.valueOf(entity.getHombres());
            System.out.println("Factor actuarial 1 Hombre: " + entity.getHombres());
            return bigDecimalValue;
        } else {
            BigDecimal bigDecimalValue = BigDecimal.valueOf(entity.getMujeres());
            System.out.println("Factor actuarial 1 Mujer: " + entity.getMujeres());
            return bigDecimalValue;
        }
    }

    /**
     * Factor actuarial 2
     * @param edadReferencia
     * @param genero
     * @return bigDecimalValue
     */
    public BigDecimal factorActuarial2(Integer edadReferencia, String genero) {
        FactorActuarial2Entity entity = factorActuarial2.findAllByEdad(edadReferencia);
        if (genero.equals(MASCULINO)) {
            BigDecimal bigDecimalValue = BigDecimal.valueOf(entity.getHombres());
            System.out.println("Factor actuarial 2 Hombre: " + entity.getHombres());
            return bigDecimalValue;
        } else {
            BigDecimal bigDecimalValue = BigDecimal.valueOf(entity.getMujeres());
            System.out.println("Factor actuarial 2 Mujer: " + entity.getMujeres());
            return bigDecimalValue;
        }
    }

    /**
     * Factor actuarial 3
     * @param tiempoConvalidado
     * @param tiempoFaltantePension
     * @return bigDecimalValue
     */
    public BigDecimal factorActuarial3(double tiempoConvalidado, double tiempoFaltantePension) {
        double calculo1 = Math.pow(1.03, tiempoConvalidado);
        double calculo2 = Math.pow(1.03, (tiempoConvalidado + tiempoFaltantePension));
        double factorActuarial3 = ((calculo1) - 1) / ((calculo2) - 1);
        BigDecimal bigDecimalValue = BigDecimal.valueOf(factorActuarial3);
        System.out.println("Factor actuarial 3 : " + factorActuarial3);
        return bigDecimalValue;
    }


    /**
     * Reduce decimales a 4 despues de la coma
     * @param valorDouble
     * @return numeroReducido
     * @throws ParseException
     */
    public double reduceDouble(double valorDouble) throws ParseException {

        DecimalFormat valor = new DecimalFormat("#.######");
        String numero = valor.format(valorDouble);
        double numeroReducido = valor.parse(numero).doubleValue();
        return numeroReducido;
    }

    /**
     * Calculo de rreserva actuarial
     * @param fac1
     * @param pensionReferencia
     * @param fac2
     * @param auxilioFunerario
     * @param fac3
     * @return pensionReferenciaRedondeado
     */
    public BigDecimal reservaActuarial(BigDecimal fac1, BigDecimal pensionReferencia, BigDecimal fac2, BigDecimal auxilioFunerario, BigDecimal fac3) {
        BigDecimal multFac1Pr = fac1.multiply(pensionReferencia);
        BigDecimal muliFac2Ar = fac2.multiply(auxilioFunerario);
        BigDecimal sumaMultFac1PrMuliFac2Ar = multFac1Pr.add(muliFac2Ar);
        BigDecimal calculoActuarialTotal = sumaMultFac1PrMuliFac2Ar.multiply(fac3);
        BigDecimal pensionReferenciaRedondeado = calculoActuarialTotal.setScale(0, RoundingMode.HALF_UP);


        System.out.println("Valor " + pensionReferenciaRedondeado);
        return pensionReferenciaRedondeado;
    }

    /**
     * Parseo de String a Localdate
     * @param fecha
     * @return fechaLocalDate
     */
    public LocalDate stringLocalDate(String fecha) {
        String fechaString = fecha;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaLocalDate = LocalDate.parse(fechaString, formato);
        return fechaLocalDate;
    }

    /**
     * Encriptar contraseña
     * @param password
     * @return hashedPassword
     */

    public String encriptarContrasena(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        System.out.println("Contraseña encriptada: " + hashedPassword);
        return hashedPassword;
    }
}
