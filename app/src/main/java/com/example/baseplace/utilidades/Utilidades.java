package com.example.baseplace.utilidades;

public class Utilidades {
    //Constantes campos tablas usuario
    public static final String TABLA_USUARIO="usuario";
    public static final String CAMPO_USUARIO="Username";
    public static final String CAMPO_CORREO="Correo";
    public static final String CAMPO_CONTRASEÑA="Contraseña";
    public static final String CAMPO_TELEFONO="Telefono";
    public static final String CAMPO_UNIDAD="Unidad";

    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE " + TABLA_USUARIO + "(" +
            CAMPO_USUARIO + " TEXT, " +
            CAMPO_CORREO + " TEXT, " +
            CAMPO_CONTRASEÑA + " TEXT, " +
            CAMPO_TELEFONO + " INTEGER, " +
            CAMPO_UNIDAD + " INTEGER)";


}
