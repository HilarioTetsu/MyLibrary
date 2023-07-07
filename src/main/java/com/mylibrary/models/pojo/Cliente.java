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

public class Cliente {
    
    private String cliente_Id;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private Date fecha_nac;
    private String genero;
    private DatosContacto datosContacto;
    private Date fecha_creacion;
    private String usuario_creacion;
    private Date fecha_modificacion;
    private String usuario_modificacion;
    private Byte status;

    public Cliente(String cliente_Id, String nombre, String apellido_paterno, String apellido_materno, Date fecha_nac, String genero, DatosContacto datosContacto, Date fecha_creacion, String usuario_creacion, Date fecha_modificacion, String usuario_modificacion, Byte status) {
        this.cliente_Id = cliente_Id;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_nac = fecha_nac;
        this.genero = genero;
        this.datosContacto = datosContacto;
        this.fecha_creacion = fecha_creacion;
        this.usuario_creacion = usuario_creacion;
        this.fecha_modificacion = fecha_modificacion;
        this.usuario_modificacion = usuario_modificacion;
        this.status = status;
    }
    

    public Cliente(){
        
    }
    
    public String getCliente_Id() {
        return cliente_Id;
    }
    
    public void setCliente_Id(String cliente_Id) {
        this.cliente_Id = cliente_Id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido_paterno() {
        return apellido_paterno;
    }
    
    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }
    
    public String getApellido_materno() {
        return apellido_materno;
    }
    
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }
    
    public Date getFecha_nac() {
        return fecha_nac;
    }
    
    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
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

    public DatosContacto getDatosContacto() {
        return datosContacto;
    }

    public void setDatosContacto(DatosContacto datosContacto) {
        this.datosContacto = datosContacto;
    }
    
}
