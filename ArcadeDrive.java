package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.opMode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.mechanisms.ArcadeDriveClass;

public class ArcadeDrive extends OpMode {
    ArcadeDriveClass arcadeDrive = new ArcadeDriveClass();
    double throttle, spin;

    @Override
    public void init(){
        arcadeDrive.init(hardwareMap);

    }

    @Override
    public void loop(){
        throttle = -gamepad1.left_stick_y; // Get throttle from left stick Y-axis
        spin = gamepad1.right_stick_x;     // Get turn from right stick X

        arcadeDrive.drive(throttle, spin);


    }
}
