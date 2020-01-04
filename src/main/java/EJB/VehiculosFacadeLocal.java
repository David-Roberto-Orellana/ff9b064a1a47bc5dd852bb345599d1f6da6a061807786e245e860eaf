package EJB;
import Entity.Vehiculos;
import java.util.List;
import javax.ejb.Local;
/**
 *
 * @author azucena.rivasusam
 */
@Local
public interface VehiculosFacadeLocal {
    void create(Vehiculos vehiculos);
    void edit(Vehiculos vehiculos);
    void remove(Vehiculos vehiculos);
    Vehiculos find(Object id);
    List<Vehiculos> findAll();
    List<Vehiculos> findRange(int[] range);
    int count();
}