package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class IfPractice extends OpMode {
@Override
    public void init(){}

}

@Override
public void loop(){
    double motorSpeed = -gamepad1.left_stick_y;

    if(!gamepad1.a){
        motorSpeed = motorSpeed / 2.0;
    }

}

public
