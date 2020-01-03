package EJB;
import Entity.Historiales;
import java.util.List;
import javax.ejb.Local;
/**
 *
 * @author azucena.rivasusam
 */
@Local
public interface HistorialesFacadeLocal {
    void create(Historiales historiales);
    void edit(Historiales historiales);
    void remove(Historiales historiales);
    Historiales find(Object id);
    List<Historiales> findAll();
    List<Historiales> findRange(int[] range);
    int count();
}