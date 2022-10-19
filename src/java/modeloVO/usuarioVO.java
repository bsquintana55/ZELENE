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
public class usuarioVO {
    
    private String id_usua,nombre_usua, contra_usua;

    public usuarioVO(String id_usua, String nombre_usua, String contra_usua) {
        this.id_usua = id_usua;
        this.nombre_usua = nombre_usua;
        this.contra_usua = contra_usua;
    }

    public String getId_usua() {
        return id_usua;
    }

    public void setId_usua(String id_usua) {
        this.id_usua = id_usua;
    }

    public String getNombre_usua() {
        return nombre_usua;
    }

    public void setNombre_usua(String nombre_usua) {
        this.nombre_usua = nombre_usua;
    }

    public String getContra_usua() {
        return contra_usua;
    }

    public void setContra_usua(String contra_usua) {
        this.contra_usua = contra_usua;
    }

    
    
    
    
}
