package db;

import models.Competition;
import models.Team;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBCompetition {

    public static List<Team> sortTeamsByPoints(Competition competition) {

        Session session;

        List<Team> teams = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Team.class);
//            cr.add(Restrictions.eq("competitions.id", competition.getId()));
            //TODO: goes to null if this line is in
            cr.addOrder(Order.desc("currentPoints"));
            teams = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return teams;
    }


    public static List<Team> getCompetitionTeams(Competition competition){
        Session session;
        List<Team> results = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Team.class);
            cr.createAlias("competitions", "x"); // ADDED
            cr.add(Restrictions.eq("x.id", competition.getId())); // ADDED
            results = cr.list();
        } catch (HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;

    }


//    public static List<Competition> getCompetitionsFromTeam(Team team) {
//
//        Session session;
//
//        session = HibernateUtil.getSessionFactory().openSession();
//        List<Competition> competitions = null;
//        try {
//            Criteria cr = session.createCriteria(Team.class);
//            cr.createAlias("teams", "team");
//            cr.add(Restrictions.eq("team_id", team.getId()));
//            // TODO: Not working - null
//            competitions = cr.list();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return competitions;
//    }

    public static void addTeamToCompetition(Team team, Competition competition) {
        team.addCompetition(competition);
        competition.addTeam(team);
        DBHelper.update(team);
    }


}
