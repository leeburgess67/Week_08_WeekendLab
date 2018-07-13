package db;

import models.Competition;
import models.Team;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import java.util.List;

public class DBCompetition {

    public static List<Team> sortTeamsByPoints(Competition competition) {

        Session session;


        List<Team> teams = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Team.class);
            cr.addOrder(Order.desc("currentPoints"));
            teams = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return teams;


    }
}
