/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Evento implements Serializable  {
    
    private String fecha;
    private String lugar;
    private String organizador;
    private int telefonoOrg;
    private int invitados;
    private String patrocinador;
    private int telefonoPatro;
    
    public Evento(){}
    
    //METODOS GET Y SET

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    public int getTelefonoOrg() {
        return telefonoOrg;
    }

    public void setTelefonoOrg(int telefonoOrg) {
        this.telefonoOrg = telefonoOrg;
    }

    public int getInvitados() {
        return invitados;
    }

    public void setInvitados(int invitados) {
        this.invitados = invitados;
    }

    public String getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }

    public int getTelefonoPatro() {
        return telefonoPatro;
    }

    public void setTelefonoPatro(int telefonoPatro) {
        this.telefonoPatro = telefonoPatro;
    }
    
    
}
