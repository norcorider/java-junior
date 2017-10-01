package com.acme.edu;

import com.acme.edu.interfaces.accumulate.LoggerAccumulate;
import com.acme.edu.interfaces.format.LoggerFormat;
import com.acme.edu.interfaces.save.LoggerSaver;

public class LoggerController {

    public LoggerSaver sav;
    public LoggerFormat form;
    public LoggerAccumulate accum;
    public void LoggingProcess()
    {

    }

    private void end() {
        sav.save();
    }
}
