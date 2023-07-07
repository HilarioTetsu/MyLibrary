/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mylibrary.controllers;

import com.mylibrary.models.pojo.Cliente;
import com.mylibrary.models.pojo.DatosContacto;
import com.mylibrary.views.clientes.IFCrearCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ticky
 */
public class ClienteController implements ActionListener {

    private IFCrearCliente crearcliente;
    private Cliente cliente;
    private Connection conn;
    private DatosContacto datoscontacto;
    
    ClienteController(IFCrearCliente crearcliente, Cliente cliente, Connection conn) {
        this.crearcliente=crearcliente;
        this.cliente=cliente;
        this.conn=conn;
        
        this.crearcliente.Guardar.addActionListener(this);
        
        this.crearcliente.setVisible(true);
        
        
    }

   @Override
public void actionPerformed(ActionEvent e) {
    DatosContacto datoscontacto = new DatosContacto();
    
    if (crearcliente != null && crearcliente.Guardar != null && e.getSource() == crearcliente.Guardar) {
        cliente.setNombre(crearcliente.nombre.getText());
        cliente.setApellido_paterno(crearcliente.apellidopat.getText());
        cliente.setApellido_materno(crearcliente.apellidomat.getText());
        cliente.setGenero(crearcliente.Genero.getSelectedItem().toString());
        datoscontacto.setDireccion(crearcliente.Direccion.getText());
        
         String codigopostalStr = crearcliente.codigopostal.getText();
        int codigopostal = Integer.parseInt(codigopostalStr);
        datoscontacto.setCodigo_postal(codigopostal);

        String telefonoStr = crearcliente.Telefono.getText();
        int telefono = Integer.parseInt(telefonoStr);
        datoscontacto.setTelefono(telefono);
        
        String fechaIngresada = crearcliente.Fecha_nac.getText();
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fechaNacimiento = formatoFecha.parse(fechaIngresada);
            cliente.setFecha_nac(fechaNacimiento);
        } catch (ParseException ex) {
            System.err.println("Error al analizar la fecha ingresada: " + fechaIngresada);
        }
        
    }


         
            
                
              cliente.setStatus((byte) 1);
                

        
          }
        
     }
    

