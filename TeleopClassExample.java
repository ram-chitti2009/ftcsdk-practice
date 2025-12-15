package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.mechanisms.ArcadeDriveClass;
import org.firstinspires.ftc.teamcode.mechanisms.Launcher;

@TeleOp
public class TeleopClassExample extends OpMode {
    ArcadeDriveClass drive = new ArcadeDriveClass();
    Launcher launcher = new Launcher();
    @Override
    public void init(){
        drive.init(hardwareMap);
        launcher.init(hardwareMap);

    }

    @Override
    public void loop(){
        drive.drive(-gamepad1.left_stick_y, gamepad1.right_stick_x);
        if(gamepad1.y){
            launcher.startLauncher();
        }
        else if (gamepad1.a){
            launcher.stopLauncher();
        }
        //update state machine at the end of our loop
        launcher.updateState();

        telemetry.addData("State", launcher.getState());
        telemetry.addData("velocity", launcher.getVelocity());

    }






}
