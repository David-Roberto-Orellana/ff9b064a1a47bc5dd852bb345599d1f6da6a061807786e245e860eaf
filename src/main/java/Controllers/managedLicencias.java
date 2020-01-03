package Controllers;
import EJB.LicenciasFacadeLocal;
import Entity.Licencias;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
/**
 * 
 * @author silvia.ungo
 */
@Named(value = "managedLicencias")
@SessionScoped
public class managedLicencias extends zumbi implements Serializable {
    @EJB
    private LicenciasFacadeLocal licenciaEJBFacadeLocal;
    private List<Licencias> listalicencia;
    private Licencias licencias;
    public List<Licencias> getListalicencia() {
        this.listalicencia = this.licenciaEJBFacadeLocal.findAll();
        return this.listalicencia;
    }
    public void setListalicencia(List<Licencias> listalicencia) {
        this.listalicencia = listalicencia;
    }
    public Licencias getLicencias() {
        return this.licencias;
    }
    public void setLicencias(Licencias licencias) {
        this.licencias = licencias;
    }
    @PostConstruct
    public void init() {
        this.limpiar();
    }
    public void consultar_licencias() {
        try {
            this.listalicencia = this.licenciaEJBFacadeLocal.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("No se completo la carga de licencias");
        }
    }
    public void insertar_licencias() {
        try {
            this.licenciaEJBFacadeLocal.create(this.licencias);
            this.msj("Licencia insertada");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al insertar licencia");
        }
    }
    public void consultarId_licencias(Licencias licencia) {
        try {
            this.licencias = licencia;
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al cargar los datos de la licencia");
        }
    }
    public void actualizar_licencias() {
        try {
            this.licenciaEJBFacadeLocal.edit(this.licencias);
            this.msj("Licencia actualizada");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al actualizar licencia");
        }
    }
    public void eliminar_licencias(Licencias licencia) {
        this.licencias = licencia;
        try {
            this.licenciaEJBFacadeLocal.remove(this.licencias);
            this.msj("Licencia eliminada");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al eliminar licencia");
        }
    }
    public void limpiar() {
        this.licencias = new Licencias();
        this.licencias.setIdLicencia(0);
    }
}