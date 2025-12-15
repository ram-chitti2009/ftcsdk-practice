package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

@TeleOp
public class FlyWheelTuner extends OpMode {
    public DcMotorEx flywheel;
    double highVelocity = 1500;

    double lowVelocity = 900;

    double curTargetVelocity = highVelocity;

    double F = 0;
    double P = 0;
    //init and loop
    double[] stepSizes = {10.0,1.0,1,0.1,0.01,0.001,0.0001};
    int stepIndex = 0;
    public void init(){
        flywheel = hardwareMap.get(DcMotorEx.class, "flywheel");
        flywheel.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        flywheel.setVelocity(0);
        flywheel.setDirection(com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE);
        PIDFCoefficients pidf = new PIDFCoefficients(P,0,0,F);
        flywheel.setPIDFCoefficients(DcMotorEx.RunMode.RUN_USING_ENCODER, pidf);



    }
    public void loop(){

        if (gamepad1.y){
            if (curTargetVelocity==highVelocity){
                curTargetVelocity=lowVelocity;
            }
            else{
                curTargetVelocity=highVelocity;
            }
        }

        if(gamepad1.b){

            stepIndex = (stepIndex +1) % stepSizes.length;


        }

        if(gamepad1.dpad_left){
            F-=stepSizes[stepIndex];

        }
        if(gamepad1.dpad_right){
            F+=stepSizes[stepIndex];
        }
        if(gamepad1.dpad_down){
            P -= stepSizes[stepIndex];
        }
        if(gamepad1.dpad_up){
            P+=stepSizes[stepIndex];
        }

        PIDFCoefficients pidfCoefficients = new PIDFCoefficients(P,0,0,F);
        flywheel.setPIDFCoefficients(DcMotorEx.RunMode.RUN_USING_ENCODER
, pidfCoefficients);
        flywheel.setVelocity(curTargetVelocity);
        double curVelocity = flywheel.getVelocity();

    }


}
