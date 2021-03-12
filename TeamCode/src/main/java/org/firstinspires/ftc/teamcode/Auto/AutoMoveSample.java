package org.firstinspires.ftc.teamcode.Auto;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Auto.AutoMove;

// this is a sample OpMode testing AutoMove
@Autonomous
public class AutoMoveSample extends LinearOpMode
{

    public void runOpMode()
    {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        AutoMove am = new AutoMove();

        //trial 1
        am.driveForward(2, .5);
        am.turnRight(2.1, .4);
        am.driveForward(2, .5);
        am.turnLeft(1.5, .5);
        am.driveForward(2, .5);
        am.runIntake(2,.5);


        //trial 2
        am.strafeRight(1.5, .5);
        am.driveBackward(2, .4);
        am.driveForward(2, .5);
        am.strafeLeft(2.1, .4);



    }
}