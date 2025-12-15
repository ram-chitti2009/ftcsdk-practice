package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench;

@Autonomous
public class StateIntegerPractice extends OpMode {
    TestBench bench = new TestBench(); //create an instance of the test bench
    enum State{

        WAIT_FOR_A,
        WAIT_FOR_B,
        WAIT_FOR_X,
        FINISHED
    }

    }
    @Override
    public void init(){
        bench.init(hardwareMap); //initialize the test bench
         state.wait_for_a;
    }

    @Override
    public void loop(){
        switch(state){
            case 0: telemetry.addLine("to exit state , press A");
            if (gamepad1.a){
                state.wait_for_b;
            }
            break;
            case 1: telemetry.addLine("to exit state , press B");
            if (gamepad1.b){
                state.wait_for_x;

        }
            break;
            case 2: telemetry.addLine("to exit state , press x");
            if (gamepad1.x) {
                state.wait_for_finished;
            }
            break;
            default:
                telemetry.addLine("Auto state machine finished");
    }
}
