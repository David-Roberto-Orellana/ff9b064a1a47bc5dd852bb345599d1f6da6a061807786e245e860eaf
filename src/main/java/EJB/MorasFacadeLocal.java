package EJB;
import Entity.Moras;
import java.util.List;
import javax.ejb.Local;
/**
 *
 * @author azucena.rivasusam
 */
@Local
public interface MorasFacadeLocal {
    void create(Moras moras);
    void edit(Moras moras);
    void remove(Moras moras);
    Moras find(Object id);
    List<Moras> findAll();
    List<Moras> findRange(int[] range);
    int count();
}