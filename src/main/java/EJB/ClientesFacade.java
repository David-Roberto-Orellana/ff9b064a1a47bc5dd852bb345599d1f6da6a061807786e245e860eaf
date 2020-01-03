package EJB;

import Entity.Clientes;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.eclipse.persistence.exceptions.QueryException;

/**
 *
 * @author azucena.rivasusam
 */
@Stateless
public class ClientesFacade extends AbstractFacade<Clientes> implements ClientesFacadeLocal {

    @PersistenceContext(unitName = "carros_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientesFacade() {
        super(Clientes.class);
    }

    @Override
    public List<Clientes> consultaApartes() {
        String sql = "SELECT c "
                + "FROM "
                + "     Clientes c "
                + "     LEFT JOIN Extranjeros AS e ON c.idClientes = e.idExtranjero "
                + "WHERE "
                + "     e.idExtranjero IS NULL";
        List<Clientes> lista = new LinkedList();
        try {
            Query query = em.createQuery(sql);
            lista = query.getResultList();
            return lista;
        } catch (QueryException e) {
            System.out.println("************************");
            System.out.println("************************");
            System.out.println("************************");
            System.out.println("Error de Clientes Facade consulra Apartes");
            System.out.println("Error: " + e);
            return lista;
        }
    }
}
