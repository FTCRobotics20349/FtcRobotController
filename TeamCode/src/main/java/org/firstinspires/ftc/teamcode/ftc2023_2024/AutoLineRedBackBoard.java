package org.firstinspires.ftc.teamcode.ftc2023_2024;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "AutoLineRedBackBoard", group = "Robot")
//@Disabled
public class AutoLineRedBackBoard extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    DcMotor frontLeftMotor = null;
    DcMotor backLeftMotor = null;
    DcMotor frontRightMotor = null;
    DcMotor backRightMotor = null;
    DcMotor lift = null;
    Servo leftClaw = null;
    Servo rightClaw = null;
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
        spin(.75, 2000);
        driveForward(.75, 2000);
        lift(1,1000);
        Wrist(1, 200);
        claw(1);

    }


    private void strafeSU(double speed){
        telemetry.addData("Status", "Auto");
        frontRightMotor.setPower(-speed);
        frontLeftMotor.setPower(speed);
        backLeftMotor.setPower(-speed);
        backRightMotor.setPower(speed);

    }
    private void hi(double dang){
        wrist.setPower(dang);
    }
    private void claw(int position){
        telemetry.addData("claw", position);
        leftClaw.setPosition(-position);
        rightClaw.setPosition(position);
    }
    private void nice(double boo){
        wrist.setPower(boo);
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
    private void spin(double speed, int position) {
        telemetry.addData("spin", position);
        telemetry.addData("speed", speed);

        spin(position);

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
        telemetry.addData("wrist", position);
        telemetry.addData("speed", speed);

        wrist(position);

        hi(speed);
        while (opModeIsActive() &&
                (wrist.isBusy())) {

            // Display it for the driver.
            telemetry.addData("Running to",  position);
            telemetry.addData("Currently at",
                    wrist.getCurrentPosition());
            telemetry.update();
        }
    }
    private void lift(double speed, int position) {
        telemetry.addData("lift", position);
        telemetry.addData("speed", speed);

        lift(position);

        nice(speed);
        while (opModeIsActive() &&
                (lift.isBusy())) {

            // Display it for the driver.
            telemetry.addData("Running to",  position);
            telemetry.addData("Currently at",
                    lift.getCurrentPosition());
            telemetry.update();
        }
    }



    private void setup() {
        // Make sure your ID's match your configuration
        frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        backLeftMotor = hardwareMap.dcMotor.get("backLeftMotor");
        frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");
        backRightMotor = hardwareMap.dcMotor.get("backRightMotor");

        lift = hardwareMap.dcMotor.get("lift");

        leftClaw = hardwareMap.get(Servo.class,"leftclaw");
        rightClaw = hardwareMap.get(Servo.class,"rightclaw");
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
    private void lift(int position){
        lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lift.setTargetPosition(position);
        lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
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
    private void spin(int position){
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setTargetPosition(position);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setTargetPosition(-position);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setTargetPosition(position);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setTargetPosition(-position);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

}