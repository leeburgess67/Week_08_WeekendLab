import com.sun.java.swing.plaf.gtk.GTKConstants;
import db.DBCompetition;
import db.DBHelper;
import db.DBTeam;
import models.*;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Manager rodgers = new Manager("Brendan Rodgers");
        DBHelper.save(rodgers);

        Manager mciness = new Manager("Derek McIness");
        DBHelper.save(mciness);

        Manager valverde = new Manager("Ernesto Valverde");
        DBHelper.save(rodgers);

        Team celtic = new Team("Celtic FC", rodgers, 25);
        DBHelper.save(celtic);

        Team aberdeen = new Team("Aberdeen FC", mciness, 5);
        DBHelper.save(aberdeen);

        Team barcelona = new Team("Barcelona FC",valverde, 50);
        DBHelper.save(barcelona);

        Player dembele = new Player("Moussa Dembele", PositionType.STRIKER, celtic);
        DBHelper.save(dembele);

        Player tierney = new Player("Keiran Tierney", PositionType.LEFT_BACK, celtic);
        DBHelper.save(tierney);

        Player brown = new Player("Scott Brown", PositionType.DEFENSIVE_MIDFIELDER, celtic);
        DBHelper.save(brown);

        Player gordon = new Player("Craig Gordon", PositionType.GOALKEEPER, celtic);
        DBHelper.save(gordon);

        Player messi = new Player("Lionel Messi", PositionType.STRIKER, celtic);
        DBHelper.save(messi);


        List<Team> teams = new ArrayList<Team>();
        teams.add(celtic);
        teams.add(barcelona);
        teams.add(aberdeen);
        Competition championsLeague = new Competition(CompetitionType.CHAMPIONS_LEAGUE, teams );
        DBHelper.save(championsLeague);

//        List<Player> playersInTeam = DBTeam.getPlayersFromTeam(celtic);

        List<Team> sortedTeamsByPoints = DBCompetition.sortTeamsByPoints(championsLeague);
        // TODO: Always excludes top team from results






    }
}
