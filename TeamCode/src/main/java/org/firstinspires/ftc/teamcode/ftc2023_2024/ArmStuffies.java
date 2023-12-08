package org.firstinspires.ftc.teamcode.ftc2023_2024;
import com.qualcomm.robotcore.hardware.DcMotor;
public class ArmStuffies {

    public DcMotor lift = null;

    public void lift(double liftPower){

        lift.setPower(-liftPower);
    }
}
