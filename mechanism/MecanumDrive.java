package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class MecanumDrive {
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;

    private IMU imu;
    public void init(HardwareMap hw){
        frontLeftMotor = hw.get(DcMotor.class, "frontLeftMotor");
        frontRightMotor = hw.get(DcMotor.class, "frontRightMotor");
        backLeftMotor = hw.get(DcMotor.class, "backLeftMotor");
        backRightMotor = hw.get(DcMotor.class, "backRightMotor");

        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        imu = hw.get(IMU.class, "imu");

        RevHubOrientationOnRobot RevOrientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.FORWARD,
                RevHubOrientationOnRobot.UsbFacingDirection.UP
        );
        imu.initialize((new IMU.Parameters(RevOrientation)));


}
    public void drive(double forward, double strafe, double rotate){

        doule frontLeftPower = forward + strafe + rotate;
        double frontRightPower = forward - strafe - rotate;
        double backLeftPower = forward - strafe + rotate;
        double backRightPower = forward + strafe - rotate;

        double maxPower = 1.0;

        double maxSpeed = 0.3;

        maxPower = Math.max(maxPower, Math.abs(frontRightPower));
        maxPower = Math.max(maxPower, Math.abs(backLeftPower));
        maxPower = Math.max(maxPower, Math.abs(backRightPower));
        maxPower = Math.max(maxPower, Math.abs(frontLeftPower));

        frontLeftMotor.setPower(maxSpeed * frontLeftPower / maxPower);
        frontRightMotor.setPower(maxSpeed * frontRightPower / maxPower);
        backLeftMotor.setPower(maxSpeed * backLeftPower / maxPower);
        backRightMotor.setPower(maxSpeed * backRightPower / maxPower);










    }

    public void fieldOrientedDriving(double forward, double strafe, double rotate){

        double theta = Math.atan(forward, strafe);
        double r = Math.hypot(forward, strafe);
        theta = AngleUnit.normalizeRadians(theta-imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS));
        double newForward = r*Math.sin(theta);
        double newStrafe = r*Math.cos(theta);
        this.drive(newForward, newStrafe, rotate);





    }

}
