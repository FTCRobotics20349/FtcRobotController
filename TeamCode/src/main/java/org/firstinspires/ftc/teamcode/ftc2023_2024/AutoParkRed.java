package org.firstinspires.ftc.teamcode.ftc2023_2024;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "AutoParkRed", group = "Robot")
//@Disabled
public class AutoParkRed extends LinearOpMode {

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

//        strafeRight(0.5);
        strafeToPosition(.75,4000);
    }

    private void strafeRight(double speed){
        telemetry.addData("Status", "Auto");
        frontRightMotor.setPower(-speed);
        frontLeftMotor.setPower(speed);
        backLeftMotor.setPower(-speed);
        backRightMotor.setPower(speed);
    }

    private void strafeLeft(double speed) {
        strafeRight(-speed);
    }

    private void strafeToPosition(double speed, int position) {
        telemetry.addData("StrafeToPosition", position);
        telemetry.addData("speed", speed);

        listofruns(position);

        strafeLeft(speed);
        while (opModeIsActive() &&
                (frontLeftMotor.isBusy())) {

            // Display it for the driver.
            telemetry.addData("Running to",  position);
            telemetry.addData("Currently at",
                    frontLeftMotor.getCurrentPosition());
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

        claw = hardwareMap.get(Servo.class,"claw");
        wrist = hardwareMap.dcMotor.get("wrist");

        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);


    }
    private void listofruns(int position){
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
