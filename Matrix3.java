public class Matrix3 {
    double[] mElements;

    Matrix3(double[] mElements) {
        this.mElements = mElements;
    }

    // For matrix multiplication debuging

    // matrix multiplication 3x3
    Matrix3 multiply(Matrix3 other) {
        double[] result = new double[9];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                for (int i = 0; i < 3; i++) {
                    result[row * 3 + col] +=
                        this.mElements[row * 3 + i] * other.mElements[i * 3 + col];
                }
            }
        }
        return new Matrix3(result);
    }
    Vertex transform(Vertex in) {
        return new Vertex(
            in.x * mElements[0] + in.y * mElements[3] + in.z * mElements[6],
            in.x * mElements[1] + in.y * mElements[4] + in.z * mElements[7],
            in.x * mElements[2] + in.y * mElements[5] + in.z * mElements[8]
        );
    }
}
