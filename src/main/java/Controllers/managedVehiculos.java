package Controllers;
import EJB.VehiculosFacadeLocal;
import Entity.Vehiculos;
import Entity.Modelos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean
@SessionScoped
public class managedVehiculos extends zumbi implements Serializable {
    @EJB
    private VehiculosFacadeLocal vehiculosFacadeLocal;
    private List<Vehiculos> listaVehiculos;
    private Vehiculos vehiculos;
    private Modelos modelos;
    public List<Vehiculos> getListaVehiculos() {
        this.listaVehiculos = this.vehiculosFacadeLocal.findAll();
        return this.listaVehiculos;
    }
    public void setListaVehiculos(List<Vehiculos> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
    public Vehiculos getVehiculos() {
        return this.vehiculos;
    }
    public void setVehiculos(Vehiculos vehiculos) {
        this.vehiculos = vehiculos;
    }
    public Modelos getModelos() {
        return this.modelos;
    }
    public void setModelos(Modelos modelos) {
        this.modelos = modelos;
    }
    @PostConstruct
    public void init() {
        this.limpiar();
    }
    public void consultar_vehiculos() {
        try {
            this.vehiculosFacadeLocal.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al mostrar vehiculos");
        }
    }
    public void insertar_vehiculos() {
        try {
            this.vehiculos.setIdModelo(this.modelos);
            this.vehiculosFacadeLocal.create(this.vehiculos);
            this.msj("Vehiculo insertado");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al insertar vehiculo");
        }
    }
    public void actualizar_vehiculos() {
        try {
            this.vehiculos.setIdModelo(this.modelos);
            this.vehiculosFacadeLocal.edit(this.vehiculos);
            this.msj("Vehiculo actualizado");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al actualizar vehiculo");
        }
    }
    public void eliminar_vehiculos(Vehiculos veh) {
        this.vehiculos = veh;
        try {
            this.vehiculosFacadeLocal.remove(this.vehiculos);
            this.msj("Vehiculo eliminado");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al eliminar vehiculo");
        }
    }
    public void consultarID_vehiculos (Vehiculos veh) {
        try {
            this.modelos.setIdModelo(veh.getIdModelo().getIdModelo());
            this.vehiculos = veh;
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al cargar vehiculo");
        }
    }
    public void limpiar(){
        this.vehiculos = new Vehiculos();
        this.modelos = new Modelos();
        this.vehiculos.setIdVehiculo(0);
    }
}