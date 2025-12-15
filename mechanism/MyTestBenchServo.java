package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class MyTestBenchServo {

    private Servo servo;
    private Servo servo_rot;

    public void init(HardwareMap hwMap) {

        servo = hwMap.get(Servo.class, "servo");
        servo_rot = hwMap.get(Servo.class, "servo_rot");
        servo.scaleRange(0.0, 1.0);
        servo.setDirection(Servo.Direction.REVERSE);
        servo_rot.setDirection(Servo.Direction.REVERSE);


    }

    public void SetServoPos(double position) {
        servo.setPosition(position);
    }

    public void SetServoRot(double speed) {
        servo.setPosition(speed);
    }
}
