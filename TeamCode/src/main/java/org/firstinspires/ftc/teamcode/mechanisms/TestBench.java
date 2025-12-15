package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestBench  {



    private DigitalChannel touchSensor;
    private double ticksPerRev;
    private DcMotor motor; //be specific when actually using motors.

    public void init(HardwareMap hwMap){ //hardware map is a way for us to access the hardware configuration on the robot controller
        touchSensor = hwMap.get(DigitalChannel.class, "touchSensor"); //initialize the touch sensor from the hardware map
        touchSensor.setMode(DigitalChannel.Mode.INPUT); //set the touch sensor to input mode

        motor = hwMap.get(DcMotor.class, "motor"); //initialize the motor from the hardware map
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER); //set the motor to run using encoder mode
        //what the encoder does is -- it allows us to control the speed of the motor more precisely by measuring the rotations of the motor shaft
        //has some internal pid stuff that helps with that.. run to pos
        ticksPerRev = motor.getMotorType().getTicksPerRev(); //get the number of ticks per revolution of the motor
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setDirection(DcMotor.Direction.REVERSE); //reverse the motor direction if needed for mecanum drive
    }
    public double getMotorTicksPerRev(){
        return ticksPerRev; //return the number of ticks per revolution of the motor
    }
    public void setMotor(double speed){
        //accepts value between -1 and 1
        motor.setPower(speed); //set the power of the motor to the given speed
    }

    public void loop(Gamepad gamepad1){
        double motorSpeed = gamepad1.left_stick_y;
        motor.setPower(motorSpeed);
    }





    public boolean getTouchSensorState(){
        return !touchSensor.getState(); //return the state of the touch sensor (pressed or not pressed)

    }

    public boolean isTouchSensorReleased(){
        return touchSensor.getState(); //return true if the touch sensor is not pressed

    }



    public void setMotorZeroBehavior(DcMotor.ZeroPowerBehavior behavior){
        motor.setZeroPowerBehavior(behavior);
    }











}
