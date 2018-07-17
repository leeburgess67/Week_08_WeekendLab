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
    private Competition champ;
    private Player player1;

    public CompetitionTest() {
    }


    @Before
    public void before(){
        players = new ArrayList<Player>();
        player1 = new Player("New Player", PositionType.STRIKER, celtic);
        players.add(player1);
        rodgers = new Manager("Brendan Rodgers", celtic);
        celtic = new Team("Celtic", 50);
        barca = new Team("Barca", 50);
        List<Team> teams = new ArrayList<Team>();
        teams.add(barca);
        teams.add(celtic);
        champ = new Competition(CompetitionType.CHAMPIONS_LEAGUE);
    }

    @Test
    public void canGetCompetitionType(){
        assertEquals(CompetitionType.CHAMPIONS_LEAGUE, champ.getCompetition());
    }

    @Test
    public void canPlayGame(){
        champ.playGame(celtic, barca);
        assertEquals(53, celtic.getCurrentPoints());
    }
}


