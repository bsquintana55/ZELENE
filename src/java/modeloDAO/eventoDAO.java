/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import Util.ConexionBd;
import Util.Crud;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloVO.eventoVO;

/**
 *
 * @author solan
 */
public class eventoDAO extends ConexionBd implements Crud {

    //1. Declarar variables 
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;

    private String id_even="", nombre_even="", feInicio_even="",
            feFinal_even="", estado_even="", descrip_even="", id_usua="";
   
    public eventoDAO() {
    }
    
    //metodo para recibir datos del vo
    public eventoDAO(eventoVO evo){
        super();
        
        try {
            //conectarse
            conexion = this.obtenerConexion();
            
            //taer datos
            id_even = evo.getId_even();
            nombre_even = evo.getNombre_even();
            feInicio_even = evo.getFeInicio_even();
            feFinal_even = evo.getFeFinal_even();
            estado_even = evo.getEstado_even();
            descrip_even = evo.getDescrip_even();
            id_usua = evo.getId_usua();
            
            

        }  catch (Exception e) {
            Logger.getLogger(eventoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    
    }
    
    
    @Override
    public boolean agregarRegistro() {
      
    try {
            sql = "INSERT INTO evento(nombre_even, feInicio_even, feFinal_even, estado_even, descrip_even, id_usua) VALUES (?,?,?,?,?,?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nombre_even);
            puente.setString(2, feInicio_even);
            puente.setString(3, feFinal_even);
            puente.setString(4, estado_even);
            puente.setString(5, descrip_even);
            puente.setString(6, id_usua);
            
            
            puente.executeUpdate();
            operacion = true;
            
           
            
        } catch (SQLException e) {
            Logger.getLogger(eventoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(eventoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return operacion;
    
    }

    @Override
    public boolean actualizarRegistro() {

             try {
            sql = "UPDATE evento SET nombre_even=?,feInicio_even=?,feFinal_even=?,estado_even=?,descrip_even=?,id_usua=1 WHERE id_even= ?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nombre_even);
            puente.setString(2, feInicio_even);
            puente.setString(3, feFinal_even);
            puente.setString(4, estado_even);
            puente.setString(5, descrip_even);  
            puente.setString(6, id_even);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(eventoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(eventoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
        
    }

    @Override
    public boolean eliminarRegistro() {
      try {
            sql = "update evento set estado_even='T' where estado_even='I';";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, estado_even);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(eventoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(eventoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    
    }
    
    
    public eventoVO consultarId(String id_even) {
        eventoVO eveVO = null;
        try {
            conexion = this.obtenerConexion();
            sql = "select * from evento where id_even = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_even);
            
            mensajero = puente.executeQuery();
            //utiliza el evento vo de sin el id obvi
            while (mensajero.next()) {
                eveVO = new eventoVO
                (
                    mensajero.getString(1),mensajero.getString(2), 
                    mensajero.getString(3), mensajero.getString(4), 
                    mensajero.getString(5), mensajero.getString(6), 
                    mensajero.getString(7)
                );
            }
        } catch (SQLException e) {
            Logger.getLogger(eventoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(eventoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return eveVO;
    }
    
    
    
    
     
   public ArrayList <eventoVO>listar()
    {
        ArrayList<eventoVO>listaEvento = new ArrayList<>(); 
        
        try 
        {
            conexion = this.obtenerConexion();
           
           sql = "SELECT evento.id_even, usuario.nombre_usua, evento.nombre_even, evento.feInicio_even, evento.feFinal_even,  evento.estado_even, evento.descrip_even FROM evento  INNER JOIN usuario ON evento.id_usua = usuario.id_usua;";
           puente = conexion.prepareStatement(sql);
           mensajero = puente.executeQuery();
           while(mensajero.next())
           {
               eventoVO eveVO = new eventoVO(
                    mensajero.getString(1),
                    mensajero.getString(3), 
                    mensajero.getString(2), 
                    mensajero.getString(5), 
                    mensajero.getString(6), 
                    mensajero.getString(7), 
                    mensajero.getString(4)

                      
               );
               listaEvento.add(eveVO);
           }
        } catch (SQLException e) 
        {
            Logger.getLogger(eventoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        finally
        {
            try 
            {
                this.cerrarConexion();
            } catch (SQLException e) 
            {
                Logger.getLogger(eventoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaEvento;
    }
   
    
    
    
    
    
}
