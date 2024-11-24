package org.jiacheng.teo.Q1;

public class GamePlatform {
    public static double getFinalSpeed(double initialSpeed, int[] inclinations) {
        double newSpeed = initialSpeed;
        for (int incline: inclinations) {

            if (incline < 0) {			// going downhill, speed increases
                newSpeed += Math.abs(incline);
            } else if (incline > 0) {	// going uphill, speed decreasess
                newSpeed -= Math.abs(incline);
            }
        }
        return newSpeed;
    }

    public static void main(String[] args) {
        System.out.println(getFinalSpeed(60.0, new int[] { 0, -30, 0, 45, 0 })); // should print 45
    }
}