package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class IMUTestBench {
        private IMU imu; // Hardware Device Object. IMU will allow us to measure orientation and acceleration
                        // Gyro will allow us to measure angular velocity
                        // Accelerometer will allow us to measure linear acceleration
        private DcMotor motor; // Hardware Device Object. motor will allow us to control the robot's movement

        public void init(HardwareMap hwMap) {
            imu = hwMap.get(IMU.class, "imu");
            RevHubOrientationOnRobot RevOrientation = new RevHubOrientationOnRobot(
                    RevHubOrientationOnRobot.LogoFacingDirection.FORWARD,
                    RevHubOrientationOnRobot.UsbFacingDirection.UP
            );
            motor = hwMap.get(DcMotor.class, "motor"); // Initialize the motor from the hardware map
            imu.initialize((new IMU.Parameters(RevOrientation))); // Initialize the IMU with the specified orientation



        }
        public double getHeading(AngleUnit angleUnit){
            return imu.getRobotYawPitchRollAngles().getYaw(angleUnit); // Return the heading (yaw) of the robot . this will help us determine the robot's orientation on the field

        }
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER); // Set the motor to run using encoders

    public void setMotor(double power){
        motor.setPower(power);
    }



}
