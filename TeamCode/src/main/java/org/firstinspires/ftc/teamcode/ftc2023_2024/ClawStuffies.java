package org.firstinspires.ftc.teamcode.ftc2023_2024;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class ClawStuffies {
   public Servo leftClaw = null;
   public Servo rightClaw = null;



   public void claw(boolean boo){
       if (boo){
           leftClaw.setPosition(.1);
           rightClaw.setPosition(1);
       }
       else{
           leftClaw.setPosition(1);
           rightClaw.setPosition(0);
       }
   }

}
