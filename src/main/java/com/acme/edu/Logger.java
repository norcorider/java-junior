package com.acme.edu;

public class Logger {

    public static final String MY_SUPER_CONSTANT = "";

    public static int globalState = 0;
    public int instanceState = 0;

    public static String etalonString = null;
    public static int etalonCounter = 0;

    public static int sum = 0;
    public static boolean isSumExist=false;
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

        if(etalonString!=null)//была строка - выводим в out
        {
            if(foramlMessage == Byte.MAX_VALUE)
            {
                printString(etalonString, etalonCounter);
                printMV(Byte.MAX_VALUE);
            }else {
                printString(etalonString, etalonCounter);
                etalonString = null;
                etalonCounter = 0;
                sum = foramlMessage;
                isSumExist = true;
            }
        }
        else {//не было строки
            if(foramlMessage == Byte.MAX_VALUE)
            {
                if(isSumExist) {
                    System.out.println(sum + "");
                }
                printMV(Byte.MAX_VALUE);
                sum=0;
                isSumExist = false;
            }
            else{
                sum+=foramlMessage;
            }
        }
    }

    private static void printMV(int maxValue) {
        System.out.println(maxValue+"");
    }

    public static void log(int foramlMessage) {

        if(etalonString!=null)//была строка - выводим в out
        {
            if(foramlMessage == Integer.MAX_VALUE)
            {
                printString(etalonString, etalonCounter);
                printMV(Integer.MAX_VALUE);
            }else {
                printString(etalonString, etalonCounter);
                etalonString = null;
                etalonCounter = 0;
                sum = foramlMessage;
                isSumExist = true;
            }
        }
        else {//не было строки
            if(foramlMessage == Integer.MAX_VALUE)
            {
                if(isSumExist) {
                    System.out.println(sum + "");
                }
                printMV(Integer.MAX_VALUE);
                sum=0;
                isSumExist = false;
            }
            else{
                sum+=foramlMessage;
            }
        }
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
    public static void log(String foramlMessage) {

        if (sum == -1)
        {
            //System.out.println(foramlMessage);
            etalonString = foramlMessage;
            etalonCounter = 1;
            sum = 0;
        }
        else if(sum == 0)
        {
            if(etalonString == null)
            {
                etalonString = foramlMessage;
                etalonCounter++;
            }else if(!foramlMessage.equals(etalonString))
            {
                printString(etalonString,etalonCounter);
                etalonString = foramlMessage;
                etalonCounter = 1;
            }else
            {
                etalonCounter++;
            }

        }
        else {
            System.out.println(sum);
            etalonString=foramlMessage;
            etalonCounter = 1;
            //System.out.println(foramlMessage);
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


    public static void main(String... args) {
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);

    }
}


