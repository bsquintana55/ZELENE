/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import Util.ConexionBd;
import Util.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloVO.usuarioVO;

/**
 *
 * @author solan
 */
public class usuarioDAO extends ConexionBd implements Crud {

    //1. Declarar variables
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;

    private String id_usua = "", nombre_usua = "", contra_usua = "";
    private String usuario = "";

    //2. Metodo principal para recibir datos del VO
    public usuarioDAO(usuarioVO usuVO) {
        super();
        //2.1 Conectarte
        try {
            conexion = this.obtenerConexion();

            //2.2  Traigo los datos del VO
            id_usua = usuVO.getId_usua();
            nombre_usua = usuVO.getNombre_usua();
            contra_usua = usuVO.getContra_usua();

        } catch (Exception e) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public boolean inicioSesion(String nombre_usua, String contra_usua) {
        try {
            conexion = this.obtenerConexion();
            sql = "SELECT nombre_usua, contra_usua FROM usuario WHERE nombre_usua=? AND contra_usua=?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nombre_usua);
            puente.setString(2, contra_usua);

            mensajero = puente.executeQuery();
            if (mensajero.next()) {
                operacion = true;
            }
        } catch (SQLException e) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return operacion;
    }

    @Override
    public boolean agregarRegistro() {
    
     try {
            sql = "insert into usuario(nombre_usua,contra_usua) values (?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nombre_usua);
            puente.setString(2, contra_usua);
            puente.executeUpdate();
            operacion = true;
            
            if(operacion == true){
                usuario = nombre_usua;
            }
            
        } catch (SQLException e) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;

    
    
    
    }

    @Override
    public boolean actualizarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
