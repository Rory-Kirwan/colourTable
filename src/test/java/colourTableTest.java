import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        //Set some universal testing variables
        colourTable testTable = new colourTable(8);
        Integer[] RGB = new Integer[] {250, 150, 60};
        //2 tests to test both versions of the setter method. using the same input array of RGB.

        testTable.colourTableSet(RGB);      //This method should insert at index 0 as it will pick the first available
        Integer[] getTestNoIndex = testTable.colourTableGet(0);
        assertNotNull(getTestNoIndex, "This item should not be null should be {250,150,60}");

        testTable.colourTableSet(RGB, 2);   //This method will insert into index 2 as it overwrites the non-specific index method
        Integer[] getTestWithIndex = testTable.colourTableGet(2);
        assertNotNull(getTestWithIndex, "This item should not be null should be {250,150,60}");
    }

    @Test
    public void getterTest(){
        //Set some universal testing variables
        colourTable testTable = new colourTable(8);
        Integer[] RGB = new Integer[] {250, 150, 60};

        testTable.colourTableSet(RGB, 0);
        Integer[]  getterTest = testTable.colourTableGet(0);
        assertNotNull(getterTest, "This item should not be null should be {250,150,60}");
    }

    @Test
    public void deleteTest(){
        //Set some universal testing variables
        colourTable testTable = new colourTable(8);
        Integer[] RGB = new Integer[] {250, 150, 60};
        testTable.colourTableSet(RGB);
        testTable.colourTableSet(RGB,3);

        // Check for the item in index 3 then delete and check again
        Integer[] testingVar = testTable.colourTableGet(3);
        assertNotNull(testingVar, "This item should exist right now");

        testTable.DelColour(3);
        Integer[] deletedValue = testTable.colourTableGet(3);
        assertNull(deletedValue, "this item should be null now");
    }
}
