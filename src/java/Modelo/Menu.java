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
public class Menu {

    private int Id;
    private int Tipo;
    private String Nombre;
    private float Precio;

    public Menu() {
    }

    public Menu(int Id, int Tipo, String Nombre, float Precio) {
        this.Id = Id;
        this.Tipo = Tipo;
        this.Nombre = Nombre;
        this.Precio = Precio;
    }
    
    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }
    
    

}
