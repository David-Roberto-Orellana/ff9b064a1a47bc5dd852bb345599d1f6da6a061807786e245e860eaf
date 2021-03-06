package EJB;
import Entity.Modelos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author azucena.rivasusam
 */
@Stateless
public class ModelosFacade extends AbstractFacade<Modelos> implements ModelosFacadeLocal {
    @PersistenceContext(unitName = "carros_PU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public ModelosFacade() {
        super(Modelos.class);
    }
}