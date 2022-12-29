package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

//@Disable
@TeleOp(name="test2", group="Linear Opmode")
public class test2 extends LinearOpMode {

    // Define a variable for our color sensor
    ColorSensor color;

    public void runOpMode() {
        // Get the color sensor from hardwareMap
        color = hardwareMap.get(ColorSensor.class, "color");

        // Wait for the Play button to be pressed
        waitForStart();

        // While the Op Mode is running, update the telemetry values.
        while (opModeIsActive()) {
            telemetry.addData("Red", color.red());
            telemetry.addData("Green", color.green());
            telemetry.addData("Blue", color.blue());

            if (color.blue() > color.red() && color.blue() > color.green()) {
                telemetry.addData("Color Chosen: ", "Blue");
                telemetry.update();
            } else if (color.green() > color.blue() && color.blue() > color.red()) {
                telemetry.addData("Color Chosen: ", "Green");
                telemetry.update();
            } else {
                telemetry.addData("Color Chosen: ", "Red");
                telemetry.update();
            }
            //do green
          /*  telemetry.addData("Red", color.red());
            telemetry.addData("Green", color.green());
            telemetry.addData("Blue", color.blue());
            telemetry.update();*/

        }
    }
}
