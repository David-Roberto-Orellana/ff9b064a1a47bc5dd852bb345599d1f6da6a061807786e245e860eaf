package Controllers;
import EJB.MarcasFacadeLocal;
import Entity.Marcas;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
/**
 *
 * @author azucena.rivasusam
 */
@Named(value = "managedMarcas")
@SessionScoped
public class managedMarcas extends zumbi implements Serializable {
    @EJB
    private MarcasFacadeLocal marcalocalEJB;
    private List<Marcas> listamarcas;
    private Marcas marcas;
    public List<Marcas> getListamarcas() {
        this.listamarcas = this.marcalocalEJB.findAll();
        return this.listamarcas;
    }
    public void setListamarcas(List<Marcas> listamarcas) {
        this.listamarcas = listamarcas;
    }
    public Marcas getMarcas() {
        return this.marcas;
    }
    public void setMarcas(Marcas marcas) {
        this.marcas = marcas;
    }
    @PostConstruct
    public void init() {
        this.limpiar_marcas();
    }
    public void consultar_marca() {
        try {
            this.listamarcas = marcalocalEJB.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("No se completo la carga de marcas");
        }
    }
    public void insertar_marca() {
        try {
            this.marcalocalEJB.create(this.marcas);
            this.msj("Marca insertada");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al insertar marca");
        }
    }
    public void consultarId_marcas(Marcas marca) {
        try {
            this.marcas = marca;
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al cargar la marca");
        }
    }
    public void actualizar_marca() {
        try {
            this.marcalocalEJB.edit(this.marcas);
            this.msj("Marca actualizada");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al actualizar la marca");
        }
    }
    public void eliminar_marca(Marcas marca) {
        this.marcas = marca;
        try {
            this.marcalocalEJB.remove(this.marcas);
            this.msj("Marca eliminada");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al eliminar marca");
        }
    }
    public void limpiar_marcas() {
        this.marcas = new Marcas();
        this.marcas.setIdMarca(0);
    }
}