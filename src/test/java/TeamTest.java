import models.*;
import org.junit.Before;
import org.junit.Test;
import sun.nio.cs.ext.COMPOUND_TEXT;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TeamTest {

    private Team celtic;
    private Team barca;
    private List<Player> players;
    private Manager rodgers;
    private int points;
    private List<Competition> competitions;
    private Competition champ;

    public TeamTest() {
    }


    @Before
    public void before(){
        players = new ArrayList<Player>();
        Player player1 = new Player("New Player", PositionType.STRIKER, celtic);
        players.add(player1);
        Manager rodgers = new Manager("Brendan Rodgers");
        Team celtic = new Team("Celtic", rodgers, 50);
        Team barca = new Team("Barca", rodgers, 50);
        List<Team> teams = new ArrayList<Team>();
        teams.add(barca);
        teams.add(celtic);
        champ = new Competition(CompetitionType.CHAMPIONS_LEAGUE,teams);
    }

    @Test
    public void canGetCompetitionType(){
        assertEquals(CompetitionType.CHAMPIONS_LEAGUE, champ.getCompetition());
    }


}
