/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Ingrediente;
import java.util.List;

/**
 *
 * @author Ruiz
 */
public interface CRUD_Ingrediente {
    public List listar();
    public Ingrediente list(int id);
    public boolean agregar(Ingrediente ingre);
    public boolean editar(Ingrediente ingre);
    public boolean eliminar(int id);
}
