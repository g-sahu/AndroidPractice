package com.gsahu.androidpractice;

import com.gsahu.androidpractice.utilities.Utilities;

import org.junit.Test;

/**
 * Created by gasahu on 18-Apr-17.
 */

public class UtilitiesTest {
    public UtilitiesTest() {}

    @Test
    public void milliSecondsToTimerTest() {
        assert Utilities.milliSecondsToTimer(0).equals("00:00");
    }
}
