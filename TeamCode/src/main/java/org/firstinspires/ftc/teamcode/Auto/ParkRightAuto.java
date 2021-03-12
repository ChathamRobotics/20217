package org.firstinspires.ftc.teamcode.Auto;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Auto.AutoMove;

@Autonomous
public class ParkRightAuto extends LinearOpMode {

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
            //strafe right 1 foot
            telemetry.addData("State", "1");
            telemetry.update();
            am.strafeRight(.25, 12);
            state = 2;
        }

        if (state == 2) {
            //pause motors for 2 seconds
            telemetry.addData("State", "2");
            telemetry.update();
            sleep(2000);
            state = 3;
        }

        if (state == 3) {
            //move forward six feet
            telemetry.addData("State", "3");
            telemetry.update();
            am.driveForward(.25, 72);
            state = 4;
        }
        if (state == 4) {
            //stop
            telemetry.addData("State", "3");
            telemetry.update();
            am.stopMotors();
            state = 5;
        }

    }


}