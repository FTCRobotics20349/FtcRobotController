package org.firstinspires.ftc.teamcode.ftc2023_2024;

import  com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@TeleOp
public class TeleOpField extends LinearOpMode {

    DcMotor frontLeftMotor = null;
    DcMotor backLeftMotor = null;
    DcMotor frontRightMotor = null;
    DcMotor backRightMotor = null;
    DcMotor rightLift = null;
    DcMotor leftLift = null;
    private Servo claw = null;
    DcMotor wrist = null;
    IMU imu = null;




    @Override
    public void runOpMode() throws InterruptedException {
        setup();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
            double x = gamepad1.left_stick_x;
            double rx = gamepad1.right_stick_x;

            // This button choice was made so that it is hard to hit on accident,
            // it can be freely changed based on preference.
            // The equivalent button is start on Xbox-style controllers.
            if (gamepad1.options) {
                imu.resetYaw();
            }

            double botHeading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);

            // Rotate the movement direction counter to the bot's rotation
            double rotX = x * Math.cos(-botHeading) - y * Math.sin(-botHeading);
            double rotY = x * Math.sin(-botHeading) + y * Math.cos(-botHeading);

            rotX = rotX * 1.1;  // Counteract imperfect strafing

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio,
            // but only if at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(rx), 1);
            double frontLeftPower = (rotY + rotX + rx) / denominator;
            double backLeftPower = (rotY - rotX + rx) / denominator;
            double frontRightPower = (rotY - rotX - rx) / denominator;
            double backRightPower = (rotY + rotX - rx) / denominator;

            frontLeftMotor.setPower(frontLeftPower/2);
            backLeftMotor.setPower(backLeftPower/2);
            frontRightMotor.setPower(frontRightPower/2);
            backRightMotor.setPower(backRightPower/2);

            // love- ben <3

            //NOS ENGAGED ZOOOOOMMMMMMMMMMM
            if (gamepad1.right_bumper){
                frontLeftMotor.setPower(frontLeftPower*2);
                backLeftMotor.setPower(backLeftPower*2);
                frontRightMotor.setPower(frontRightPower*2);
                backRightMotor.setPower(backRightPower*2);
                gamepad1.rumble(40);
            }

            // lift code
            double rightPower = gamepad2.right_stick_y;
            double leftPower = gamepad2.right_stick_y;

            rightLift.setPower(rightPower);
            leftLift.setPower(leftPower);


            // claw code
            while (gamepad2.a){
                claw.setPosition(1);
            }
           while (gamepad2.b){
               claw.setPosition(0);
           }

           //wrist
            wrist.setPower(gamepad2.left_stick_y/2);

        }
    }

    private void setup() {
        // Declare our motors
        // Make sure your ID's match your configuration
        frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        backLeftMotor = hardwareMap.dcMotor.get("backLeftMotor");
        frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");
        backRightMotor = hardwareMap.dcMotor.get("backRightMotor");

        rightLift = hardwareMap.dcMotor.get("rightLift");
        leftLift = hardwareMap.dcMotor.get("leftLift");

        claw = hardwareMap.get(Servo.class,"claw");
        wrist = hardwareMap.dcMotor.get("wrist");
        wrist.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Reverse the right side motors. This may be wrong for your setup.
        // If your robot moves backwards when commanded to go forwards,
        // reverse the left side instead.
        // See the note about this earlier on this page.
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        // Retrieve the IMU from the hardware map
        imu = hardwareMap.get(IMU.class, "imu");
        // Adjust the orientation parameters to match your robot
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.LEFT));
        // Without this, the REV Hub's orientation is assumed to be logo up / USB forward
        imu.initialize(parameters);

        waitForStart();
    }
}