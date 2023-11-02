package com.libertadores.pensiones.utils;

public class Constantes {
    private Constantes() {
        throw new IllegalStateException("Utility class");
    }
    /*
    Mensajes
     */
    public static final String SAVE_DATA = "Se ejecuto la insercion de datos con exito";
    public static final String UPDATE_DATA = "Se Actualizo los datos exitosamente";
    public static final String DELETE_DATA = "Se eliminaron los datos exitosamente";
    public static final String MASCULINO = "Masculino";
    public static final String M = "M";

    /*
    Errores
     */

    public static final String MSCA_01 = "Para la creacion del registro no se debe enviar ID";
    public static final String MSCA_02 = "EL ID no puede ser nulo";
    public static final String MSCA_03 = "No se encontro un registro con ese ID";
    public static final String MSCA_04 = "El Numero de documento ya se encuentra registrado en base de datos";

    public static final String MSCA_05 = "El Username ya se encuentra registrado en base de datos";

    public static final String TIME_SIMPLE = "yyyy-MM-dd";
}
