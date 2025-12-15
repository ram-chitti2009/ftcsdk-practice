package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.ColorRangeSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ColorSensorTestBench {

    private ColorRangeSensor colorSensor;

    public void init(HardwareMap hwMap) {
        colorSensor = hwMap.get(ColorRangeSensor.class, "colorSensor");
    }

    public String getDetectedColor(Telemetry telemetry) {
        int red = colorSensor.red();
        int green = colorSensor.green();
        int blue = colorSensor.blue();
        telemetry.addData("Red", red);
        telemetry.addData("Green", green);
        telemetry.addData("Blue", blue);
        if (red > green && red > blue) {
            return "Red";
        } else if (green > red && green > blue) {
            return "Green";
        } else if (blue > red && blue > green) {
            return "Blue";
        } else {
            return "Unknown";
        }
    }
}
