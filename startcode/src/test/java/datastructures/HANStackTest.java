package datastructures;

import nl.han.ica.datastructures.HANLinkedListItem;
import nl.han.ica.datastructures.HANStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HANStackTest {

    private HANStack<Integer> stack;


    @BeforeEach
    public void setup() {
        stack = new HANStack<>();
        stack.push(1);
        stack.push(2);

    }


    @Test
    public void testPop() {
        //Act
        HANLinkedListItem<Integer> popped = (HANLinkedListItem<Integer>) stack.pop(); // remove the first element
        HANLinkedListItem<Integer> peeked = (HANLinkedListItem<Integer>) stack.peek();

        //Assert
        assertEquals(2, popped.getValue()); // check if the size is 0
        assertEquals(1, peeked.getValue()); // check if the value of the first element is 1
    }

    @Test
    public void testPeek() {
        //Act
        HANLinkedListItem<Integer> peeked = (HANLinkedListItem<Integer>) stack.peek(); // get the first element

        //Assert
        assertEquals(2, peeked.getValue()); // check if the value of the first element is 2
    }

    @Test
    public void testPush() {
        //Act
        stack.push(3); // add 3 to the top of the stack
        HANLinkedListItem<Integer> peeked = (HANLinkedListItem<Integer>) stack.peek();

        //Assert
        assertEquals(3, peeked.getValue()); // check if the value of the first element is 3
    }
}
