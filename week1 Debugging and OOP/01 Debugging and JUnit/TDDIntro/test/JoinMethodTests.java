import static org.junit.Assert.*;

import org.junit.Test;


public class JoinMethodTests {

    @Test
    public void testJoiningMixedTypes() {
        assertEquals("Днес видях 5 ходещи медузи", JoinMethod.stichMeUp(" ", "Днес", "видях", 5, "ходещи", "медузи"));
    }
    
    @Test
    public void testNoFixedLengthOfArguments() {
        assertEquals("::::) that's Spiridon The Spider!", JoinMethod.stichMeUp(") ", "::::", "that's Spiridon The Spider!"));
        assertEquals(" :} :} :} :} :} :} seagulls everywhere so beware :} :} :} :} :} :} ",
                JoinMethod.stichMeUp(":}", " ", " ", " ", " ", " ", " ", " seagulls everywhere so beware ", " ", " ", " ", " ", " ", " "));
    }

    @Test
    public void testJoiningStrings() {
        assertEquals("Turtles love shrimps!", JoinMethod.stichMeUp(" ", "Turtles", "love", "shrimps!"));
    }
    
    @Test
    public void testJoiningObjects() {
        final class Seagull {
            public String toString() {
                return "Squawk!";
            }
        }
        
        assertEquals("Squawk! Squawk!", JoinMethod.stichMeUp(" ", new Seagull(), new Seagull()));
    }
    
    @Test
    public void testJoiningPrimitives() {
        assertEquals("42", JoinMethod.stichMeUp("", 4, 2));
    }
}
