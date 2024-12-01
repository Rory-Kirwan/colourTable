import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class colourTableTest {
    @Test
    public void constructorTest(){
        assertThrows(IllegalArgumentException.class, () -> new colourTable(-1));
        assertThrows(IllegalArgumentException.class, () -> new colourTable(3));
        assertThrows(IllegalArgumentException.class, () -> new colourTable(1));
        colourTable testConstruct = new colourTable(8);
        assertNotNull(testConstruct, "This object should not be null");
    }

    @Test
    public void setterTest(){
        colourTable testTable = new colourTable(4);
        Integer[] RGB = new Integer[] {250,150,60};

        //2 tests to test both versions of the setter method. using the same input array of RGB.

        testTable.colourTableSet(RGB);
        Integer[] getTestNoIndex = testTable.colourTableGet(0);
        assertNotNull(getTestNoIndex, "This item should not be null should be {250,150,60}");

        testTable.colourTableSet(RGB, 2);
        Integer[] getTestWithIndex = testTable.colourTableGet(2);
        assertNotNull(getTestWithIndex, "This item should not be null should be {250,150,60}");
    }

    @Test
    public void getterTest(){
        colourTable testTable = new colourTable(4);
        Integer[] RGB = new Integer[] {250,150,60};
        testTable.colourTableSet(RGB, 0);
        Integer[]  getterTest = testTable.colourTableGet(0);
        assertNotNull(getterTest, "This item should not be null should be {250,150,60}");
    }
}
