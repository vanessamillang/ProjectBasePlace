package com.example.baseplace.db;

public class Usuarios {
    private String Username;
    private String Correo;
    private String Password;
    private Integer Telefono;
    private Integer Unidad;

    public Usuarios(String username, String correo, String password, Integer telefono, Integer unidad) {
        Username = username;
        Correo = correo;
        Password = password;
        Telefono = telefono;
        Unidad = unidad;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Integer getTelefono() {
        return Telefono;
    }

    public void setTelefono(Integer telefono) {
        Telefono = telefono;
    }

    public Integer getUnidad() {
        return Unidad;
    }

    public void setUnidad(Integer unidad) {
        Unidad = unidad;
    }
}
