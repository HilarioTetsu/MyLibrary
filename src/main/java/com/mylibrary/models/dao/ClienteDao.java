/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mylibrary.models.dao;

import com.mylibrary.models.pojo.Cliente;
import com.mylibrary.models.pojo.DatosContacto;
import com.mylibrary.models.pojo.Autor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Ticky
 */
public class ClienteDao {
    
    private Connection conn;
    private StringBuilder sb = new StringBuilder();

    public ClienteDao(Connection conn) {
        this.conn = conn;
    }
    public boolean CrearCli(Cliente cliente){
        sb.setLength(0);
          try {
            sb.append("INSERT INTO clientes ");
            sb.append("(cliente_id, nombre, apellido_paterno, apellido_materno, fecha_nac, genero, fecha_creacion, usuario_creacion, STATUS, datos_contacto_id) ");
            sb.append("VALUES(?,?,?,?,?,?,?);");

            PreparedStatement pst = conn.prepareStatement(sb.toString());
            pst.setString(1, UUID.randomUUID().toString());
            pst.setString(2, cliente.getNombre());
            pst.setString(3, cliente.getApellido_paterno());
             pst.setString(4, cliente.getApellido_materno());
            pst.setDate(5, (java.sql.Date) cliente.getFecha_nac());
            pst.setString(6, cliente.getGenero());
            

            int resultado = pst.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Registro de autor Completado");
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AutorDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al registrar autor");
            return false;
        }
    return false;
}
}