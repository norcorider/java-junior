package com.acme.edu;

import java.io.File;

import static com.acme.edu.Logger.*;
import static java.io.File.createTempFile;
import static java.io.File.separator;
import java.io.File;
import static java.lang.Math.abs;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Java Coding Style Convention (PDF)
 */
public class Logger {
    public static final String MY_SUPER_CONSTANT = "";

    public static int globalState = 0;
    public int instanceState = 0;


    public static int state = 0;//0,1,2,3,4

    public static int sumInt = 0;
    public static int IntegerBOUND = 0;

    public static byte sumByte = 0;
    public static byte ByteBOUND = 0;

    public static String resultString="";
    public static int EqStringCounter = 0;

    public static String ClassName = "";
    public static final String PRIM= "primitive: ";

    public static void printString(String string, int etalonCounter)
    {
        if(etalonCounter>1)
            System.out.println(string + " (x" +etalonCounter+ ")");
        else if(etalonCounter > 0)
            System.out.println(string);

    }
    public static void log(byte foramlMessage) {
        switch(state)
        {
            case 1://byte
            {
                if(ByteBOUND!=0)
                {
                    if(sumByte!=Byte.MAX_VALUE & sumByte!=Byte.MIN_VALUE)
                        System.out.println((byte)(sumByte - ByteBOUND));
                    System.out.println(ByteBOUND);
                    ByteBOUND = 0;
                    sumByte=0;
                }
                sumByte += foramlMessage;
                break;
            }
            case 2://integer
            {
                if(IntegerBOUND!=0)
                {
                    System.out.println(sumInt - IntegerBOUND);
                    System.out.println(IntegerBOUND);
                    IntegerBOUND = 0;
                }
                else{
                    System.out.println(sumInt);
                }
                sumInt = 0;
                sumByte = foramlMessage;
                break;
            }
            case 3://string
            {
                if(EqStringCounter>1)
                    System.out.println(resultString+" (x"+EqStringCounter+")");
                else
                    System.out.println(resultString);
                EqStringCounter = 0;
                sumByte=foramlMessage;
                break;
            }
            default://start
            {
                sumByte=foramlMessage;
            }
        }
        switch (foramlMessage)
        {
            case Byte.MAX_VALUE:
            {
                ByteBOUND = Byte.MAX_VALUE;
                break;
            }
            case Byte.MIN_VALUE:
            {
                ByteBOUND = Byte.MIN_VALUE;
                break;
            }
        }
        state = 1;

    }
    public static void log(int foramlMessage) {
        switch(state)
        {
            case 1://byte
            {
                if(ByteBOUND!=0)
                {
                    System.out.println((byte)(sumByte - ByteBOUND));
                    System.out.println(ByteBOUND);
                    ByteBOUND = 0;
                }
                else{
                    System.out.println(sumByte);
                }
                sumByte = 0;
                sumInt = foramlMessage;
                break;
            }
            case 2://Integer
            {
                if(IntegerBOUND!=0)
                {
                    if(sumInt!=Integer.MAX_VALUE & sumInt!=Integer.MIN_VALUE)
                        System.out.println(sumInt - IntegerBOUND);
                    System.out.println(IntegerBOUND);
                    IntegerBOUND = 0;
                    sumInt=0;
                }
                sumInt+=foramlMessage;
                break;
            }
            case 3://string
            {
                if(EqStringCounter>1)
                    System.out.println(resultString+" (x"+EqStringCounter+")");
                else
                    System.out.println(resultString);
                EqStringCounter = 0;
                sumInt = foramlMessage;
                break;
            }
            default://start
            {
                sumInt = foramlMessage;
            }
        }
        switch (foramlMessage)
        {
            case Integer.MAX_VALUE:
            {
                IntegerBOUND = Integer.MAX_VALUE;
                break;
            }
            case Integer.MIN_VALUE:
            {
                IntegerBOUND = Integer.MIN_VALUE;
                break;
            }
        }
        state = 2;
    }
    public static void log(String foramlMessage) {
        switch(state)
        {
            case 1://byte
            {
                if(ByteBOUND!=0)
                {
                    System.out.println((byte)(sumByte - ByteBOUND));
                    System.out.println((byte)ByteBOUND);
                    ByteBOUND = 0;
                }
                else {
                    System.out.println(sumByte + "");
                }
                sumByte = 0;
                resultString = foramlMessage;
                EqStringCounter = 1;
                break;
            }
            case 2://Integer
            {
                if(IntegerBOUND!=0)
                {
                    System.out.println(sumInt - IntegerBOUND);
                    System.out.println(IntegerBOUND);
                    IntegerBOUND = 0;
                }
                else
                {
                    System.out.println(sumInt+"");
                }
                sumInt=0;
                resultString=foramlMessage;
                EqStringCounter = 1;
                break;
            }
            case 3://string
            {
                if(resultString.equals(foramlMessage))
                {
                    EqStringCounter++;
                }
                else
                {
                    if(EqStringCounter>1) {
                        System.out.println(resultString + " (x" + EqStringCounter + ")");
                    }
                    else
                    {
                        System.out.println(resultString);
                    }
                    resultString = foramlMessage;
                    EqStringCounter = 1;
                }
                break;
            }
            default://start
            {
                resultString = foramlMessage;
                EqStringCounter = 1;
            }
        }
        state = 3;
    }
    public static void close() {
        switch(state)
        {
            case 1:
            {
                /*if(ByteBOUND!=0)
                {
                    System.out.println((byte)(sumByte - ByteBOUND));
                    System.out.println((byte)ByteBOUND);
                }
                else*/
                    System.out.println((byte)sumByte);
                break;
            }
            case 2:
            {
                /*if(IntegerBOUND!=0)
                {
                    System.out.println(sumInt - IntegerBOUND);
                    System.out.println(IntegerBOUND);
                }
                else*/
                    System.out.println(sumInt);
                break;
            }
            case 3:
            {
                if(EqStringCounter>1) {
                    System.out.println(resultString + " (x" + EqStringCounter + ")");
                }
                else
                {
                    System.out.println(resultString);
                }
                break;
            }
        }
        state = 0;
        sumInt=0;
        sumByte=0;
        resultString="";
        EqStringCounter=0;
        IntegerBOUND=0;
        ByteBOUND=0;
    }

