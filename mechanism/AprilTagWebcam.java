package org.firstinspires.ftc.teamcode.mechanisms;

import android.util.Size;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.ArrayList;
import java.util.List;

public class AprilTagWebcam {

    private AprilTagProcessor aprilTagProcessor;
    private VisionPortal visionPortal;

    private List<AprilTagDetection> detectedTags = new ArrayList<>();

    public void displayDetectionTelemetry(AprilTagDetection detectedId){
        if (detectedId==null){
            return;
        }
        else{
            telemetry.addData("Tag ID", detectedId.id);
            telemetry.addData("Translation X (cm)", "%.2f", detectedId.getTranslation().x);
            telemetry.addData("Translation Y (cm)", "%.2f", detectedId.getTranslation().y);
            telemetry.addData("Translation Z (cm)", "%.2f", detectedId.getTranslation().z);
            telemetry.addData("Rotation Yaw (deg)", "%.2f", detectedId.getRotation().yaw);
            telemetry.addData("Rotation Pitch (deg)", "%.2f", detectedId.getRotation().pitch);
            telemetry.addData("Rotation Roll (deg)", "%.2f", detectedId.getRotation().roll);
        }
    }

    private Telemetry telemetry;

    public void init(HardwareMap hwMap, Telemetry telemetryIn){

        this.telemetry = telemetryIn;
        aprilTagProcessor = new AprilTagProcessor.Builder().
                setDrawTagID(true)
                .setDrawTagOutline(true)
                .setDrawAxes(true)
                .setDrawCubeProjection(true)
                .setOutputUnits(DistanceUnit.CM, AngleUnit.DEGREES)
                .build();

        VisionPortal.Builder builder =  new VisionPortal.Builder();
        builder.setCamera(hwMap.get(WebcamName.class, "Webcam 1"));
        builder.setCameraResolution(new Size(640, 380));
        builder.addProcessor(aprilTagProcessor);

        visionPortal = builder.build();



    }
    public void update(){
        if (aprilTagProcessor != null) {
            List<AprilTagDetection> detections = aprilTagProcessor.getDetections();
            if (detections != null) {
                detectedTags = detections;
            } else {
                detectedTags = new ArrayList<>();
            }
        }

    }
    public List<AprilTagDetection> getDetectedTags(){
        return detectedTags == null ? new ArrayList<>() : detectedTags;
    }

    public AprilTagDetection getTagById(int id){
        if (detectedTags == null) return null;
        for(AprilTagDetection tag : detectedTags){
            if(tag.id == id){
                return tag;
            }
        }
        return null;
    }

    public void stop(){
        if(visionPortal != null){
            visionPortal.close();
        }
    }

}
