/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Utilidades.Conexion;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.faces.context.FacesContext;

/**
 *
 * @author Admin
 */
public class IndexModelo implements Serializable {

    /**
     * Creates a new instance of IndexModelo
     */
    public IndexModelo() {
    }

    /**
     * Metodo que valida el login del usuario
     *
     * @param user
     * @param pass
     * @return
     */
    public String validarUsuario(String user, String pass) {
        String resultado = "";
        try {
            Conexion conexion = new Conexion();
            Connection conn = conexion.connect();
            String sql = "select login_name, rol_id, activo from agendaelectronicaacs.usuario where login_name = '" + user + "' and contrasena = '" + pass + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    if (rs.getInt("activo") == 0) {
                        resultado = "usuarioInactivo";
                    } else if (rs.getInt("rol_id") == 1) {
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("SESSION_USER", user);
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("SESSION_ROL", 1);
                        resultado = "principal";
                    } else if (rs.getInt("rol_id") == 2) {
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("SESSION_USER", user);
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("SESSION_ROL", 2);
                        resultado = "operador";
                    } else if (rs.getInt("rol_id") == 3) {
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("SESSION_USER", user);
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("SESSION_ROL", 3);
                        resultado = "consulta";
                    }
                }
            } else {
                resultado = "usuarioIncorrecto";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resultado;
    }    
}
