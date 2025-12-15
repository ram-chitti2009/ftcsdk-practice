package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench;

@TeleOp
public class DCMotorPractice extends OpMode {
    TestBench bench = new TestBench();
    @Override
    public void init(){
        bench.init(hardwareMap);
    }

    public void loop(){
        if (bench.getTouchSensorState()){ //if the touch sensor is pressed
            bench.setMotor(0);//stop the motor
        }
        else{//if the touch sensor is not pressed
            bench.setMotor(0.5);//set the motor to half power
        }
        bench.setMotor(1);
        telemetry.addData("Motor revs", bench.getMotorTicksPerRev());

        if (gamepad1.a){ // the a button is the bottom button on the right side of the gamepad
            bench.setMotorZeroBehavior(DcMotor.ZeroPowerBehavior.BRAKE); //set the motor to brake when power is zero
        }
        else{
            bench.setMotorZeroBehavior(DcMotor.ZeroPowerBehavior.FLOAT); //set the motor to float when power is zero
        }


    }


}
