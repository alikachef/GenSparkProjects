import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GuessNumberTest {

    @Test
    void getAnser() {
        assertEquals("1", GuessNumber.getnumber(1));
        assertEquals("2", GuessNumber.getnumber(2));
        assertEquals("3", GuessNumber.getnumber(3));
        assertEquals("4", GuessNumber.getnumber(4));
        assertEquals("5", GuessNumber.getnumber(5));
        assertEquals("6", GuessNumber.getnumber(6));
        assertEquals("7", GuessNumber.getnumber(7));
        assertEquals("8", GuessNumber.getnumber(8));
        assertEquals("9", GuessNumber.getnumber(9));
        assertEquals("10", GuessNumber.getnumber(10));
        assertEquals("11", GuessNumber.getnumber(11));
        assertEquals("12", GuessNumber.getnumber(12));
        assertEquals("13", GuessNumber.getnumber(13));
        assertEquals("14", GuessNumber.getnumber(14));
        assertEquals("15", GuessNumber.getnumber(15));
        assertEquals("16", GuessNumber.getnumber(16));
        assertEquals("17", GuessNumber.getnumber(17));
        assertEquals("18", GuessNumber.getnumber(18));
        assertEquals("19", GuessNumber.getnumber(19));
        assertEquals("20", GuessNumber.getnumber(20));
    }

}