/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Pojo.Evento;
import Utilidades.Conexion;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class RegistroEventoModelo implements Serializable {
    
    public RegistroEventoModelo(){}
    
    public String guardarEvento(Evento evento){
        String resultado = "";
        try {
            Conexion conexion = new Conexion();
            Connection conn = conexion.connect();
            Statement st = conn.createStatement();
            String sql = "insert into agendaelectronicaacs.evento (fecha_evento,lugar_evento,nombre_organizador,telefono,cant_invitados,nombre_patrocinador,telefono_patrocinador) values ('" + evento.getFecha() + "', '" + evento.getLugar() + "', '" + evento.getOrganizador() + "', '" + evento.getTelefonoOrg() + "', '" + evento.getInvitados() +"', '"+evento.getPatrocinador()+"', '"+evento.getTelefonoPatro()+ "')";
            
            int resultadoGuardar = st.executeUpdate(sql);
            if (resultadoGuardar == 1) {
                resultado = "exito";
            } else {
                resultado = "error";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resultado;
    }
    
}
