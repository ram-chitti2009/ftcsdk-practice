package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.mechanisms.IMUTestBench;

@TeleOp
public class IMUPractice extends OpMode {
    IMUTestBench imuBench = new IMUTestBench(); //create an instance of the IMU test bench


    @Override
    public void init(){
        telemetry.addData("IMU", "Initialized");
        imuBench.init(hardwareMap); //initialize the IMU test bench


    }

    @Override
    public void loop(){

        double heading = imuBench.getHeading(AngleUnit.DEGREES);
        telemetry.addData("Heading", heading); //display the heading on the telemetry

        if(heading<0.5 && heading>-0.5){
            imuBench.setMotor(0);
        }
        else if(heading>=0.5){
            imuBench.setMotor(0.2);
        }
        else if(heading<=-0.5){
            imuBench.setMotor(-0.2);
        }


    }
    //

}
