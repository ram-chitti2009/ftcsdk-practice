package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.mechanisms.TestBenchled;

public class LedTes extends OpMode {
    TestBenchled bench = new TestBenchled(); //create an instance of the color sensor test bench
    @Override
    public void init(){
        bench.init(hardwareMap); //initialize

    }

    @Override
    public void loop(){

        if(gamepad1.a){
            bench.setRedLed(true);
            bench.setGreenled(false);

        }
        else if(gamepad1.b){
            bench.setGreenled(true);
            bench.setRedLed(false);
        }


    }

}
