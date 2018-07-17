package db;

import models.Competition;
import models.Manager;
import models.Player;
import models.Team;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
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

    public static Manager getManager(Team team){
        session = HibernateUtil.getSessionFactory().openSession();
        Manager manager = null;

        try {
            Criteria cr = session.createCriteria(Manager.class);
            cr.add(Restrictions.eq("team", team));
            manager = (Manager)cr.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return manager;
    }



    public static List<Competition> getCompetitionsfromTeam(Team team){
        List<Competition> results = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Competition.class);
            cr.createAlias("teams", "team"); // ADDED
            cr.add(Restrictions.eq("team.id", team.getId())); // ADDED
            results = cr.list();
        } catch (HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;

    }


}


