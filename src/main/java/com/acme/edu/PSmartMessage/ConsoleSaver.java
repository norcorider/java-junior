package com.acme.edu.PSmartMessage;

import com.acme.edu.PSmartMessage.interfacesAndabstracts.save.LoggerSaver;

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
