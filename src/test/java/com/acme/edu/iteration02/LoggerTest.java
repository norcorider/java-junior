package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.PSmartMessage.LoggerFacade;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion



    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        LoggerFacade.log("str 1");
        LoggerFacade.log(1);
        LoggerFacade.log(2);
        LoggerFacade.log("str 2");
        LoggerFacade.log(0);
        LoggerFacade.close();
        //endregion

        //region then
        assertSysoutContains(
            "str 1\n" +
            "3\n" +
            "str 2\n" +
            "0"
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        LoggerFacade.log("str 1");
        LoggerFacade.log(10);
        LoggerFacade.log(Integer.MAX_VALUE);
        LoggerFacade.log("str 2");
        LoggerFacade.log(0);
        LoggerFacade.close();
        //endregion

        //region then
        assertSysoutContains(
            "str 1\n" +
            "10\r\n" +
            Integer.MAX_VALUE + "\n" +
            "str 2\n" +
            "0"
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        LoggerFacade.log("str 1");
        LoggerFacade.log((byte)10);
        LoggerFacade.log((byte)Byte.MAX_VALUE);
        LoggerFacade.log("str 2");
        LoggerFacade.log(0);
        LoggerFacade.close();
        //endregion

        //region then
        assertSysoutContains(
            "str 1\n" +
            "10\n" +
            Byte.MAX_VALUE + "\n" +
            "str 2\n" +
            "0"
        );
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        LoggerFacade.log("str 1");
        LoggerFacade.log("str 2");
        LoggerFacade.log("str 2");
        LoggerFacade.log(0);
        LoggerFacade.log("str 2");
        LoggerFacade.log("str 3");
        LoggerFacade.log("str 3");
        LoggerFacade.log("str 3");
        LoggerFacade.close();
        //endregion

        //region then
        assertSysoutContains(
            "str 1\n" +
            "str 2 (x2)\n" +
            "0\n" +
            "str 2\n" +
            "str 3 (x3)"
        );
        //endregion
    }

}