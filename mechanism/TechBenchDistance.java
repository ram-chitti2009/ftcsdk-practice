package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class TechBenchDistance {
    private DistanceSensor distance; // Hardware Device Object. distance sensor will allow us to measure distance to an object

    public void init(HardwareMap hw){
        distance = hw.get(DistanceSensor.class, "distanceSensor"); // Initialize the distance sensor from the hardware map
    }

    public double getDistance(){
        return distance.getDistance(DistanceUnit.CM);

    }

}
