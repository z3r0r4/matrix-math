package zeroMath;

public class Main {

	public static void main(String[] args) {
		Matrix A = new Matrix(0, 0, 1, 10);
		A.setData(1, 0, 2);
		Matrix.printM(A);
		A.info(null);
	}
}
