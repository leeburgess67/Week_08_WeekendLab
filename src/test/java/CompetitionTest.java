import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CompetitionTest {

    private Team celtic;
    private Team barca;
    private List<Player> players;
    private Manager rodgers;
    private int points;
    private List<Competition> competitions;
    private Competition champ;
    private Player player1;

    public CompetitionTest() {
    }


    @Before
    public void before(){
        players = new ArrayList<Player>();
        player1 = new Player("New Player", PositionType.STRIKER, celtic);
        players.add(player1);
        rodgers = new Manager("Brendan Rodgers");
        celtic = new Team("Celtic", rodgers, 50);
        barca = new Team("Barca", rodgers, 50);
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
