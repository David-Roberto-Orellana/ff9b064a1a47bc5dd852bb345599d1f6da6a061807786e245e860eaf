package EJB;
import Entity.Usuarios;
import java.util.List;
import javax.ejb.Local;
/**
 *
 * @author azucena.rivasusam
 */
@Local
public interface UsuariosFacadeLocal {
    void create(Usuarios usuarios);
    void edit(Usuarios usuarios);
    void remove(Usuarios usuarios);
    Usuarios find(Object id);
    List<Usuarios> findAll();
    List<Usuarios> findRange(int[] range);
    int count();
}