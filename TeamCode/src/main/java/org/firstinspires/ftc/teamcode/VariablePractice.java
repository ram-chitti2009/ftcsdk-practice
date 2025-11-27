package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class VariablePractice extends OpMode {
    public void init(){
        int teamNumber = 32516;
        double motorSpeed = 0.75;
        boolean clawClosed = true;
        int motorAngle = 90;
        String name = "HSI Tiger Tronics";
        telemetry.addData("Motor Angle:", motorAngle);
        telemetry.addData("Team Number:", teamNumber);
        telemetry.addDate("Motor Speed:", motorSpeed);
        telemetry.addData("Is the claw closed?", clawClosed);
        telemetry.addData("Name:", name);
    }

    @Override
    public void loop() {

    }

}
