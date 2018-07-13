import models.Manager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ManagerTest {

    Manager rodgers;


    @Before
    public void before(){
        rodgers = new Manager("Brendan Rodgers");
    }

    @Test
    public void canGetName(){
        assertEquals("Brendan Rodgers", rodgers.getName());
    }
}
