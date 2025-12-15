package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

//Touch sensors only read on odd ports.
@TeleOp //this is a must for any op mode that we want to show up on the driver station
public class TouchSensorPractice extends OpMode {
    TestBench bench = new TestBench(); //create an instance of the TestBench class to access the touch sensor
    @Override
    public void init(){

        bench.init(hardwareMap); //initialize the touch sensor using the hardware map -- just grabs the hardware map that is currently attached to the control hub
        
    }
    public void loop(){
        telemetry.addData("Touch Sensor State", bench.getTouchSensorState()); //display the state of the touch sensor on the telemetry
        telemetry.addData("Touch Sensor Released", bench.isTouchSensorReleased()); //display whether the touch sensor is released on the telemetry

    }



}
