package EJB;
import Entity.Partes;
import java.util.List;
import javax.ejb.Local;
/**
 *
 * @author azucena.rivasusam
 */
@Local
public interface PartesFacadeLocal {
    void create(Partes partes);
    void edit(Partes partes);
    void remove(Partes partes);
    Partes find(Object id);
    List<Partes> findAll();
    List<Partes> findRange(int[] range);
    int count();
}