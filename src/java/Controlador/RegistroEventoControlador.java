/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.RegistroEventoModelo;
import Pojo.Evento;
import Utilidades.Mensajes;
import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class RegistroEventoControlador implements Serializable {

    private String fecha;
    private String lugar;
    private String organizador;
    private int telefonoOrg;
    private int invitados;
    private String patrocinador;
    private int telefonoPatro;

    /**
     * Creates a new instance of RegistroEventoControlador
     */
    public RegistroEventoControlador() {
    }

    /**
     * Metodo que registra un nuevo evento
     */
    public void registrarEvento() {
        try {
            String validar = validacion();
            if (validar.equals("")) {
                Evento evento = new Evento();
                evento.setFecha(getFecha());
                evento.setLugar(getLugar());
                evento.setOrganizador(getOrganizador());
                evento.setTelefonoOrg(getTelefonoOrg());
                evento.setInvitados(getInvitados());
                evento.setPatrocinador(getPatrocinador());
                evento.setTelefonoPatro(getTelefonoPatro());
                RegistroEventoModelo modelo = new RegistroEventoModelo();
                String resultadoGuardar = modelo.guardarEvento(evento);
                if (resultadoGuardar.equals("exito")) {
                    Mensajes.mensaje("Exito", "Evento guardado correctamente", 1);
                } else {
                    Mensajes.mensaje("Error", "Error al guardar el evento", 2);
                }
            } else {
                Mensajes.mensaje("Advertencia", validar, 3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Metodo que valida los datos del formulario
     *
     * @return
     */
    public String validacion() {
        String resultado = "";
        try {
            if (getLugar().equals("")) {
                resultado = "Debe ingresar el lugar";
            } else if (getOrganizador().equals("")) {
                resultado = "Debe ingresar el nombre del organizador";
            }
        } catch (Exception ex) {
            resultado = "Error en las validaciones";
            ex.printStackTrace();
        }
        return resultado;
    }

    //Metodos gets y sets

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