    private static void printMV(int maxValue) {
        System.out.println(maxValue+"");
    }

    public static void log(char foramlMessage) {
        String etalon = (new Character(foramlMessage)).getClass().toString();
        if(!ClassName.equals(etalon)) {
            ClassName = etalon;
            System.out.println("char: \r\n" + foramlMessage);
        }else {
            System.out.println(foramlMessage);
        }
    }


    public static void log(Object obj) {
        String etalon = obj.getClass().toString();
        if(!ClassName.equals(etalon)) {
            ClassName = etalon;
            System.out.println("reference: \r\n" + '@');
        }else {
            System.out.println('@');
        }
    }

    public static void log(boolean foramlMessage) {
        String etalon = new Boolean(foramlMessage).getClass().toString();
        if(!ClassName.equals(etalon)) {
            ClassName = etalon;
            System.out.println("primitive: \r\n" + foramlMessage);
        }else {
            System.out.println(foramlMessage);
        }
    }

    /**
     * JavaDoc
     * <bold>kfdfgjkhdgjfdhg</bold>
     *
     * @param message РАПРапрдлпао апдлапорда рдаплро
     */
    /*public static void log(byte message) {
        System.out.println("primitive: " + message);
    }*/

    /**
     * public API
     */
   /* public static void log(String message) {
        System.out.println(message);
    }*/


    public static void main(String... args) {
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);
        Logger.close();
        Logger.log("str 1");
        Logger.log(10);
        Logger.log(Integer.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.close();
        Logger.log("str 1");
        Logger.log((byte)10);
        Logger.log((byte)Byte.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.close();
        Logger.log("str 1");
        Logger.log("str 2");
        Logger.log("str 2");
        Logger.log(0);
        Logger.log("str 2");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.close();

//        Main.main();
//        Main.counter = 1;
    }
}
/*
class Main {
    public static int counter = 0;

    static {
        System.out.println("Hello!");
        counter = 1;
    }

    public void m() {

    }

    /**
     * java -Xss2m -Xms4G -Xmx4G
     */
/*
    public static void main(String[] args) {
        int local = 0;
        main(new String[] {});

        int factualMessage = 1;
        Object o = new Object();

        System.out.println(factualMessage);
    }
}
*/