/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mylibrary.models.dao;

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
 * @author HILAR
 */
public class AutorDao {

    private Connection conn;
    private StringBuilder sb = new StringBuilder();

    public AutorDao(Connection conn) {
        this.conn = conn;
    }

    public boolean crear(Autor autor) {
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

    public boolean actualizar(Autor autor) {
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

            return pst.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(AutorDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al actualizar autor");
            return false;
        }

    }

    public List<Autor> getAllAutores() {

        List<Autor> listResult = new ArrayList<>();
        Autor autor = new Autor();
        try {
            Statement st = conn.createStatement();
            ResultSet rst = st.executeQuery("select * from autores a where a.STATUS <> 0;");

            while (rst.next()) {
                autor.setAutorId(rst.getString("autor_id"));
                autor.setBiografia(rst.getString("biografia"));
                autor.setNacionalidad(rst.getString("nacionalidad"));
                autor.setNombre(rst.getString("nombre"));
                autor.setStatus(rst.getByte("STATUS"));
                autor.setFecha_creacion(rst.getDate("fecha_creacion"));
                autor.setUsuario_creacion(rst.getString("usuario_creacion"));
                autor.setFecha_modificacion(rst.getDate("fecha_modificacion"));
                autor.setUsuario_modificacion(rst.getString("usuario_modificacion"));

                listResult.add(autor);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AutorDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al obtener datos");
            return null;
        }

        return listResult;
    }

    public Autor obtenerPorId(String autorId) {
        Autor autor = new Autor();

        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM autores WHERE autor_id=? and STATUS <> 0");
            
            pst.setString(1, autorId);
            
            ResultSet rst= pst.executeQuery();
            
            if (rst.next()) {
                autor.setAutorId(rst.getString("autor_id"));
                autor.setBiografia(rst.getString("biografia"));
                autor.setNacionalidad(rst.getString("nacionalidad"));
                autor.setNombre(rst.getString("nombre"));
                autor.setStatus(rst.getByte("STATUS"));
                autor.setFecha_creacion(rst.getDate("fecha_creacion"));
                autor.setUsuario_creacion(rst.getString("usuario_creacion"));
                autor.setFecha_modificacion(rst.getDate("fecha_modificacion"));
                autor.setUsuario_modificacion(rst.getString("usuario_modificacion"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AutorDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al obtener datos");
            return null;
        }

        return autor;
    }
    
    public boolean borrarAutor(String autorId){
        
        try {
            
            PreparedStatement pst=conn.prepareStatement("UPDATE autores SET STATUS=0 WHERE autor_id=?");
            pst.setString(1, autorId);
            
          return pst.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(AutorDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al eliminar autor");
            return false;
        }
        
                        
    }

}
