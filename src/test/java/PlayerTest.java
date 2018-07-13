import models.Manager;
import models.Player;
import models.PositionType;
import models.Team;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

public class PlayerTest {

    Player brown;
    Team celtic;
    PositionType midfield;
    Manager rodgers;

    @Before
    public void before(){
        rodgers = new Manager("Brendan Rodgers");
        celtic = new Team("Celtic", rodgers, 50);
        brown = new Player("Scott Brown", PositionType.DEFENSIVE_MIDFIELDER, celtic);

    }

    @Test
    public void canGetName(){
        assertEquals("Scott Brown", brown.getName());
    }

    @Test
    public void canGetPosition(){
        assertEquals(PositionType.DEFENSIVE_MIDFIELDER, brown.getPosition());
    }

    @Test
    public void canGetTeam(){
        assertEquals(celtic, brown.getTeam());
    }
}
