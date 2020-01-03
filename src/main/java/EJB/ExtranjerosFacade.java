package EJB;
import Entity.Extranjeros;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author azucena.rivasusam
 */
@Stateless
public class ExtranjerosFacade extends AbstractFacade<Extranjeros> implements ExtranjerosFacadeLocal {
    @PersistenceContext(unitName = "carros_PU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public ExtranjerosFacade() {
        super(Extranjeros.class);
    }
}