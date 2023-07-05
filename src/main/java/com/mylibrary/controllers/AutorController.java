/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mylibrary.controllers;

import com.mylibrary.models.dao.AutorDao;
import com.mylibrary.models.pojo.Autor;
import com.mylibrary.views.autores.IFCrearAutor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

/**
 *
 * @author HILAR
 */
public class AutorController implements ActionListener{

    private IFCrearAutor formCrearAutor;
    private Autor autor;
    private Connection conn;
    private AutorDao autorDao;
    
    public AutorController(IFCrearAutor formCrearAutor, Autor autor, Connection conn) {
        this.formCrearAutor=formCrearAutor;
        this.autor=autor;
    
         this.formCrearAutor.setVisible(true);
         this.formCrearAutor.btnCrearAutor.addActionListener(this);
         this.conn=conn;
         autorDao=new AutorDao(this.conn);
         System.out.println("entre controll autor");
    }

    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==formCrearAutor.btnCrearAutor) {
            autor.setNombre(formCrearAutor.txtNombre.getText());
            autor.setBiografia(formCrearAutor.txtBiografia.getText());
            autor.setNacionalidad(formCrearAutor.comboNacionalidad.getSelectedItem().toString());
            autor.setStatus((byte) 1);
            boolean result=autorDao.crear(autor);
            
            if (result) {
                formCrearAutor.dispose();
            }
            
        }
    }
    
}
