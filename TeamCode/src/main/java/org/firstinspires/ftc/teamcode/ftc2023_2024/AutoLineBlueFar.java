package org.firstinspires.ftc.teamcode.ftc2023_2024;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "AutoLineBlueFar", group = "Robot")
//@Disabled
public class AutoLineBlueFar extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    DcMotor frontLeftMotor = null;
    DcMotor backLeftMotor = null;
    DcMotor frontRightMotor = null;
    DcMotor backRightMotor = null;
    DcMotor rightLift = null;
    DcMotor leftLift = null;
    private Servo claw = null;
    DcMotor wrist = null;

    @Override
    public void runOpMode() {

        setup();

        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        telemetry.addData("Status", "Started");


        driveForward(.75, 1500);
        driveBackward(.75,200);
        strafeLeft(.75,4800);

    }


    private void strafeSU(double speed){
        telemetry.addData("Status", "Auto");
        frontRightMotor.setPower(-speed);
        frontLeftMotor.setPower(speed);
        backLeftMotor.setPower(-speed);
        backRightMotor.setPower(speed);
        wrist.setPower(speed);
    }

    private void driveForward(double speed, int position) {
        telemetry.addData("driveForward1", position);
        telemetry.addData("speed", speed);

        go1(position);

        strafeSU(speed);
        while (opModeIsActive() &&
                (frontLeftMotor.isBusy())) {

            // Display it for the driver.
            telemetry.addData("Running to",  position);
            telemetry.addData("Currently at",
                    frontLeftMotor.getCurrentPosition());
            telemetry.update();
        }
    }
    private void strafeRight(double speed, int position) {
        telemetry.addData("strafeRight1", position);
        telemetry.addData("speed", speed);

        go4(position);

        strafeSU(speed);
        while (opModeIsActive() &&
                (frontLeftMotor.isBusy())) {

            // Display it for the driver.
            telemetry.addData("Running to",  position);
            telemetry.addData("Currently at",
                    frontLeftMotor.getCurrentPosition());
            telemetry.update();
        }
    }

    private void strafeLeft(double speed, int position) {
        telemetry.addData("strafeLeft1", position);
        telemetry.addData("speed", speed);

        go2(position);

        strafeSU(speed);
        while (opModeIsActive() &&
                (frontLeftMotor.isBusy())) {

            // Display it for the driver.
            telemetry.addData("Running to",  position);
            telemetry.addData("Currently at",
                    frontLeftMotor.getCurrentPosition());
            telemetry.update();
        }
    }

    private void driveBackward(double speed, int position) {
        telemetry.addData("driveBackward1", position);
        telemetry.addData("speed", speed);

        go3(position);

        strafeSU(speed);
        while (opModeIsActive() &&
                (frontLeftMotor.isBusy())) {

            // Display it for the driver.
            telemetry.addData("Running to",  position);
            telemetry.addData("Currently at",
                    frontLeftMotor.getCurrentPosition());
            telemetry.update();
        }
    }

    private void Wrist(double speed, int position) {
        telemetry.addData("driveBackward1", position);
        telemetry.addData("speed", speed);

        wrist(position);

        strafeSU(speed);
        while (opModeIsActive() &&
                (wrist.isBusy())) {

            // Display it for the driver.
            telemetry.addData("Running to",  position);
            telemetry.addData("Currently at",
                    wrist.getCurrentPosition());
            telemetry.update();
        }
    }



    private void setup() {
        // Make sure your ID's match your configuration
        frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        backLeftMotor = hardwareMap.dcMotor.get("backLeftMotor");
        frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");
        backRightMotor = hardwareMap.dcMotor.get("backRightMotor");

        rightLift = hardwareMap.dcMotor.get("rightLift");
        leftLift = hardwareMap.dcMotor.get("leftLift");

        //claw = hardwareMap.get(Servo.class,"claw");
        wrist = hardwareMap.dcMotor.get("wrist");

        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        wrist.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        wrist.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

    }
    private void wrist(int position){
        wrist.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        wrist.setTargetPosition(position);
        wrist.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    //Drive Forward
    private void go1(int position){
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setTargetPosition(position);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setTargetPosition(position);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setTargetPosition(position);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setTargetPosition(position);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    //Strafe Left
    private void go2(int position){
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setTargetPosition(-position);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setTargetPosition(position);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setTargetPosition(position);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setTargetPosition(-position);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    //Drive Backward
    private void go3(int position){
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setTargetPosition(-position);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setTargetPosition(-position);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setTargetPosition(-position);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setTargetPosition(-position);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    //Strafe Right
    private void go4(int position){
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setTargetPosition(position);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setTargetPosition(-position);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setTargetPosition(-position);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setTargetPosition(position);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

}
