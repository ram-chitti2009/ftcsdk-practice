package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Rumble extends OpMode {
    boolean wasA, isA;

    @Override
    public void init(){
        if (gamepad1.a){
            gamepad1.rumbleBlips(3);
        }
    }
    @Override
    public void loop(){
        isA = gamepad1.a;
        if (isA && !wasA){
            gamepad1.rumbleBlips(3);
        }
        wasA = isA;
    }
}
//usecases- haptic feedback on button press example when intake happens etc or when the timer occurs or when a certain distance is reached

