package me.drton.jmavlib.conversion;

import org.la4j.Matrix;
import org.la4j.matrix.dense.Basic2DMatrix;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * User: ton Date: 02.06.13 Time: 20:20
 */
public class RotationConversion {
    public static Matrix rotationMatrixByEulerAngles(double roll, double pitch, double yaw) {
        Matrix R = new Basic2DMatrix(3, 3);
        R.set(0, 0, cos(pitch) * cos(yaw));
        R.set(0, 1, sin(roll) * sin(pitch) * cos(yaw) - cos(roll) * sin(yaw));
        R.set(0, 2, cos(roll) * sin(pitch) * cos(yaw) + sin(roll) * sin(yaw));
        R.set(1, 0, cos(pitch) * sin(yaw));
        R.set(1, 1, sin(roll) * sin(pitch) * sin(yaw) + cos(roll) * cos(yaw));
        R.set(1, 2, cos(roll) * sin(pitch) * sin(yaw) - sin(roll) * cos(yaw));
        R.set(2, 0, -sin(pitch));
        R.set(2, 1, sin(roll) * cos(pitch));
        R.set(2, 2, cos(roll) * cos(pitch));
        return R;
    }

    public static double[] eulerAnglesByQuaternion(double[] q) {
        return new double[]{
                Math.atan2(2.0 * (q[0] * q[1] + q[2] * q[3]), 1.0 - 2.0 * (q[1] * q[1] + q[2] * q[2])),
                Math.asin(2 * (q[0] * q[2] - q[3] * q[1])),
                Math.atan2(2.0 * (q[0] * q[3] + q[1] * q[2]), 1.0 - 2.0 * (q[2] * q[2] + q[3] * q[3])),
        };
    }
}
