/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mylibrary.models.service.Autor;

import com.mylibrary.models.pojo.Autor;
import java.util.List;

/**
 *
 * @author HILAR
 */
public interface IAutorService {

    public boolean crear(Autor autor);

    public boolean actualizar(Autor autor);

    public List<Autor> getAllAutores();
    
    public Autor obtenerPorId(String autorId);
    
    public boolean borrarAutor(String autorId);
}
