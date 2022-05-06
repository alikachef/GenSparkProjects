import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DragonProjectTest {

    @Test
    void getUserChoice(){
        assertEquals("Cave 1 was selected, user died", DragonProject.getUserChoice(1), "Success" );
        assertEquals("Cave 2 was selected, user lived", DragonProject.getUserChoice(2), "Succsess");

    }

    @Test
    void level2(){
        assertEquals("Cave 1 was selected, user died", DragonProject.level2(1), "Success");
        assertEquals("Cave 2 was selected, user lived", DragonProject.level2(2), "Success");
    }


}