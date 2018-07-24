package zeroMath;

public class Main {
	/*
	 * Demonstration
	 */
	public static void main(String[] args) {
		Matrix A = new Matrix(0, 0, 1, 10);
		Matrix B = new Matrix(A);
		Matrix.printM(A);
		Matrix.printM(B);
		A.negate();
		Matrix.printM(A);
		Matrix.printM(B);
		A.add(B);
		Matrix.printM(A);

	}
}
