package datastructures;

import nl.han.ica.datastructures.HANLinkedList;
import nl.han.ica.datastructures.HANLinkedListItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HANLinkedListTest {
    private HANLinkedList<Integer> list;

    @BeforeEach
    public void setup() {
        list = new HANLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
    }

    @Test
    public void testDelete() {
        //Act
        list.delete(1); // delete the second element

        //Assert
        assertEquals(2, list.getSize()); // check if the size is decreased by 1
        assertEquals(3, list.getValue(0)); // check if the first element is still the same
        assertEquals(1, list.getValue(1)); // check if the second element is now the last element
    }

    @Test
    public void testAddfirst() {

        //Act
        list.addFirst(4); // add 4 to the front of the list
        //As
        assertEquals(4, list.getValue(0)); // check if the first element is now 4
        assertEquals(3, list.getValue(1)); // check if the second element is still 3
        assertEquals(2, list.getValue(2)); // check if the third element is still 2
        assertEquals(1, list.getValue(3)); // check if the fourth element is still 1
    }

    @Test
    public void testClear() {
        //Act
        list.clear(); // clear the list

        //Assert
        assertEquals(0, list.getSize()); // check if the size is 0
    }

    @Test
    public void testGet() {
        //Act
        int item = list.getValue(1); // get the second element

        //Assert
        assertEquals(2, item); // check if the value of the second element is 2
    }
}



