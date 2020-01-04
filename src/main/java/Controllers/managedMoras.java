package Controllers;
import EJB.MorasFacadeLocal;
import Entity.Historiales;
import Entity.Moras;
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
@Named(value = "managedMoras")
@SessionScoped
public class managedMoras extends zumbi implements Serializable {
    @EJB
    private MorasFacadeLocal morafacadeLocal;
    private List<Moras> listamora;
    private Moras mora;
    private Historiales historiales;
    public List<Moras> getListamora() {
        this.listamora = this.morafacadeLocal.findAll();
        return this.listamora;
    }
    public void setListamora(List<Moras> listamora) {
        this.listamora = listamora;
    }
    public Moras getMora() {
        return this.mora;
    }
    public void setMora(Moras mora) {
        this.mora = mora;
    }
    public Historiales getHistoriales() {
        return this.historiales;
    }
    public void setHistoriales(Historiales historiales) {
        this.historiales = historiales;
    }
    @PostConstruct
    public void init() {
        this.limpiar_Mora();
    }
    public void insertar_mora() {
        try {
            mora.setIdHistorial(historiales);
            this.morafacadeLocal.create(this.mora);
            this.msj("Insertado Correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al Insertar");
        }
    }
    public void actualizar_mora() {
        try {
            morafacadeLocal.edit(mora);
            this.msj("Mora actualizada");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al Actualizar");
        }
    }
    public void eliminar_mora(Moras mora) {
        this.mora = mora;
        try {
            morafacadeLocal.remove(this.mora);
            this.msj("Mora eliminada");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al Eliminar");
        }
    }
    public void consultarID_mora(Moras mora) {
        try {
            this.historiales.setIdHistorial(mora.getIdHistorial().getIdHistorial());
            this.mora = mora;
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al cargar mora");
        }
    }
    public void limpiar_Mora() {
        this.mora = new Moras();
        this.historiales = new Historiales();
        this.mora.setIdMora(0);
    }
}