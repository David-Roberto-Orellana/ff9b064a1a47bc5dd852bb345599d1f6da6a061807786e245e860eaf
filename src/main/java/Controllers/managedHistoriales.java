package Controllers;
import EJB.HistorialesFacadeLocal;
import Entity.Extranjeros;
import Entity.Historiales;
import Entity.Vehiculos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
@Named(value = "managedHistoriales")
@SessionScoped
public class managedHistoriales extends zumbi implements Serializable {
    @EJB
    private HistorialesFacadeLocal historialesFacadeLocal;
    private List<Historiales> listaHistoriales;
    private Historiales historiales;
    private Extranjeros extranjeros;
    private Vehiculos vehiculos;
    public List<Historiales> getListaHistoriales() {
        this.listaHistoriales = this.historialesFacadeLocal.findAll();
        return this.listaHistoriales;
    }
    public void setListaHistoriales(List<Historiales> listaHistoriales) {
        this.listaHistoriales = listaHistoriales;
    }
    public Historiales getHistoriales() {
        return this.historiales;
    }
    public void setHistoriales(Historiales historiales) {
        this.historiales = historiales;
    }
    public Extranjeros getExtranjeros() {
        return this.extranjeros;
    }
    public void setExtranjeros(Extranjeros extranjeros) {
        this.extranjeros = extranjeros;
    }
    public Vehiculos getVehiculos() {
        return this.vehiculos;
    }
    public void setVehiculos(Vehiculos vehiculos) {
        this.vehiculos = vehiculos;
    }
    @PostConstruct
    public void init() {
        this.limpiar();
    }
    public void consultar_historiales(){
        try {
            this.listaHistoriales = this.historialesFacadeLocal.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("No se pudo cargar el historial");
        }
    }
    public void insertar_historiales(){
        try {
            this.historialesFacadeLocal.create(this.historiales);
            this.msj("Historial insertado");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al insertar historial");
        }
    }
    public void consultarId_historiales(Historiales historiales){
        try {
            this.historiales = historiales;
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al cargar historial");
        }
    }
    public void actualizar(){
        try {
            this.historialesFacadeLocal.create(this.historiales);
            this.msj("Historialo Actualizado");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al actualizar historial");
        }
    }
    public void eliminar_historiales(Historiales historiales){
        try {
            this.historialesFacadeLocal.remove(this.historiales);
            this.msj("Se ha eliminado el historial");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al eliminar el historial");
        }
    }
    public void limpiar(){
        this.historiales = new Historiales();
        this.vehiculos = new Vehiculos();
        this.extranjeros = new Extranjeros();
        this.historiales.setIdHistorial(0);
    }
}