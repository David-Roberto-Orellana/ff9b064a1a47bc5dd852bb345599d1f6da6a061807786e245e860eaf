package Controllers;

import EJB.UsuariosFacadeLocal;
import Entity.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

@ManagedBean
@SessionScoped
@Named(value = "ManagedUsuario")
public class ManagedUsuario extends zumbi implements Serializable {
    
    @EJB
    private UsuariosFacadeLocal usuariosFacade;
    private List<Usuarios> listaUsuarios;
    private Usuarios usuarios;
   

    public List<Usuarios> getListaUsuarios(){
        this.listaUsuarios= this.usuariosFacade.findAll();
        return this.listaUsuarios;
    }

    public void setListaUsuarios(List<Usuarios> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Usuarios getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @PostConstruct
    public void init() {
        this.limpiar_usuario();
    }
    
    
    
      public void consultar_usuarios() {
        try {
            this.listaUsuarios = usuariosFacade.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al mostrar Usuario");
        }
        
    }
    

    public void insertar_usuario() {
        try {
            this.usuariosFacade.create(this.usuarios);
            this.msj("Usuario Insertado");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al Insertar Usuario");
        }
        
    }
    public void ConsultarId_usuario(Usuarios u){
        try {
         this.usuarios= u;   
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error Al Cargar Usuario");
        }
    }
    
    public void actualizar_usuario(){
          try {
            this.usuariosFacade.edit(this.usuarios);
            this.msj("Usuario Actualizado");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al Actualizar Usuario");
        }
       
    }
    public void limpiar_usuario(){
        this.usuarios = new Usuarios();
         this.usuarios.setIdUsuario(0);
    }
    
    public void eliminar_usuarios(Usuarios u){
        this.usuarios= u;
         try {
            this.usuariosFacade.remove(this.usuarios);
            this.msj("Usuario Eliminado");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error Al Eliminar Usuario");
        } 
    }
}