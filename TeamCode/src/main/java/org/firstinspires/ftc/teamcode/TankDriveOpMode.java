package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "2 Motor Outreach Tank Drive", group = "Outreach")
public class TankDriveOpMode extends LinearOpMode {
    // Declare motors
    private DcMotor leftMotor;
    private DcMotor rightMotor;

    @Override
    public void runOpMode() {
        // Initialize the motors
        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");

        // Set motor directions
        leftMotor.setDirection(DcMotor.Direction.FORWARD);
        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        // Wait for the game pad
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            // Get joystick values
            double leftPower = -gamepad1.left_stick_y;  // Negative because joystick up is negative
            double rightPower = -gamepad1.right_stick_y;

            // Set motor powers
            leftMotor.setPower(leftPower);
            rightMotor.setPower(rightPower);

            // Show motor powers in telemetry
            telemetry.addData("Left Motor Power", leftPower);
            telemetry.addData("Right Motor Power", rightPower);
            telemetry.update();
        }
    }
}
