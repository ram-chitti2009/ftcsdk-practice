package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ArcadeDriveGoBuild {
    private DcMotor leftMotor;
    private DcMotor rightMotor;

    private double SPIN_DAMPING =2.0;

    public void init(HardwareMap hw){
        leftMotor = hw.get(DcMotor.class, "leftMotor");
        rightMotor = hw.get(DcMotor.class, "rightMotor");

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftMotor.setDirection(DcMotor.Direction.REVERSE);

        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);




    }
    public void drive(double throttle, double spin){
        //apply damping factor
        spin /= SPIN_DAMPING;
        double leftPower = throttle + spin;
        double rightPower = throttle - spin;

        //clamp and scale the values
        double largest = Math.max(Math.abs(leftPower), Math.abs(rightPower));

        if(largest>1.0){
        throttle /= largest;
        spin /= largest;
        }

        leftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);


    }
}
