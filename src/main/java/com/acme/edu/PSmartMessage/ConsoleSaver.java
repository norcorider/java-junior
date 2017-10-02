package com.acme.edu.PSmartMessage;

import com.acme.edu.PController.interfaces.save.LoggerSaver;

public class ConsoleSaver implements LoggerSaver {
    private String log;
    public ConsoleSaver(String l)
    {
        log = l;
    }
    @Override
    public void save() {

        System.out.println(log);
    }
}
