/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mylibrary.controllers;

import com.mylibrary.models.dao.AutorDao;
import com.mylibrary.models.pojo.Autor;
import com.mylibrary.models.service.Autor.AutorServiceImpl;
import com.mylibrary.models.service.Autor.IAutorService;
import com.mylibrary.views.autores.IFCrearAutor;
import com.mylibrary.views.autores.IFEditarAutor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

/**
 *
 * @author HILAR
 */
public class AutorController implements ActionListener {

    private IFCrearAutor formCrearAutor;
    private IFEditarAutor formEditarAutor;

    private Autor autor;
    private Connection conn;

    private IAutorService autorService;

    public AutorController(IFCrearAutor formCrearAutor, Autor autor, Connection conn) {
        this.formCrearAutor = formCrearAutor;
        this.autor = autor;

        this.formCrearAutor.setVisible(true);
        this.formCrearAutor.btnCrearAutor.addActionListener(this);
        this.conn = conn;
        autorService = new AutorServiceImpl(conn);
        System.out.println("entre controll autor-crear autor");
    }

    public AutorController(IFEditarAutor formEditarAutor, Autor autor, Connection conn) {
        this.formEditarAutor = formEditarAutor;
        this.autor = autor;
        this.formEditarAutor.setVisible(true);
        this.formEditarAutor.btnBuscar.addActionListener(this);
        this.formEditarAutor.btnGuardar.addActionListener(this);

        this.conn = conn;
        autorService = new AutorServiceImpl(conn);
        System.out.println("entre controll autor-editar autor");
    }

    @Override
    public void actionPerformed(ActionEvent e) {


            if (formCrearAutor != null && e.getSource() == formCrearAutor.btnCrearAutor) {
                System.out.println("presione boton crear autor");
                autor.setNombre(formCrearAutor.txtNombre.getText());
                autor.setBiografia(formCrearAutor.txtBiografia.getText());
                autor.setNacionalidad(formCrearAutor.comboNacionalidad.getSelectedItem().toString());
                autor.setStatus((byte) 1);
                boolean result = autorService.crear(autor);

                if (result) {
                    formCrearAutor.dispose();
                }

            }


        if (formEditarAutor != null && e.getSource() == formEditarAutor.btnBuscar) {
            System.out.println("presione boton buscar autor");
            autor = autorService.obtenerPorId(formEditarAutor.txtBuscarAutor.getText());
            if (autor.getAutorId() == null) {
                formEditarAutor.txtBuscarAutor.setText("Autor no encontrado");
                formEditarAutor.txtBiografia.setText("");
                formEditarAutor.txtNombre.setText("");
                formEditarAutor.comboNacionalidad.setSelectedIndex(0);
            } else {
                formEditarAutor.txtBuscarAutor.setText("");
                formEditarAutor.txtBiografia.setText(autor.getBiografia());
                formEditarAutor.txtNombre.setText(autor.getNombre());
                formEditarAutor.comboNacionalidad.setSelectedItem(autor.getNacionalidad());
            }

        }

        if (formEditarAutor != null && e.getSource() == formEditarAutor.btnGuardar) {
            System.out.println("presione boton actualizar autor");
        }

    }

}
