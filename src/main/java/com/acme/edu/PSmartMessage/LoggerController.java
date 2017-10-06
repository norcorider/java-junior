package com.acme.edu.PSmartMessage;

import com.acme.edu.Logger;
import com.acme.edu.PSmartMessage.interfacesAndabstracts.save.LoggerSaver;
import com.acme.edu.PSmartMessage.Exceptions.LoggerSaverException;
import com.acme.edu.PSmartMessage.Exceptions.OutofByteBoundException;
import com.acme.edu.PSmartMessage.Exceptions.OutofIntegerBoundException;
import com.acme.edu.PSmartMessage.Typemessage.ByteMessage;
import com.acme.edu.PSmartMessage.Typemessage.IntMessage;
import com.acme.edu.PSmartMessage.Typemessage.StringMessage;
import com.acme.edu.PSmartMessage.interfacesAndabstracts.save.Message;
import com.sun.org.apache.xerces.internal.impl.dv.DatatypeException;

import java.util.ArrayList;

public abstract class LoggerController {

    public String log;
    public LoggerSaver saver;
    public int classmode;
    public static long sum;
    public Message oldMsg;

    public LoggerController(LoggerSaver sav)
    {
        log ="";
        classmode = 0;
        sum = 0;
        oldMsg=null;
        saver = sav;
    }

    public void SetOldMessage(Message old)
    {
        oldMsg=old;
    }

    public void loggingProcess(Message msg)
    {
        msg.setM(oldMsg);
        String tmp = null;
        try {
            tmp = msg.iteration(classmode);
        } catch (OutofByteBoundException e) {
            if((int)((ByteMessage)msg).getDelta() + oldMsg.sum > Byte.MAX_VALUE) {
                tmp = Byte.MAX_VALUE + "\n" + ((int) ((ByteMessage) msg).getDelta() + oldMsg.sum - Byte.MAX_VALUE);
            }
            if((int)((ByteMessage)msg).getDelta() + oldMsg.sum < Byte.MIN_VALUE)
                tmp = Byte.MIN_VALUE + "\n" + ((int) ((ByteMessage) msg).getDelta() + oldMsg.sum - Byte.MIN_VALUE);
            //e.printStackTrace();
        } catch (OutofIntegerBoundException e) {
            if((long)((IntMessage)msg).getDelta() + oldMsg.sum > Integer.MAX_VALUE) {
                tmp = Integer.MAX_VALUE + "\n" + ((long) ((IntMessage) msg).getDelta() + oldMsg.sum - Integer.MAX_VALUE);
            }
            if((long)((IntMessage)msg).getDelta() + oldMsg.sum < Integer.MIN_VALUE) {
                tmp = Integer.MIN_VALUE + "\n" + ((long) ((IntMessage) msg).getDelta() + oldMsg.sum - Integer.MIN_VALUE);
            }

            //e.printStackTrace();
        }
        if(!tmp.equals(""))
            log += tmp + "\n";

        msg.clearM();
        SetOldMessage(msg);
        changemode(msg);

    }

    private void changemode(Message msg) {
        if(msg instanceof ByteMessage)
        {
            classmode= 1;
            return;
        }
        if(msg instanceof IntMessage)
        {
            classmode = 2;
            return;
        }
        if(msg instanceof StringMessage)
        {
            classmode = 3;
            return;
        }
    }

    public void close()
    {
        if(oldMsg instanceof ByteMessage || oldMsg instanceof IntMessage)
        {
            log+=oldMsg.getSum() +"\n";
        }else if(oldMsg instanceof StringMessage)
        {
            if(oldMsg.getSum()>1)
                log+= ((StringMessage) oldMsg).getStr() + " (x"+oldMsg.getSum()+")"+"\n";
            else
                log+= ((StringMessage) oldMsg).getStr() + "\n";
        }
        else
            {
            }
        //saver = new FileSaver();
        //saver = new ConsoleSaver(log);
        ((ConsoleSaver)saver).setLog(log);
        try {
            saver.save();
        } catch (LoggerSaverException e) {
            e.printStackTrace();
        }
    }
    public abstract void encode(String log);

}
