package com.acme.edu.PSmartMessage;

import com.acme.edu.PSmartMessage.Typemessage.ByteMessage;
import com.acme.edu.PSmartMessage.Typemessage.IntMessage;
import com.acme.edu.PSmartMessage.Typemessage.StringMessage;
import com.acme.edu.PSmartMessage.interfacesAndabstracts.save.Message;

public class LoggerFacade {
    public static LoggerController controller
            = new SHALoggerController();
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

        controller.loggingProcess(new StringMessage(s));
    }


    public static void close()
    {
        controller.close();
    }
}
