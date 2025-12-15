package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.MyTestBenchServo;

@TeleOp

public class ServoExamples extends OpMode {
    MyTestBenchServo servo = new MyTestBenchServo(); //create an instance of the test bench servo
    double leftTrigger, rightTrigger;

    @Override
    public void init(){
        servo.init(hardwareMap); //initialize the test bench servo
        rightTrigger = gamepad1.right_trigger;
        leftTrigger = gamepad1.left_trigger;




    }


    @Override
    public void loop(){

        if(gamepad1.a){
            servo.SetServoPos(0.0); //set the servo to position 0.0 when the 'A' button is pressed
        }
        else if(gamepad1.b){
            servo.SetServoPos(1.0); //set the servo to position 1.0 when the 'B' button is pressed
        }

        if (gamepad1.b){
            servo.SetServoRot(1.0); //set the servo to position 1.0 when the 'B' button is pressed
        }
        else{
            servo.SetServoRot(0.0); //set the servo to position 0.0 when the 'B' button is not pressed
        }

        servo.SetServoPos((rightTrigger - leftTrigger)); //set the servo position based on the difference between the right and left trigger values
        servo.SetServoRot((rightTrigger - leftTrigger)); //set the servo rotation based on the difference between the right and left trigger values


    }

}
