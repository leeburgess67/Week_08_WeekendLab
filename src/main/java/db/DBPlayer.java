package db;

import models.Manager;
import models.Player;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class DBPlayer {



    public static Manager getPlayersManager(Player player){

        Session session;

        session = HibernateUtil.getSessionFactory().openSession();
        Manager manager = null;
        try {
            Criteria cr = session.createCriteria(Manager.class);
            cr.add(Restrictions.eq("team", player.getTeam()));
            manager = (Manager) cr.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return manager;
    }
}
