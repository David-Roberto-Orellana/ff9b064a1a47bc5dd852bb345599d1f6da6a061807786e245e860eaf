package Controllers;
import EJB.ReparacionesFacadeLocal;
import Entity.Partes;
import Entity.Reparaciones;
import Entity.Vehiculos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean
@SessionScoped
public class managedReparaciones extends zumbi implements Serializable {
    @EJB
    private ReparacionesFacadeLocal reparacionesFacade;
    private List<Reparaciones> listaReparaciones;
    private Reparaciones reparaciones;
    private Vehiculos vehiculos;
    private Partes partes;
    public List<Reparaciones> getListaReparaciones() {
        this.listaReparaciones = this.reparacionesFacade.findAll();
        return this.listaReparaciones;
    }
    public void setListaReparaciones(List<Reparaciones> listaReparaciones) {
        this.listaReparaciones = listaReparaciones;
    }
    public Reparaciones getReparaciones() {
        return this.reparaciones;
    }
    public void setReparaciones(Reparaciones reparaciones) {
        this.reparaciones = reparaciones;
    }
    public Vehiculos getVehiculos() {
        return this.vehiculos;
    }
    public void setVehiculos(Vehiculos vehiculos) {
        this.vehiculos = vehiculos;
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
    public void consultar() {
        try {
            this.listaReparaciones = this.reparacionesFacade.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al cargar reparaciones");
        }
    }
    public void consultarById(Reparaciones re) {
        try {
            this.vehiculos.setIdVehiculo(re.getIdVehiculo().getIdVehiculo());
            this.partes.setIdParte(re.getIdParte().getIdParte());
            this.reparaciones = re;
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al cargar reparacion");
        }
    }
    public void actualizar() {
        try {
            this.reparaciones.setIdVehiculo(this.vehiculos);
            this.reparaciones.setIdParte(this.partes);
            this.reparacionesFacade.edit(this.reparaciones);
            this.msj("Reparacion actualizada");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al actualizar reparacion");
        }
    }
    public void insertar() {
        try {
            this.reparaciones.setIdVehiculo(this.vehiculos);
            this.reparaciones.setIdParte(this.partes);
            this.reparacionesFacade.create(this.reparaciones);
            this.msj("Reparacion insertada");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al insertar reparacion");
        }
    } 
    public void eliminar(Reparaciones repa) {
        this.reparaciones = repa;
        try {
            this.reparacionesFacade.remove(this.reparaciones);
            this.msj("Reparacion eliminada");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al eliminar reparacion");
        }
    }
    public void limpiar() {
        this.reparaciones = new Reparaciones();
        this.vehiculos = new Vehiculos();
        this.partes = new Partes();
        this.reparaciones.setIdReparacion(0);
    }
}