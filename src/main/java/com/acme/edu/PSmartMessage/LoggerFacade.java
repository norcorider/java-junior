package com.acme.edu.PSmartMessage;

import com.acme.edu.PSmartMessage.Exceptions.MyStringNullException;
import com.acme.edu.PSmartMessage.Typemessage.*;
import com.acme.edu.PSmartMessage.interfacesAndabstracts.save.Message;

public class LoggerFacade {
    public static LoggerController controller
            = new SHALoggerController(new ConsoleSaver());
    /*public static Message im = new IntMessage(0);
    public static Message bm = new ByteMessage((byte)0);
    public static Message sm = new StringMessage("");*/


    public static void log(byte b)
    {

        controller.loggingProcess(new ByteMessage(b));
    }

    public static void log(int i)
    {
        controller.loggingProcess(new IntMessage(i));
    }
    public static void log(String s)
    {
        StringMessage sm = null;
        try {
            sm = new StringMessage(s);
        }catch(MyStringNullException e)
        {
            sm = new StringMessage();
            sm.setS("defaultstring");
        }
        controller.loggingProcess(sm);
    }
    public static void log(char ch)
    {
        controller.loggingProcess(new CharMessage(ch));
    }
    public static void log(boolean b)
    {
        controller.loggingProcess(new BoolMessage(b));
    }
    public static void log(Object o)
    {
        controller.loggingProcess(new ObjectMessage(o));
    }
    public static void log(int[] arr)
    {
        controller.loggingProcess(new IntArrayMessage(arr));
    }



    public static void close()
    {
        controller.close();
    }
}
