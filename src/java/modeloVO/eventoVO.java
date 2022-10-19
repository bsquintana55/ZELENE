/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVO;

/**
 *
 * @author solan
 */
public class eventoVO {

    private String id_even, nombre_even, feInicio_even, feFinal_even, estado_even, descrip_even, id_usua;

    public eventoVO(
            String id_even, 
            String nombre_even,
            String feInicio_even,
            String feFinal_even,
            String estado_even,
            String descrip_even,
            String id_usua) 
    {
            this.id_even = id_even;
            this.nombre_even = nombre_even;
            this.feInicio_even = feInicio_even;
            this.feFinal_even = feFinal_even;
            this.estado_even = estado_even;
            this.descrip_even = descrip_even;
            this.id_usua = id_usua;
    }

    public eventoVO(
            String nombre_even, 
            String feInicio_even, 
            String feFinal_even, 
            String estado_even, 
            String descrip_even, 
            String id_usua) 
    {
        this.nombre_even = nombre_even;
        this.feInicio_even = feInicio_even;
        this.feFinal_even = feFinal_even;
        this.estado_even = estado_even;
        this.descrip_even = descrip_even;
        this.id_usua = id_usua;
    }
    
    
    
  

    public eventoVO() {
    }

    

    public String getId_even() {
        return id_even;
    }

    public void setId_even(String id_even) {
        this.id_even = id_even;
    }

    public String getNombre_even() {
        return nombre_even;
    }

    public void setNombre_even(String nombre_even) {
        this.nombre_even = nombre_even;
    }

    public String getFeInicio_even() {
        return feInicio_even;
    }

    public void setFeInicio_even(String feInicio_even) {
        this.feInicio_even = feInicio_even;
    }

    public String getFeFinal_even() {
        return feFinal_even;
    }

    public void setFeFinal_even(String feFinal_even) {
        this.feFinal_even = feFinal_even;
    }

    public String getEstado_even() {
        return estado_even;
    }

    public void setEstado_even(String estado_even) {
        this.estado_even = estado_even;
    }

    public String getDescrip_even() {
        return descrip_even;
    }

    public void setDescrip_even(String descrip_even) {
        this.descrip_even = descrip_even;
    }

    public String getId_usua() {
        return id_usua;
    }

    public void setId_usua(String id_usua) {
        this.id_usua = id_usua;
    }

}
