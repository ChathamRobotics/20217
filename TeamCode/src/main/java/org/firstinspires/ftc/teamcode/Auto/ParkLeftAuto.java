package org.firstinspires.ftc.teamcode.Auto;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Auto.AutoMove;

@Autonomous
public class ParkLeftAuto extends LinearOpMode {

    public void runOpMode() {

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        AutoMove am = new AutoMove();

        waitForStart();

        int state = 0;
        if (state == 0) {
            //init robot
            waitForStart();
            state = 1;
        }

        if (state == 1) {
            telemetry.addData("State", "1");
            telemetry.update();
            am.strafeLeft(0.1, 12);
            //facing Forward strafe left one foot.
            state = 2;
        }

        if (state == 2) {
            telemetry.addData("State", "2");
            telemetry.update();
            sleep(2000);
            state = 3;
        }

        if (state == 3) {
            telemetry.addData("State", "3");
            telemetry.update();
            am.driveForward(0.1, 72);
            //Move forward six feet.
            state = 4;
        }

        if (state == 4) ;
        am.stopMotors();
        //stop all motion

    }
}