package Controllers;
import EJB.ModelosFacadeLocal;
import Entity.Marcas;
import Entity.Modelos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
@Named(value = "managedModelos")
@SessionScoped
public class managedModelos extends zumbi implements Serializable {
    @EJB
    private ModelosFacadeLocal modelosFacadeLocal;
    private List<Modelos> listaModelos;
    private Modelos modelos;
    private Marcas marcas;
    public List<Modelos> getListaModelos() {
        this.listaModelos = this.modelosFacadeLocal.findAll();
        return this.listaModelos;
    }
    public void setListaModelos(List<Modelos> listaModelos) {
        this.listaModelos = listaModelos;
    }
    public Modelos getModelos() {
        return this.modelos;
    }
    public void setModelos(Modelos modelos) {
        this.modelos = modelos;
    }
    public Marcas getMarcas() {
        return this.marcas;
    }
    public void setMarcas(Marcas marcas) {
        this.marcas = marcas;
    }
    @PostConstruct
    public void init() {
        this.limpiar_Modelos();
    }
    public void consultar_modelos() {
        try {
            this.modelosFacadeLocal.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al cargar modelos");
        }
    }
    public void insertar_modelos() {
        try {
            this.modelos.setIdMarca(this.marcas);
            this.modelosFacadeLocal.create(this.modelos);
            this.msj("Modelo insertado");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al insertar modelo");
        }
    }
    public void actualizar_modelos() {
        try {
            this.modelos.setIdMarca(this.marcas);
            this.modelosFacadeLocal.edit(this.modelos);
            this.msj("Modelo actualizado");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al actualizar modelo");
        }
    }
    public void eliminar_modelos(Modelos mod) {
        this.modelos = mod;
        try {
            this.modelosFacadeLocal.remove(this.modelos);
            this.msj("Modelo eliminado");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al eliminar modelo");
        }
    }
    public void consultarID_modelos(Modelos mod) {
        try {
            this.marcas.setIdMarca(mod.getIdMarca().getIdMarca());
            this.modelos = mod;
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al cargar modelo");
        }
    }
    public void limpiar_Modelos() {
        this.modelos = new Modelos();
        this.marcas = new Marcas();
        modelos.setIdModelo(0);
    }
}