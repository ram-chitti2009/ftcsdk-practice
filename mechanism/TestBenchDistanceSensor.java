package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class TestBenchDistanceSensor {

    private DistanceSensor distanceSensor;

    public void init(HardwareMap hwMap) {
        distanceSensor = hwMap.get(DistanceSensor.class, "distanceSensor");// Initialize the distance sensor from the hardware map

    }

    public double getDistanceCm() {
        return distanceSensor.getDistance(DistanceUnit.CM);
    }

    //positional servos will tell you the angle of the servo
    //rotational servos will tell you the rotation of the servo speed.

    public boolean isDistanceLessThan(double threshold) {
        return getDistanceCm() < threshold;
    }
}


