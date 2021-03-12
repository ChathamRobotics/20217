package org.firstinspires.ftc.teamcode.Auto;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Auto.AutoMove;

@Autonomous
public class TestMotorAuto extends LinearOpMode {

    public void runOpMode() {

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        AutoMove am = new AutoMove();

        waitForStart();

        int state = 0;
        if (state == 0) {
            //init robot
            //init(hardwareMap);
            waitForStart();
            state = 1;
        }

        if (state == 1) {
            telemetry.addData("State", "1");
            telemetry.update();
            am.driveForward(0.25, 4800);
            state = 2;
        }

        if (state == 2) {
            telemetry.addData("State", "1");
            telemetry.update();
            am.runIntake(2, .5);
            state = 3;
        }

        if (state == 3) ;
        am.stopMotors();
        //stop all motion

    }
}