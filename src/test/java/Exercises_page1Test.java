import org.junit.jupiter.api.Test;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class Exercises_page1Test {

    Exercises_page1 exercises = new Exercises_page1();


    @Test
    void exercise1ShouldReturnCorrect() {
        int[] noRepeats = {1,2,3,4,5,6,7,8,9};
        assertEquals(-1,exercises.exercise1(noRepeats));
        int[] repeat1 = {1,2,3,4,5,3,6,7,8,9};
        assertEquals(3,exercises.exercise1(repeat1));
        int[] repeat2 = {1,2,3,4,5,3,6,7,5,9};
        assertEquals(3,exercises.exercise1(repeat2));


    }
    @Test
    void exercise2(){
        int[] beforeSegregation = {1,2,4,6,3,5,6,8,7,1,9};
        Integer[] expected = {1,1,2,3,4,5,7,8,9};
        ArrayList<Integer> afterSegregation = exercises.exercise2(6,beforeSegregation);
        assertArrayEquals(expected,afterSegregation.toArray());
    }

    @Test
    void exercise3(){
        int[] arr = {1,2,3,4,3,2,1};
        assertEquals(0,exercises.exercise3(arr));
    }

    @Test
    void exercise4() {
        assertEquals(6,exercises.exercise4(84,18));
        assertEquals(1,exercises.exercise4(32,9));
        assertEquals(9,exercises.exercise4(36,9));
        assertEquals(6,exercises.exercise4(18,84));
        assertEquals(1,exercises.exercise4(9,32));
        assertEquals(9,exercises.exercise4(9,36));
        assertEquals(0,exercises.exercise4(0,0));
        assertEquals(0,exercises.exercise4(0,1));
        assertEquals(0,exercises.exercise4(1,0));
        assertEquals(5,exercises.exercise4(5,5));
    }

    @Test
    void exercise5(){
        int[] test = {1,2,3,4,3,5,6,3,8,7,9,34,53,3,3,3,8};
        int[] test2 = {1,1,-55,4,-55,5,6,-55,8,7,9,34,53,-55,3,3,-55};
        int[] test3 = {1,1,1,2,3,4,5};
        int[] test4 = {1,2,3,3,3,2,2,3};
        assertEquals(3,exercises.exercise5(test));
        assertEquals(-55,exercises.exercise5(test2));
        assertEquals(1,exercises.exercise5(test3));
        assertEquals(3,exercises.exercise5(test4));
    }

    @Test
    void exercise6(){
        Calendar day1 = new GregorianCalendar(2018,10,26);
        Calendar day2 = new GregorianCalendar(2016,10,26);
        Calendar day3 = new GregorianCalendar(2000,10,26);
        Calendar day4 = new GregorianCalendar(2001,1,26);

        assertEquals(299,exercises.exercise6(day1));
        assertEquals(300,exercises.exercise6(day2));
        assertEquals(300,exercises.exercise6(day3));
        assertEquals(26,exercises.exercise6(day4));
    }
    @Test
    void exercise7(){
        BigDecimal price1 = new BigDecimal("500");
        int rateAmount1 = 6;
        assertTrue("85.42".equals(exercises.exercise7(price1,rateAmount1).toString()));
        BigDecimal price2 = new BigDecimal("1125");
        int rateAmount2 = 22;
        assertTrue("53.69".equals(exercises.exercise7(price2,rateAmount2).toString()));
    }
}