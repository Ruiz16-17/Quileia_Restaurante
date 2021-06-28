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
public class Restaurante {

    private int Id;
    private String RazonSocial;
    private String Nombre;
    private int Tipo;
    private String Ciudad;
    private String HoraApertura;
    private String HoraCierre;

    public Restaurante() {
    }

    public Restaurante(String RazonSocial, String Nombre, int Tipo, String Ciudad, String HoraApertura, String HoraCierre) {
        
        this.RazonSocial = RazonSocial;
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        this.Ciudad = Ciudad;
        this.HoraApertura = HoraApertura;
        this.HoraCierre = HoraCierre;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getHoraApertura() {
        return HoraApertura;
    }

    public void setHoraApertura(String HoraApertura) {
        this.HoraApertura = HoraApertura;
    }

    public String getHoraCierre() {
        return HoraCierre;
    }

    public void setHoraCierre(String HoraCierre) {
        this.HoraCierre = HoraCierre;
    }
    
    
    
}
