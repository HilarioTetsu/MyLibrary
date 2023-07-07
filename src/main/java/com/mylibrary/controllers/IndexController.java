/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mylibrary.controllers;

import com.mylibrary.app.Libreria;
import com.mylibrary.models.pojo.Autor;
import com.mylibrary.views.autores.IFCrearAutor;
import com.mylibrary.views.autores.IFEditarAutor;
import com.mylibrary.views.autores.IFEliminarAutor;
import com.mylibrary.views.indexForm;
import com.mylibrary.views.libros.IFCrearLibro;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.plaf.basic.BasicDesktopPaneUI;

/**
 *
 * @author HILAR
 */
public class IndexController implements ActionListener {

    private indexForm index;
    public javax.swing.JDesktopPane dsk;
    private Connection conn;

    public IndexController(Connection connection) {

        this.index = new indexForm();

        this.index.nuevoLibroItem.addActionListener(this);
        this.index.nuevoAutorItem.addActionListener(this);
        this.index.updateAutorItem.addActionListener(this);
        this.index.deleteAutorItem.addActionListener(this);
        this.conn = connection;
        dsk = new JDesktopPane();
        this.index.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Código a ejecutar cuando se cierra la ventana
                System.out.println("La ventana se está cerrando...");

               
                if (conn != null) {
                    try {
                        System.out.println("entro aqui para cerrar conn");
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                // Cierra el JFrame
                index.dispose();
            }
        });
    }

    public void init() {
        index.setVisible(true);
        index.setTitle("MyLibrary");

        index.getContentPane().add(dsk);
        index.getContentPane().setBackground(Color.GREEN);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == index.nuevoLibroItem) {
            System.out.println("boton crearLibro");
            IFCrearLibro iFCLibro = new IFCrearLibro();
            index.add(iFCLibro);
            iFCLibro.setVisible(true);
        }

        if (e.getSource() == index.nuevoAutorItem) {
            System.out.println("boton crearAutor");
            IFCrearAutor formCrearAutor = new IFCrearAutor();
            Autor autor = new Autor();
            AutorController autorContrll = new AutorController(formCrearAutor, autor, conn);
            index.add(formCrearAutor);

        }
        
        if (e.getSource()==index.updateAutorItem) {
             System.out.println("boton updateAutor");
             IFEditarAutor formEditarAutor=new IFEditarAutor();
             Autor autor = new Autor();
             AutorController autorContrll = new AutorController(formEditarAutor, autor, conn);
             index.add(formEditarAutor);
        }
        
        if (e.getSource()==index.deleteAutorItem) {
             System.out.println("boton deleteAutor");
             IFEliminarAutor formEliminarAutor=new IFEliminarAutor();
             
             AutorController autorContrll = new AutorController(formEliminarAutor, conn);
             index.add(formEliminarAutor);
        }

    }

}
