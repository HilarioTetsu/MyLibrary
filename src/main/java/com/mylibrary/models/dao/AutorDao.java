/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mylibrary.models.dao;

import com.mylibrary.models.pojo.Autor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HILAR
 */
public class AutorDao {
    private Connection conn;
    private StringBuilder sb = new StringBuilder();

    public AutorDao(Connection conn) {
        this.conn = conn;
    }
    
    public boolean crear(Autor autor){
        sb.setLength(0);
        try {
            sb.append("INSERT INTO autores ");
            sb.append("(autor_id, nombre, nacionalidad, biografia, fecha_creacion, usuario_creacion, STATUS) ");
            sb.append("VALUES(?,?,?,?,?,?,?);");
            
            PreparedStatement pst = conn.prepareStatement(sb.toString());
            pst.setString(1, UUID.randomUUID().toString());
            pst.setString(2, autor.getNombre());
            pst.setString(3, autor.getNacionalidad());
            pst.setString(4, autor.getBiografia());
            pst.setTimestamp(5, new Timestamp(new Date().getTime()));
            pst.setString(6, "admin");
            pst.setByte(7, autor.getStatus());
            
            int resultado=pst.executeUpdate();
            
            if (resultado>0) {
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
    
    public boolean actualizar(Autor autor){
         sb.setLength(0);
         
         sb.append("UPDATE autores ");
         sb.append("SET nombre=?, nacionalidad=?, biografia=?, fecha_modificacion=?, usuario_modificacion=? ");
         sb.append("WHERE autor_id=? ;");
        
        try {
            PreparedStatement pst = conn.prepareStatement(sb.toString());
            pst.setString(1, autor.getNombre());
            pst.setString(2, autor.getNacionalidad());
            pst.setString(3, autor.getBiografia());
            pst.setTimestamp(4, new Timestamp(new Date().getTime()));
            pst.setString(5, "admin");
            pst.setString(6, autor.getAutorId());
            
            return pst.executeUpdate()>0;
            
        } catch (SQLException ex) {
            Logger.getLogger(AutorDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al registrar autor");
            return false;
        }
         
         
    }
}
