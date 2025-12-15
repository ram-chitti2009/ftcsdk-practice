package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
@Autonomous
public class LimeLight extends OpMode {
    private Limelight3A limelight;


    @Override
    public void init(){

        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        limelight.pipelineSwitch(0); //set to pipeline depending on the color-one can choose the pipeline based on the target color

    }
    @Override
    public void start(){
        limelight.start();
    }
    @Override
    public void loop(){
        LLResult llResult = limelight.getLatestResult();
        if (llResult!=null && llResult.isValid()) {
            telemetry.addData("Target X Offset", llResult.getTx());
            telemetry.addData("Target Y Offset", llResult.getTy());
            telemetry.addData("Target Area", llResult.getTa());

            return;
        }

    }

}
