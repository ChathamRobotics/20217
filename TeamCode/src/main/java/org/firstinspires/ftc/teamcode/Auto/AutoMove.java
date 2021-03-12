package org.firstinspires.ftc.teamcode.Auto;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

// This class contains the central location to build an AutoOp
@Autonomous
public class AutoMove extends LinearOpMode
{
    Servo grabBlock, rotateBlock, movePlate;
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontLeft, frontRight, backLeft, backRight, intake, lift, ramp, flyWheel;
    private Servo claw;

    public void runOpMode()
    {

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


        telemetry.addData("Status", "Initialized");
        telemetry.update();
        //  detect.runOpMode();
        waitForStart();


        //grabBlock.setPosition(0);
        //rotateBlock.setPosition(0);
        //movePlate.setPosition(0);
        runtime.reset();



    }
    public void driveBackward(double secs, double power)
    {

        ElapsedTime methodTimeB = new ElapsedTime();
        methodTimeB.reset();
        telemetry.addData("Direction:", "backwards");
        telemetry.update();

        while (opModeIsActive() && methodTimeB.seconds() < secs)
        {
            frontLeft.setPower(-power);
            backLeft.setPower(power);
            frontRight.setPower(-power);
            backRight.setPower(power);
        }
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
    }

    public void driveForward(double secs, double power)
    {

        telemetry.addData("Direction:", "forwards");
        telemetry.update();
        ElapsedTime methodTimeF = new ElapsedTime();
        methodTimeF.reset();
        while (opModeIsActive() && methodTimeF.seconds() < secs)
        {
            frontRight.setPower(power);
            backLeft.setPower(-power);
            frontLeft.setPower(power);
            backRight.setPower(-power);
        }
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
    }

    public void strafeLeft(double secs, double power)
    {
        telemetry.addData("Direction:", "strafing left");
        telemetry.update();
        ElapsedTime methodTimeSL = new ElapsedTime();
        methodTimeSL.reset();
        while (opModeIsActive() && methodTimeSL.seconds() < secs)
        {
            frontLeft.setPower(-power);
            backLeft.setPower(-power);
            frontRight.setPower(power);
            backRight.setPower(power);
        }

        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
    }



    public void strafeRight(double secs, double power)
    {

        telemetry.addData("Direction:", "strafing right");
        telemetry.update();
        ElapsedTime methodTimeSR = new ElapsedTime();
        methodTimeSR.reset();

        while (opModeIsActive() && methodTimeSR.seconds() < secs)
        {
            frontLeft.setPower(power);
            backLeft.setPower(power);
            backRight.setPower(-power);
            frontRight.setPower(-power);
        }
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
    }

    public void turnLeft(double secs, double power)
    {
        telemetry.addData("Direction:", "turning left");
        telemetry.update();
        ElapsedTime methodTimeTL = new ElapsedTime();
        methodTimeTL.reset();

        while (opModeIsActive() && methodTimeTL.seconds() < secs)
        {
            frontLeft.setPower(power);
            backLeft.setPower(power);
            frontRight.setPower(-power);
            backRight.setPower(-power);
        }
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
    }

    public void turnRight(double secs, double power)
    {
        telemetry.addData("Direction:", "turning right");
        telemetry.update();
        ElapsedTime methodTimeTR = new ElapsedTime();
        methodTimeTR.reset();

        while (opModeIsActive() && methodTimeTR.seconds() < secs)
        {
            frontLeft.setPower(power);
            backLeft.setPower(power);
            frontRight.setPower(-power);
            backRight.setPower(-power);
        }
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
    }

    public void stopMotors() {
        telemetry.addData("Direction:", "stopping");
        telemetry.update();
        ElapsedTime methodTimeTR = new ElapsedTime();
        methodTimeTR.reset();

        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
    }

    public void runIntake(double secs, double power)
    {
        telemetry.addData("Direction:", "turning right");
        telemetry.update();
        ElapsedTime methodTimeTR = new ElapsedTime();
        methodTimeTR.reset();

        while (opModeIsActive() && methodTimeTR.seconds() < secs)
        {
            intake.setPower(power);
        }
        intake.setPower(0);

    }
    public void runLift(double secs, double power)
    {
        telemetry.addData("Direction:", "turning right");
        telemetry.update();
        ElapsedTime methodTimeTR = new ElapsedTime();
        methodTimeTR.reset();

        while (opModeIsActive() && methodTimeTR.seconds() < secs)
        {
            lift.setPower(power);
        }
        lift.setPower(0);

    }
    public void runRamp(double secs, double power)
    {
        telemetry.addData("Direction:", "turning right");
        telemetry.update();
        ElapsedTime methodTimeTR = new ElapsedTime();
        methodTimeTR.reset();

        while (opModeIsActive() && methodTimeTR.seconds() < secs)
        {
            ramp.setPower(power);
        }
        ramp.setPower(0);

    }
    public void runFlyWheel(double secs, double power)
    {
        telemetry.addData("Direction:", "turning right");
        telemetry.update();
        ElapsedTime methodTimeTR = new ElapsedTime();
        methodTimeTR.reset();

        while (opModeIsActive() && methodTimeTR.seconds() < secs)
        {
            flyWheel.setPower(power);
        }
        flyWheel.setPower(0);

    }
}