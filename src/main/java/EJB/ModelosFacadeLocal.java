package EJB;
import Entity.Modelos;
import java.util.List;
import javax.ejb.Local;
/**
 *
 * @author azucena.rivasusam
 */
@Local
public interface ModelosFacadeLocal {
    void create(Modelos modelos);
    void edit(Modelos modelos);
    void remove(Modelos modelos);
    Modelos find(Object id);
    List<Modelos> findAll();
    List<Modelos> findRange(int[] range);
    int count();
}