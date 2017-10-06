package com.acme.edu.PSmartMessage;

import com.acme.edu.PSmartMessage.interfacesAndabstracts.save.LoggerSaver;

public class ConsoleSaver implements LoggerSaver {
    private String log;
    public ConsoleSaver(String l)
    {
        log = l;
    }
    public ConsoleSaver()
    {
        log = "";
    }

    public void setLog(String log) {
        this.log = log;
    }

    @Override
    public void save() {
        //System.out.println();
        System.out.print(log);
    }
}
