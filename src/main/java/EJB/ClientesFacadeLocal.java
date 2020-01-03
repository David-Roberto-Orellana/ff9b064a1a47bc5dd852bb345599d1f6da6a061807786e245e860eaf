package EJB;
import Entity.Clientes;
import java.util.List;
import javax.ejb.Local;
/**
 *
 * @author azucena.rivasusam
 */
@Local
public interface ClientesFacadeLocal {
    void create(Clientes clientes);
    void edit(Clientes clientes);
    void remove(Clientes clientes);
    Clientes find(Object id);
    List<Clientes> findAll();
    List<Clientes> findRange(int[] range);
    int count();
    List<Clientes> consultaApartes();
}