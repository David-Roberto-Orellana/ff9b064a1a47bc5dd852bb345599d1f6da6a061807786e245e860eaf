package Controllers;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
/**
 * 
 * @author DELL
 */
public class zumbi {
    private String mensaje = "";
    public void mensajes() {
        FacesMessage msg = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msg);
    }
    public void msj (String x) {
        this.mensaje = x;
        this.mensajes();
    } 
}