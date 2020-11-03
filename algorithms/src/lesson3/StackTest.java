package lesson3;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackTest {
    private Stack<Integer> stack;

    @Before
    public void before() {
        stack = new Stack<>(4);
    }

    @Test
    public void push() {
        stack.push(1);
        Assert.assertEquals(stack.size(), 1);

        stack.push(2);
        Assert.assertEquals(stack.size(), 2);

        stack.push(3);
        Assert.assertEquals(stack.size(), 3);

        stack.push(3);
        Assert.assertEquals(stack.size(), 4);

        final boolean result = stack.push(5);
        Assert.assertFalse(result);

        Assert.assertEquals(stack.size(), 4);
    }

    @Test
    public void pop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        int popResult = stack.pop();

        Assert.assertEquals(popResult, 4);
        Assert.assertEquals(stack.size(), 3);

        popResult = stack.pop();

        Assert.assertEquals(popResult, 3);
        Assert.assertEquals(stack.size(), 2);

        popResult = stack.pop();

        Assert.assertEquals(popResult, 2);
        Assert.assertEquals(stack.size(), 1);

        popResult = stack.pop();

        Assert.assertEquals(popResult, 1);
        Assert.assertEquals(stack.size(), 0);
    }

    @Test
    public void peek() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        int peekResult = stack.peek();

        Assert.assertEquals(peekResult, 4);
        Assert.assertEquals(stack.size(), 4);
    }

    @After
    public void after() {
        stack = null;
    }
}