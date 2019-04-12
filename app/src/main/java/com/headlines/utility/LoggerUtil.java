package com.headlines.utility;

import android.util.Log;

public class LoggerUtil {

    private LoggerUtil(){
        throw new IllegalStateException("Utility class");
    }

    private enum Type{
        DEBUG,ERROR
    }


    private static void print(Class cls,String message,Type type){
        //1641499
        if (type == Type.DEBUG) {
            Log.d(cls.getSimpleName(), message);

        } else if (type == Type.ERROR) {
            Log.e(cls.getSimpleName(), message);

        }

    }

    public static void printDebug(Class cls,String logString){
           print(cls,logString, Type.DEBUG);
    }



    public static void printError(Class cls,String logString){
        print(cls,logString, Type.ERROR);
    }
}
