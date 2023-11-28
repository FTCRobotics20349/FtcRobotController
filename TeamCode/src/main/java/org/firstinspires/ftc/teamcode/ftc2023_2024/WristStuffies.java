package org.firstinspires.ftc.teamcode.ftc2023_2024;

import com.qualcomm.robotcore.hardware.DcMotor;

public class WristStuffies {

    public DcMotor wrist = null;

    public void wrist(double frick){
        wrist.setPower(frick);
    }
}
