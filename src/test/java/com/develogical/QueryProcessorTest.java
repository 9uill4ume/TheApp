package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.StringContains.containsString;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutProgramming() throws Exception {
        assertThat(queryProcessor.process("programming"), containsString("computing"));
    }

    @Test
    public void Largest() throws  Exception{
        assertThat(queryProcessor.process("34534545: which of the following numbers is the largest: 30, 34, 115, 40"), containsString("115"));
        assertThat(queryProcessor.process("34ZE4ERFSDF: which of the following numbers is the largest: 590, 400, 97, 9"), containsString("590"));
        assertThat(queryProcessor.process("34R45EZRFED: which of the following numbers is the largest: 590, 400, 97, 9"), containsString("590"));
    }


    @Test
    public void Plus() throws  Exception{
        assertThat(queryProcessor.process("34R45EZRFED: what is 19 plus 18"), containsString("37"));
        assertThat(queryProcessor.process("34R45EZRFED: what is 2 plus 5"), containsString("7"));
    }

    @Test
    public void Minus() throws  Exception{
        assertThat(queryProcessor.process("34R45EZRFED: what is 19 minus 18"), containsString("1"));
        assertThat(queryProcessor.process("34R45EZRFED: what is 2 minus 5"), containsString("-3"));
    }
 @Test
    public void Power() throws  Exception{
        assertThat(queryProcessor.process("34R45EZRFED: what is 2 to the power of 3"), containsString("8"));
    }

    @Test
     public void Multiply() throws  Exception{
        assertThat(queryProcessor.process("34R45EZRFED: what is 6 multiplied by 2 "), containsString("12"));
        assertThat(queryProcessor.process("34R45EZRFED: what is 6 multiplied by 3 "), containsString("18"));
    }


    @Test
    public void Square() throws  Exception{
        assertThat(queryProcessor.process("34R45EZRFED: which of the following numbers is both a square and a cube: 100, 652 "), containsString(""));
        assertThat(queryProcessor.process("34R45EZRFED: which of the following numbers is both a square and a cube: 100, 1000000 "), containsString("1000000"));
    }


    @Test
    public void David() throws  Exception{
        assertThat(queryProcessor.process("34R45EZRFED: who is the Prime Minister of Great Britain"), containsString("David Cameron"));
    }

    @Test
    public void Prime() throws  Exception{
        assertThat(queryProcessor.process("34R45EZRFED:  which of the following numbers are primes: 381, 317, 474, 97 "), containsString("474"));
        assertThat(queryProcessor.process("34R45EZRFED:  which of the following numbers are primes: 3, 317, 97 "), containsString("3"));
        assertThat(queryProcessor.process("34R45EZRFED:  which of the following numbers are primes: 3, 317, 97 "), containsString("3"));
    }

    @Test
    public void Fibo() throws  Exception{
        assertThat(queryProcessor.process("34R45EZRFED: what is the 9th number in the Fibonacci sequence "), containsString("34"));
    }


    @Test
    public void math() throws  Exception{
        assertThat(queryProcessor.process("34R45EZRFED: what is 10 multiplied by 10 plus 8"), containsString("108"));
        assertThat(queryProcessor.process("34R45EZRFED: what is 10 minus 7 plus 8"), containsString("11"));
        assertThat(queryProcessor.process("34R45EZRFED: what is 6 plus 6 plus 1"), containsString("13"));
        assertThat(queryProcessor.process("34R45EZRFED: what is 6 plus 6 plus 2"), containsString("14"));
        assertThat(queryProcessor.process("34R45EZRFED: what is 6 plus 6 multiplied by 2"), containsString("18"));
    }
}

