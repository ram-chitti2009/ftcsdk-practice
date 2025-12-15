package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.mechanisms.TestBenchDistanceSensor;


@TeleOp
public class DistanceTest extends OpMode {
    TestBenchDistanceSensor bench = new TestBenchDistanceSensor(); //create an instance of the test bench

    @Override
    public void init(){
        bench.init(hardwareMap); //initialize the test bench

    }

    @Override
    public void loop(){
        telemetry.addData("Distance", bench.getDistanceCm()); //display the distance in cm on the telemetry
        if (bench.isDistanceLessThan(10)){ //if the distance is less than 10 cm
            telemetry.addData("Object", "Close"); //display "Close" on the telemetry
        }
        else{
            telemetry.addData("Object", "Far"); //display "Far" on the telemetry
        }

    }
}
