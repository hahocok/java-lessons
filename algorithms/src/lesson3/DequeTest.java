package lesson3;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DequeTest {

    private Deque<Integer> deque;

    @Before
    public void setUp() {
        deque = new Deque<>(5);
    }

    @Test
    public void insertLeft() {
        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertLeft(3);
        deque.insertLeft(4);
        deque.insertLeft(5);

        Assert.assertEquals(deque.size(), 5);

        boolean result = deque.insertLeft(6);
        Assert.assertFalse(result);
        Assert.assertEquals(deque.size(), 5);
    }

    @Test
    public void insertRight() {
        deque.insertRight(1);
        deque.insertRight(2);
        deque.insertRight(3);
        deque.insertRight(4);
        deque.insertRight(5);

        Assert.assertEquals(deque.size(), 5);

        boolean result = deque.insertLeft(6);
        Assert.assertFalse(result);
        Assert.assertEquals(deque.size(), 5);
    }

    @Test
    public void removeLeft() {
        deque.insertRight(1);
        deque.insertRight(2);
        deque.insertRight(3);
        deque.insertRight(4);
        deque.insertRight(5);

        int value = deque.removeLeft();
        Assert.assertEquals(value, 1);

        value = deque.removeLeft();
        Assert.assertEquals(value, 2);

        value = deque.removeLeft();
        Assert.assertEquals(value, 3);

        value = deque.removeLeft();
        Assert.assertEquals(value, 4);

        value = deque.removeLeft();
        Assert.assertEquals(value, 5);
    }

    @Test
    public void removeRight() {
        deque.insertRight(1);
        deque.insertRight(2);
        deque.insertRight(3);
        deque.insertRight(4);
        deque.insertRight(5);

        int value = deque.removeRight();
        Assert.assertEquals(value, 5);

        value = deque.removeRight();
        Assert.assertEquals(value, 4);

        value = deque.removeRight();
        Assert.assertEquals(value, 3);

        value = deque.removeRight();
        Assert.assertEquals(value, 2);

        value = deque.removeRight();
        Assert.assertEquals(value, 1);
    }

    @After
    public void tearDown() {
        deque = null;
    }
}