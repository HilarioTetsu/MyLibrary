/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mylibrary.models.pojo;

/**
 *
 * @author Ticky
 */
import java.util.Date;

public class DatosContacto {
   private int Datos_contactoId;
   private int telefono;
   private String email;
   private String direccion;
   private int codigo_postal;
   private Date fecha_creacion;
   private String usuario_creacion;
   private Date fecha_modificacion;
   private String usuario_modificacion;
   private Byte status;

    public DatosContacto(int Datos_contactoId, int telefono, String email, String direccion, int codigo_postal, Date fecha_creacion, String usuario_creacion, Date fecha_modificacion, String usuario_modificacion, Byte status) {
        this.Datos_contactoId = Datos_contactoId;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.codigo_postal = codigo_postal;
        this.fecha_creacion = fecha_creacion;
        this.usuario_creacion = usuario_creacion;
        this.fecha_modificacion = fecha_modificacion;
        this.usuario_modificacion = usuario_modificacion;
        this.status = status;
    }

    public DatosContacto() {
    }

    public int getDatos_contactoId() {
        return Datos_contactoId;
    }

    public void setDatos_contactoId(int Datos_contactoId) {
        this.Datos_contactoId = Datos_contactoId;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getUsuario_creacion() {
        return usuario_creacion;
    }

    public void setUsuario_creacion(String usuario_creacion) {
        this.usuario_creacion = usuario_creacion;
    }

    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public String getUsuario_modificacion() {
        return usuario_modificacion;
    }

    public void setUsuario_modificacion(String usuario_modificacion) {
        this.usuario_modificacion = usuario_modificacion;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
   
   
   
   
   
}



