package com.acme.edu.PController.interfaces;

public class LoggerFacade {
    public static LoggerController controller
            = new LoggerController();

    public static void log(byte b)
    {
        controller.setDB(b);
        controller.LoggingProcess(1);
    }
    public static void log(int i)
    {
        controller.setDI(i);
        controller.LoggingProcess(2);
    }
    public static void log(String s)
    {
        controller.setDS(s);
        controller.LoggingProcess(3);
    }


    public static void close()
    {
        controller.end();
        controller = new LoggerController();
    }
}
