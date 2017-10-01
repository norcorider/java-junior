package com.acme.edu;

import com.acme.edu.interfaces.accumulate.LoggerAccumulate;
import com.acme.edu.interfaces.format.LoggerFormat;
import com.acme.edu.interfaces.save.LoggerSaver;

import java.util.ArrayList;
import java.util.Map;

public class LoggerController {

    private LoggerSaver sav;
    private LoggerFormat form;
    private LoggerAccumulate TargetAcc;
    //private LoggerAccumulate TargetACC;


    private int mode;
    private int deltaI;
    private byte deltaB;
    private String deltaS;

    ArrayList setofAcc;
    private String log;

    public LoggerController()
    {
        mode = 0;
        deltaI = 0;
        deltaB = 0;
        deltaS = "";
        setofAcc = new ArrayList<LoggerAccumulate>();
        setofAcc.add(new ByteAcc());
        setofAcc.add(new IntAcc());
        setofAcc.add(new StringAcc());

    }


    public void setDS(String DS) {
        this.deltaS = DS;
    }

    public void setDB(byte DB) {
        this.deltaB = DB;
    }

    public void setDI(int DI) {
        this.deltaI = DI;
    }



    public void LoggingProcess(int mode)
    {
        switch(this.mode)//старое состояние
        {
            case 1:
            {
                TargetAcc = (ByteAcc)setofAcc.get(0);
                break;
            }
            case 2:
            {
                TargetAcc = (IntAcc)setofAcc.get(1);
                break;
            }
            case 3:
            {
                TargetAcc = (StringAcc)setofAcc.get(2);
                break;
            }
            default:
            {

            }
        }
        changeState(mode);
    }
    private void changeState(int mode)
    {
        this.mode = mode;
    }

    public void end() {
        sav = new ConsoleSaver(log);
        sav.save();
        setofAcc.clear();
    }
}
