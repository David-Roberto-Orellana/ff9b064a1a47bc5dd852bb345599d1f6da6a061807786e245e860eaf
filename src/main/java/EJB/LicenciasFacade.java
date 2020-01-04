package EJB;
import Entity.Licencias;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author azucena.rivasusam
 */
@Stateless
public class LicenciasFacade extends AbstractFacade<Licencias> implements LicenciasFacadeLocal {
    @PersistenceContext(unitName = "carros_PU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public LicenciasFacade() {
        super(Licencias.class);
    }
}