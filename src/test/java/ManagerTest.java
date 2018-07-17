import models.Manager;
import models.Team;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ManagerTest {

    Manager rodgers;
    Team celtic;

    @Before
    public void before(){
        celtic = new Team("Celtic FC", 25);
        rodgers = new Manager("Brendan Rodgers", celtic);
    }

    @Test
    public void canGetName(){
        assertEquals("Brendan Rodgers", rodgers.getName());
    }
}
