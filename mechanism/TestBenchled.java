package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.LED;

public class TestBenchled {
    private LED redled;
    private LED greenled;

    public void init(HardwareMap hardwareMap){
        redled = hardwareMap.get(LED.class, "redled");
        greenled = hardwareMap.get(LED.class, "greenled");
    }

    public void setRedLed(boolean isOn){
        if (isOn){
            redled.on();
        } else {
            redled.off();
        }
    }

    public void setGreenled(boolean isOn) {
        if(isOn){
            greenled.on();
        } else {
            greenled.off();
        }
    }
}
