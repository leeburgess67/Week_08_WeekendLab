import models.Manager;
import models.Player;
import models.PositionType;
import models.Team;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TeamTest {

    Player brown;
    Team celtic;
    Manager rodgers;

    @Before
    public void before() {
        rodgers = new Manager("Brendan Rodgers");
        celtic = new Team("Celtic", rodgers, 50);
    }

    @Test
    public void canGetManager(){
        assertEquals(rodgers, celtic.getManager())
        ;
    }

    @Test
    public void canGetName(){
        assertEquals("Celtic", celtic.getName());
    }

    @Test
    public void canGetPoints(){
        assertEquals(50, celtic.getCurrentPoints());
    }


}
