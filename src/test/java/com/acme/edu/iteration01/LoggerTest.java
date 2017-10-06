package com.acme.edu.iteration01;

import com.acme.edu.Logger;
import com.acme.edu.PSmartMessage.LoggerFacade;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.*;

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
    public void shouldLogInteger() throws IOException {

        //region when
        LoggerFacade.log(-1);
        LoggerFacade.log(2);
        LoggerFacade.log(3);
        LoggerFacade.close();
        //endregion


        //region then

        assertSysoutContains("4");
        assertSysoutEquals("4\n");

        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        //region when
        LoggerFacade.log((byte) 1);
        LoggerFacade.log((byte) 0);
        LoggerFacade.log((byte) -1);
        LoggerFacade.close();
        //endregion

        //region then
        assertSysoutContains("0\n");
        //endregion
    }



    @Test
    public void shouldLogChar() throws IOException {
        //region when
        LoggerFacade.log('a');
        LoggerFacade.log('b');
        LoggerFacade.close();
        //endregion

        //region then
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }


    @Test
    public void shouldLogString() throws IOException {
        //region when
        LoggerFacade.log("test string 1");
        LoggerFacade.log("other str");
        LoggerFacade.close();
        //endregion

        //region then
        assertSysoutContains("test string 1\n");
        assertSysoutContains("other str\n");
        //endregion
    }


    @Test
    public void shouldLogBoolean() throws IOException {
        //region when
        LoggerFacade.log(true);
        LoggerFacade.log(false);
        LoggerFacade.close();
        //endregion

        //region then
        assertSysoutContains("true");
        assertSysoutContains("false");
        //endregion
    }

    @Test
    public void shouldLogReference() throws IOException {
        //region when
        LoggerFacade.log(new Object());
        LoggerFacade.close();
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }
}
