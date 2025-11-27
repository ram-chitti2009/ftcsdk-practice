package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class GamePadPractice extends OpMoe
{

    @Override
    public void init(){}

    @Override
    public void loop(){

        double speedForward = -gamepad1.left_stick_y/2.0;
        double sumTriggers = gamepad1.right_trigger + gamepad1.left_trigger;

        //this runs 50 times per second
        telemetry.addData("x",gamepad1.left_stick_x );
        telemetry.addData("y",speedForward );
        telemetry.addData("a",gamepad1.a );
        telemetry.addData("x2", gamepad1.right_stick_x );
        telemetry.addData("a button", gamepad1.a );
        telemetry.addData("b button", gamepad1.b );
        telemetry.addData("sum of triggers", sumTriggers );
        telemetry.addData("difference", gamepad1.left_stick_x - gamepad1.right_stick_x );



    }

}
