package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

@TeleOp
public class AprilTageLimelightTest extends OpMode {
    private Limelight3A limelight;
    private IMU imu;
    @Override
    public void init(){

        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        limelight.pipelineSwitch(8);
        imu = hardwareMap.get(IMU.class, "imu");

        RevHubOrientationOnRobot revHubOrientationOnRobot = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.FORWARD,
                RevHubOrientationOnRobot.UsbFacingDirection.UP
        );
        imu.initialize(new IMU.Parameters(revHubOrientationOnRobot));


    }

    @Override
    public void loop(){
        YawPitchRollAngles angles = imu.getRobotYawPitchRollAngles();
        limelight.updateRobotOrientation(angles.getYaw());
        LLResult llresult = limelight.getLatestResult();
        if (llresult != null && llresult.isValid()){
            Pose3D pose = llresult.getBotpose_MT2();
            double distance;
            distance = getDistanceFromTag(llresult.getTa());
            telemetry.addData("Tx", llresult.getTx());
            telemetry.addData("Ty", llresult.getTy());
            telemetry.addData("Ta", llresult.getTa());
        }
    }

    public double getDistanceFromTag(double ta){
        double scale = 30665.95;
        double distance = (scale/ta);
        return distance;

    }
}

//The april tag tells us the exact position and difference, what will we do with that data?
