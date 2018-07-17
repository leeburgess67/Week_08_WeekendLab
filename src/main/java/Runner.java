import db.DBCompetition;
import db.DBHelper;
import db.DBPlayer;
import db.DBTeam;
import models.*;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Team celtic = new Team("Celtic FC", 25);
        DBHelper.save(celtic);

        Team aberdeen = new Team("Aberdeen FC", 5);
        DBHelper.save(aberdeen);

        Team hibs = new Team ("Hibernian FC", 15);
        DBHelper.save(hibs);

        Team barcelona = new Team("Barcelona FC", 50);
        DBHelper.save(barcelona);

        Manager rodgers = new Manager("Brendan Rodgers", celtic);
        DBHelper.save(rodgers);

        Manager mciness = new Manager("Derek McIness", aberdeen);
        DBHelper.save(mciness);

        Manager valverde = new Manager("Ernesto Valverde", barcelona);
        DBHelper.save(valverde);

        Manager lennon = new Manager("Neil Lennon", hibs);
        DBHelper.save(lennon);

        Player dembele = new Player("Moussa Dembele", PositionType.STRIKER, celtic);
        DBHelper.save(dembele);

        Player tierney = new Player("Kieran Tierney", PositionType.LEFT_BACK, celtic);
        DBHelper.save(tierney);

        Player brown = new Player("Scott Brown", PositionType.DEFENSIVE_MIDFIELDER, celtic);
        DBHelper.save(brown);

        Player gordon = new Player("Craig Gordon", PositionType.GOALKEEPER, celtic);
        DBHelper.save(gordon);

        Player messi = new Player("Lionel Messi", PositionType.STRIKER, barcelona);
        DBHelper.save(messi);

        Competition champLeague = new Competition(CompetitionType.CHAMPIONS_LEAGUE);
        DBHelper.save(champLeague);

        DBCompetition.addTeamToCompetition(celtic, champLeague);
        DBCompetition.addTeamToCompetition(barcelona, champLeague);

        // Get manager from team
        Manager celticManager = DBTeam.getManager(celtic);

        //Get team from manager
        Team rodgersTeam = rodgers.getTeam();

        // Get players from team
        List<Player> playersInCeltic = DBTeam.getPlayersFromTeam(celtic);

        // Get manager from player
        Manager brownsManager = DBPlayer.getPlayersManager(brown);

        // Get teams in competition
        List<Team> teamsInChampLeague = DBCompetition.getCompetitionTeams(champLeague);
        //TODO: Why null!?

        // Get competitions from team
        List<Competition> competitionsFromCeltic = DBTeam.getCompetitionsfromTeam(celtic);
        //TODO: Why null!?



    }
}
