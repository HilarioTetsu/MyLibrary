/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mylibrary.models.service.Autor;

import com.mylibrary.models.dao.AutorDao;
import com.mylibrary.models.pojo.Autor;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author HILAR
 */
public class AutorServiceImpl implements IAutorService {

    private AutorDao autorDao;
    private Connection conn;
    
    public AutorServiceImpl(Connection conn) {
        this.conn=conn;
        this.autorDao=new AutorDao(this.conn);
    }
    
    
    
    @Override
    public boolean crear(Autor autor) {
        return autorDao.crear(autor);
    }

    @Override
    public boolean actualizar(Autor autor) {
        return autorDao.actualizar(autor);
    }

    @Override
    public List<Autor> getAllAutores() {
        return autorDao.getAllAutores();
    }

    @Override
    public Autor obtenerPorId(String autorId) {
        return autorDao.obtenerPorId(autorId);
    }

    @Override
    public boolean borrarAutor(String autorId) {
        return autorDao.borrarAutor(autorId);
    }
    
}
