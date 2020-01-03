package Controllers;

import EJB.ClientesFacadeLocal;
import EJB.ExtranjerosFacadeLocal;
import EJB.LicenciasFacadeLocal;
import Entity.Clientes;
import Entity.Extranjeros;
import Entity.Licencias;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "managedClientes")
@SessionScoped
public class managedClientes extends zumbi implements Serializable {

    String mensaje;

    @EJB
    private ClientesFacadeLocal clientesEJBFacadeLocal;
    private List<Clientes> listacliente;
    private Clientes clientes;

    @EJB
    private LicenciasFacadeLocal licenciasFacadeLocal;
    private Licencias licencias;
    private List<Licencias> listaLicencias;

    

   

    public List<Licencias> getListaLicencias() {
        listaLicencias = licenciasFacadeLocal.findAll();
        return listaLicencias;
    }

    public void setListaLicencias(List<Licencias> listaLicencias) {
        this.listaLicencias = listaLicencias;
    }

    public List<Clientes> getListacliente() {
        listacliente = clientesEJBFacadeLocal.findAll();
        return listacliente;
    }

    public void setListacliente(List<Clientes> listacliente) {
        this.listacliente = listacliente;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Licencias getLicencias() {
        return licencias;
    }

    public void setLicencias(Licencias licencias) {
        this.licencias = licencias;
    }

    @PostConstruct
    public void init() {
        this.limpiar_Clientes();
        
    }

    public void consultar_clientes() {
        try {
            this.clientesEJBFacadeLocal.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al cargar clientes");
        }

    }

    public void insertar_clientes() {
        try {
            this.clientes.setIdLicencia(this.licencias);
            this.clientesEJBFacadeLocal.create(this.clientes);
           
            
            this.msj("Cliente insertado");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al insertar cliente");
        }
        
    }

    public void consultarId_clientes(Clientes cliente) {
        try {
            this.licencias.setIdLicencia(cliente.getIdLicencia().getIdLicencia());
            this.clientes = cliente;
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al cargar cliente");
        }
    }

   public void actualizar_clientes() {
        try {
            this.clientes.setIdLicencia(this.licencias);
            this.clientesEJBFacadeLocal.edit(this.clientes);
           
            
            this.msj("Cliente Actualizado");
        } catch (Exception e) {
            e.printStackTrace();
            this.msj("Error al Actualizar cliente");
        }
        
    }

   
    public void limpiar_Clientes() {
        this.clientes = new Clientes();
        this.licencias = new Licencias();
        clientes.setIdClientes(0);
    }

}
