package com.example.internet;

public class usuarios_db {
    private String Id;
    private String Desc_Equipo;
    private String Direccion;
    private String Fecha;
    private String Instalador;
    private String Localidad;
    private String Nombre;
    private String Renta;
    private String Sector;
    private String Telefono;
    private String Telefono_2;

    public usuarios_db(String ID, String desc_Equipo, String direccion, String fecha, String instalador, String localidad, String nombre, String renta, String sector, String telefono, String telefono_2) {
        this.Id = ID;
        Desc_Equipo = desc_Equipo;
        Direccion = direccion;
        Fecha = fecha;
        Instalador = instalador;
        Localidad = localidad;
        Nombre = nombre;
        Renta = renta;
        Sector = sector;
        Telefono = telefono;
        Telefono_2 = telefono_2;
    }

    public String getDesc_Equipo() {
        return Desc_Equipo;
    }

    public void setDesc_Equipo(String desc_Equipo) {
        Desc_Equipo = desc_Equipo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getInstalador() {
        return Instalador;
    }

    public void setInstalador(String instalador) {
        Instalador = instalador;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String localidad) {
        Localidad = localidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getRenta() {
        return Renta;
    }

    public void setRenta(String renta) {
        Renta = renta;
    }

    public String getSector() {
        return Sector;
    }

    public void setSector(String sector) {
        Sector = sector;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getTelefono_2() {
        return Telefono_2;
    }

    public void setTelefono_2(String telefono_2) {
        Telefono_2 = telefono_2;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
