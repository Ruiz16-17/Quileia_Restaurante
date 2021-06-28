/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Ruiz
 */
public class Ingrediente {
    private int Id;
    private String Nombre;
    private int Calorias;

    public Ingrediente() {
    }

    public Ingrediente(String Nombre, int Calorias) {
        
        this.Nombre = Nombre;
        this.Calorias = Calorias;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCalorias() {
        return Calorias;
    }

    public void setCalorias(int Calorias) {
        this.Calorias = Calorias;
    }
    
    
    
}
