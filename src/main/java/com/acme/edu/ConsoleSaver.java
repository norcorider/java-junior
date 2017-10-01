package com.acme.edu;

import com.acme.edu.interfaces.save.LoggerSaver;

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
