package db;

import models.Player;
import models.Team;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBTeam {

    private static Session session;

    public static List<Player> getPlayersFromTeam(Team team) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Player> players = null;
        try {
            Criteria cr = session.createCriteria(Player.class);
            cr.add(Restrictions.eq("team", team));
            players = cr.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return players;
    }
}
