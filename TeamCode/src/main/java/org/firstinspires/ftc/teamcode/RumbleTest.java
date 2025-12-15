package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp

public class RumbleTest extends OpMode {
    boolean isEndGame;
    double endGameStart;

    @Override
    public void init(){

    }
    @Override
    public void loop() {
        //end game check
        isEndGame = getRuntime() >= endGameStart;
        if (isEndGame) {
            gamepad1.rumble(1000); //rumble for 1 second
        }
    }

    @Override
    public void start(){
        endGameStart = getRuntime()+90; //record the time when the match starts and add 90 seconds to it
    }


}
