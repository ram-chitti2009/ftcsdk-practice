package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.mechanisms.AprilTagWebcam;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
@Autonomous
public class AprilTagWebcamExample extends OpMode {
    AprilTagWebcam webcam = new AprilTagWebcam();

    @Override
    public void init(){
        webcam.init(hardwareMap, telemetry);

    }

    @Override
    public void loop(){
        webcam.update();
        AprilTagDetection id20 = webcam.getTagById(20);
        webcam.displayDetectionTelemetry(id20); //display telemetry for tag ID 20


    }

}
