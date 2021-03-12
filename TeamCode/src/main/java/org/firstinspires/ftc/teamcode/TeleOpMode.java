
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.AnalogSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import java.lang.*;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "TeleOpMode", group = "Linear Opmode")
public class TeleOpMode extends LinearOpMode
{

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontLeft, frontRight, backLeft, backRight, intake, lift, ramp, flyWheel;
    private Servo claw;



    @Override
    public void runOpMode()
    {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration

        //Chassis Motors
        frontLeft = hardwareMap.get(DcMotor.class, "FrontLeftDrive");
        frontRight = hardwareMap.get(DcMotor.class, "FrontRightDrive");
        backLeft = hardwareMap.get(DcMotor.class, "BackLeftDrive");
        backRight = hardwareMap.get(DcMotor.class, "BackRightDrive");
        intake = hardwareMap.get(DcMotor.class, "Intake");
        lift = hardwareMap.get(DcMotor.class, "Lift");
        ramp = hardwareMap.get(DcMotor.class, "Ramp");
        flyWheel = hardwareMap.get(DcMotor.class, "FlyWheel");
        claw = hardwareMap.get(Servo.class, "claw");

        // Right motors are reversed because it is oriented differently then the Left side
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.REVERSE);
        intake.setDirection(DcMotor.Direction.REVERSE);
        lift.setDirection(DcMotor.Direction.FORWARD);
        ramp.setDirection(DcMotor.Direction.FORWARD);
        flyWheel.setDirection(DcMotor.Direction.FORWARD);


        //set position of servos
        claw.setPosition(0);



        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        //Make new servo for block stabalizer 4
        telemetry.addData("Status", "before While Loop");
        telemetry.update();
        while (opModeIsActive())
        {
            //Front left reverse
            //Front right forward
            //Back left forward
            //back right reverse

            //gamepad 1
            if(gamepad1.left_stick_y!=0 || gamepad1.left_stick_x!=0)
            {
                //Up and down strafes and left and right go forward and back
                frontRight.setPower((-gamepad1.left_stick_x-gamepad1.left_stick_y));
                frontLeft.setPower((gamepad1.left_stick_x-gamepad1.left_stick_y));
                backRight.setPower((-gamepad1.left_stick_x+gamepad1.left_stick_y));
                backLeft.setPower((gamepad1.left_stick_x+gamepad1.left_stick_y));
            }
            //Right joystick - turning
            else if (gamepad1.right_stick_x!=0)
            {
                frontLeft.setPower(gamepad1.right_stick_x);
                frontRight.setPower(-gamepad1.right_stick_x);
                backLeft.setPower(-gamepad1.right_stick_x);
                backRight.setPower(gamepad1.right_stick_x);
            }
            else
            {
                frontLeft.setPower(0);
                frontRight.setPower(0);
                backLeft.setPower(0);
                backRight.setPower(0);
            }


            //if gamepad 2 left bumper is pressed then wheels will collect
            //reverse intake
            if (gamepad2.left_bumper)
            {
                intake.setPower(-.5);
            }
            //intake in
            else if (gamepad2.right_bumper)
            {
                intake.setPower(.5);
            }
            else
            {
                intake.setPower(0);
            }




        }
    }
}