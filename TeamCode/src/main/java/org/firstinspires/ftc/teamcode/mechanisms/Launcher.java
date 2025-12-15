package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.util.ElapsedTime;

@SuppressWarnings("unused")
public class Launcher {
    final double FEED_TIME_SECONDS=0.20; //time to run feeder to load one ring
    final double STOP_SPEED = 0.0; //stop speed
    final double FULL_SPEED = 1.0; // full feeder speed

    final double LAUNCHER_TARGET_VELOCITY = 1125; //target velocity for launcher flywheels
    final double LAUNCHER_MIN_VELOCITY=1075; //minimum velocity for launcher flywheels

    private CRServo leftFeeder, rightFeeder;

    private DcMotorEx launcher;

    ElapsedTime feederTime = new ElapsedTime();

    private enum LauncherState {
       IDLE,
        SPIN_UP,
        LAUNCH,
        LAUNCHING
    }
    private LauncherState launcherState;

    public void init(HardwareMap hwMap){

            launcher = hwMap.get(DcMotorEx.class, "launcher");
            leftFeeder = hwMap.get(CRServo.class, "leftFeeder");
            rightFeeder = hwMap.get(CRServo.class, "rightFeeder");

            if (launcher != null) {
                launcher.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                launcher.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                launcher.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, new PIDFCoefficients(
                        300, 0 , 0, 10
                ));
            }

            if (leftFeeder != null) {
                leftFeeder.setDirection(CRServo.Direction.REVERSE);
            }
            if (rightFeeder != null) {
                // ensure stopped initially
                rightFeeder.setPower(STOP_SPEED);
            }

            launcherState = LauncherState.IDLE;



    }

    public void stopFeeder(){
        if (leftFeeder != null) leftFeeder.setPower(STOP_SPEED);
        if (rightFeeder != null) rightFeeder.setPower(STOP_SPEED);

    }

    public void updateState(){
        switch(launcherState){
            case IDLE:
            break;

            case SPIN_UP:
                if (launcher != null) launcher.setVelocity(LAUNCHER_TARGET_VELOCITY);
                if (launcher != null && launcher.getVelocity() >= LAUNCHER_MIN_VELOCITY) {
                    launcherState = LauncherState.LAUNCH;
                }
                break;
            case LAUNCH:
                if (leftFeeder != null) leftFeeder.setPower(FULL_SPEED);
                if (rightFeeder != null) rightFeeder.setPower(FULL_SPEED);
                feederTime.reset();
                //transition to LAUNCHING state
                launcherState = LauncherState.LAUNCHING;
                break;
            case LAUNCHING:
                if (feederTime.seconds() >= FEED_TIME_SECONDS) {
                    stopFeeder();
                    launcherState = LauncherState.SPIN_UP; //go back to spin up state to launch next ring
                }
                break;
        }
    }

    // bring the stray helper methods into the class and fix typos
    public void startLauncher(){
        if (launcherState == LauncherState.IDLE) {
            launcherState = LauncherState.SPIN_UP;
        }
    }

    public void stopLauncher(){
        stopFeeder();
        if (launcher != null) launcher.setVelocity(0);
        launcherState = LauncherState.IDLE;
    }


    public String getState(){
        return launcherState.toString();
    }

    public double getVelocity(){
        if (launcher != null) {
            return launcher.getVelocity();
        } else {
            return 0.0;
        }
    }
}