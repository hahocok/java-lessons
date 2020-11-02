package lesson6pro;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainTest {

    Main main;

    @Before
    public void init() {
        main = new Main();
    }

    // задание 2
    @Test(expected = RuntimeException.class)
    public void test1() {
        final int[] src = new int[] {1, 2, 3};
        main.getNumbersAfterSeparator(src, 4);
    }

    @Test
    public void test2() {
        final int[] src = new int[] {1, 2, 4, 4, 2, 3, 4, 1, 7};
        final int[] result = new int[] {1, 7};

        Assert.assertArrayEquals(result, main.getNumbersAfterSeparator(src, 4));
    }

    @Test
    public void test3() {
        final int[] src = new int[] {1, 2, 4, 4, 2, 3, 5, 1, 7};
        final int[] result = new int[] {2, 3, 5, 1, 7};

        Assert.assertArrayEquals(result, main.getNumbersAfterSeparator(src, 4));
    }

    @Test
    public void test4() {
        final int[] src = new int[] {4, 2, 3};
        final int[] result = new int[] {2, 3};

        Assert.assertArrayEquals(result, main.getNumbersAfterSeparator(src, 4));
    }

    @Test
    public void test5() {
        final int[] src = new int[] {1, 2, 4, 4};
        final int[] result = new int[] {};

        Assert.assertArrayEquals(result, main.getNumbersAfterSeparator(src, 4));
    }

    // задание 3

    @Test
    public void test6() {
        final int firstNumber = 1;
        final int secondNumber = 4;
        int[] arrForCheck = {3, 2, 3, 3, 2, 3, 2, 3, 7};

        Assert.assertFalse(main.checkArr(arrForCheck, firstNumber, secondNumber));
    }

    @Test
    public void test7() {
        final int firstNumber = 1;
        final int secondNumber = 4;
        int[] arrForCheck = {1, 2, 4, 4, 2, 3, 4, 1, 7};

        Assert.assertTrue(main.checkArr(arrForCheck, firstNumber, secondNumber));
    }

    @Test
    public void test8() {
        final int firstNumber = 1;
        final int secondNumber = 4;
        int[] arrForCheck = {3, 2, 1, 3, 2, 3, 2, 3, 7};

        Assert.assertFalse(main.checkArr(arrForCheck, firstNumber, secondNumber));
    }

    @Test
    public void test9() {
        final int firstNumber = 1;
        final int secondNumber = 4;
        int[] arrForCheck = {3, 2, 4, 3, 2, 3, 2, 3, 7};

        Assert.assertFalse(main.checkArr(arrForCheck, firstNumber, secondNumber));
    }
}