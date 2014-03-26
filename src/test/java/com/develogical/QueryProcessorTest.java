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
        assertThat(queryProcessor.process("34534545:which of the following numbers is the largest: 30, 34, 115, 40"), containsString("115"));
        assertThat(queryProcessor.process("34ZE4ERFSDF:which of the following numbers is the largest: 590, 400, 97, 9"), containsString("590"));
        assertThat(queryProcessor.process("34R45EZRFED:which of the following numbers is the largest: 590, 400, 97, 9"), containsString("590"));
    }


   /* @Test
    public void Plus() throws  Exception{
        assertThat(queryProcessor.process("what is 19 plus 18"), containsString("37"));
        assertThat(queryProcessor.process("what is 2 plus 5"), containsString("7"));
    }
*/

}
