package com.gsahu.androidpractice.utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Utilities {
    /**
     * Function to convert milliseconds time to
     * Timer Format
     * Hours:Minutes:Seconds
     * */
    public static String milliSecondsToTimer(long milliseconds){
        String finalTimerString = "";
        String minutesString, secondsString;

        // Convert total duration into time
        int hours = (int) (milliseconds / (1000*60*60));
        int minutes = (int) (milliseconds % (1000*60*60)) / (1000*60);
        int seconds = (int) ((milliseconds % (1000*60*60)) % (1000*60) / 1000);

        // Add hours if there
        if(hours > 0){
            finalTimerString = hours + ":";
        }

        // Prepending 0 to minutes if it is one digit
        if(minutes < 10){
            minutesString = "0" + minutes;
        } else {
            minutesString = "" + minutes;
        }

        // Prepending 0 to seconds if it is one digit
        if(seconds < 10){
            secondsString = "0" + seconds;
        } else {
            secondsString = "" + seconds;
        }

        finalTimerString = finalTimerString + minutesString + ":" + secondsString;

        // return timer string
        return finalTimerString;
    }

    /**
     * Function to get Progress percentage
     * @param currentDuration Elapsed duration of the track
     * @param totalDuration Total track duration
     * */
    public static int getProgressPercentage(long currentDuration, long totalDuration){
        long currentSeconds = (int) (currentDuration / 1000);
        long totalSeconds = (int) (totalDuration / 1000);

        // calculating percentage
        Double percentage = (((double) currentSeconds)/totalSeconds) * 100;

        // return percentage
        return percentage.intValue();
    }

    /**
     * Function to change progress to timer
     * @param progress -
     * @param totalDuration
     * returns current duration in milliseconds
     * */
    public static int progressToTimer(int progress, int totalDuration) {
        int currentDuration;
        totalDuration = totalDuration / 1000;
        currentDuration = (int) ((((double)progress) / 100) * totalDuration);

        // return current duration in milliseconds
        return currentDuration * 1000;
    }

    public static String getCurrentDate() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("DD/MM/YY");

        return df.format(c.getTime());
    }

    public static ArrayList<String> getTrackInfoList() {
        ArrayList<String> trackList = new ArrayList<String>();

        trackList.add("100 Rupai (Demo Version) - Zeest");
        trackList.add("Aadat (atif)");
        trackList.add("Aadat (jal the band)");
        trackList.add("Aapka Kya Hoga (Dhanno)");
        trackList.add("Aashaayen");
        trackList.add("Aasman Ke Paar - Rockford");
        trackList.add("Aasman ke");
        trackList.add("Abhi Abhi (Duet)");
        trackList.add("Abhi Mujh Me");
        trackList.add("Across the Universe");
        trackList.add("Adhoore");
        trackList.add("Adhure");
        trackList.add("Ae khuda");
        trackList.add("Afreen Afreen");
        trackList.add("Ahista Ahista");
        trackList.add("Ainvayi Ainvayi");

        return trackList;
    }
}
