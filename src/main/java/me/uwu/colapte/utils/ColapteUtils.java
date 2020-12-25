package me.uwu.colapte.utils;

public class ColapteUtils {

    public static String getIdFromPing(String ping){
        return ping.replace("<", "").replace(">", "").replace("!", "").replace("@", "");
    }

    public static int getXpForLevel(int lvl){
        int old = 0;
        int meh = 0;
        for (int i = 0; i<=lvl; i++){
            meh = (1680 * i) + old;
            old = meh;
        }
        return meh;
    }

}
