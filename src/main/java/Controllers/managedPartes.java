package Controllers;
import EJB.PartesFacadeLocal;
import Entity.Partes;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
@Named(value = "managedPartes")
@SessionScoped
public class managedPartes extends zumbi implements Serializable {
    @EJB
    private PartesFacadeLocal partesFacadeLocal; 
    private List<Partes> listaPartes = null;
    private Partes partes;
    public List<Partes> getListaPartes() {
        this.listaPartes = this.partesFacadeLocal.findAll();
        return listaPartes;
    }
    public void setListaPartes(List<Partes> listaPartes) {
        this.listaPartes = listaPartes;
    }
    public Partes getPartes() {
        return this.partes;
    }
    public void setPartes(Partes partes) {
        this.partes = partes;
    }
    @PostConstruct
    public void init() {
        this.limpiar();
    }
    public void insertar_parte() {
        try {
            this.partesFacadeLocal.create(this.partes);
            this.msj("Parte insertada");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al insertar parte");
        }
    }
    public void consultarId_partes(Partes p) {
        try {
            this.partes = p;
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al cargar parte");
        }
    }
    public void actualizar_parte() {
        try {
            this.partesFacadeLocal.edit(this.partes);
            this.msj("Parte actualizada");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al actualizar parte");
        }
    }
    public void consultar_parte() {
        try {
            this.listaPartes = this.partesFacadeLocal.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al mostrar partes");
        }
    }
    public void eliminar_parte(Partes p) {
        this.partes= p;
        try {
            this.partesFacadeLocal.remove(this.partes);
            this.msj("Parte eliminada");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al eliminar parte");
        }
    }
    public void limpiar(){
        this.partes = new Partes();
        this.partes.setIdParte(0);
    }
}