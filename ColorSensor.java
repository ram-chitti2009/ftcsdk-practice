package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ColorSensorTestBench;

@TeleOp

public class ColorSensor extends OpMode {
    String detectedColor;  //initialize detectedColor variable
    ColorSensorTestBench bench = new ColorSensorTestBench(); //create an instance of the color sensor test bench

    @Override
    public void init(){
        bench.init(hardwareMap); //initialize

    }

    @Override
    public void loop(){

        detectedColor = bench.getDetectedColor(telemetry);
        telemetry.addData("Color Detected", detectedColor); //display the detected color on the telemetry


    }

    public static class AprilTagLimelightTest {
    }
}
