/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author azucena.rivasusam
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "carros_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }

    public Usuarios usuarioEstandar(Usuarios us) {
        Usuarios user = null;
        try {

        } catch (Exception e) {
            Query q = em.createQuery("select u from Usuarios u where u.tipo = 3 AND u.idUsuario <> ?1");
            q.setParameter(1, us.getIdUsuario());
            List<Usuarios> lista = q.getResultList();
            user = lista.get(0);
        }
        return user;
    }
    public Usuarios usuarioAdministrador(Usuarios us) {
        Usuarios user = null;
        try {

        } catch (Exception e) {
            Query q = em.createQuery("select u from Usuarios u where u.tipo <> 1 AND u.idUsuario <> ?1");
            q.setParameter(1, us.getIdUsuario());
            List<Usuarios> lista = q.getResultList();
            user = lista.get(0);
        }
        return user;
    }

}
