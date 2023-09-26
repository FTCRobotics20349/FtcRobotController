package org.firstinspires.ftc.teamcode.ftc2022_2023;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

//@Disable

@TeleOp(name="test", group="Linear Opmode")
public class test extends LinearOpMode {

    // Define a variable for our color sensor
    ColorSensor color;


    public void runOpMode() {
        // Get the color sensor from hardwareMap
        color = hardwareMap.get(ColorSensor.class, "color");
        //@Disable
        // Wait for the Play button to be pressed
        waitForStart();

        // While the Op Mode is running, update the telemetry values.
        while (opModeIsActive()) {
            if ( ( color.red() >= 46 && color.red() <=47 ) && ( color.green() >= 68 && color.green() <=71 ) &&  ( color.blue() >=50 && color.blue() <=51 ) )
            { telemetry.addData("green", color.red());
                telemetry.update();}
            //do orange

            else if( ( color.red() >= 43 && color.red() <=71 ) && ( color.green() >= 68 && color.green() <=107 ) &&  ( color.blue() >=49 && color.blue() <=97 ))
            { telemetry.addData("Purple", color.green());
                telemetry.update(); }
            //do purple

            else { telemetry.addData("orange", color.blue());
                telemetry.update(); }
            //do green
          /*  telemetry.addData("Red", color.red());
            telemetry.addData("Green", color.green());
            telemetry.addData("Blue", color.blue());
            telemetry.update();*/
        }
    }
}
