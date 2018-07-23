import java.util.Arrays;

//Project Matrix-Math-javadoc
/**
 * @author Z3R0R4
 * @version 0.1
 * @description Class for Matrices and applicable operations<br>
 *              no getters or setters yet<br>
 *              "https://stackoverflow.com/questions/1568091/why-use-getters-and-setters-accessors"
 *              Why can they never agree on anything...
 */
public class Matrix {
	/**
	 * @param data
	 *            2D Array that holds the Components of the Matrix
	 */
	private double data[][];
	/**
	 * @param rows
	 *            Variable that holds the number of rows of the Matrix, also called
	 *            'm', running variable 'i'
	 * @param columns
	 *            Variable that holds the number of columns of the Matrix, also
	 *            called 'n', running variable 'j'
	 */
	private int rows, columns; // m-by-n Matrix

	/**
	 * Creates an instance of the Matrix class filled only with zeroes
	 * 
	 * @param m
	 *            Number of rows of the new Matrix
	 * @param n
	 *            Number of columns of the new Matrix
	 */

	public Matrix(int m, int n) {
		this.rows = (m != 0) ? m : 3;
		this.columns = (n != 0) ? n : 3;
		System.out.println("Generating " + rows + "x" + columns + " Matrix filled with 0");
		this.data = new double[rows][columns];
		randomfill(0, 0);
	}

	/**
	 * Creates an Matrix (an instance of the Matrix class), which is filled with a
	 * given number on the diagonal currently only square Matrices can be created
	 * 
	 * @param m
	 *            Number of rows of the new diagonal Matrix
	 * @param n
	 *            Number of columns of the new diagonal Matrix
	 * @param diagfill
	 *            Number on the diagonal
	 */
	public Matrix(int m, int n, double diagfill) {
		System.out.println("Creating Diagonal Matrix");
		// if (m != n)
		// throw new IllegalArgumentException("rows=/=columns : only Square Matrices can
		// be Diagonal Matrices");

		this.rows = (m != 0) ? m : 3;
		this.columns = (n != 0) ? n : 3;
		this.data = new double[rows][columns];
		randomfill(0, 0);
		for (int i = 0; i < rows && i < columns; i++) // && i< M.columns
			this.data[i][i] = diagfill;

	}

	/**
	 * Creates an instance of the Matrix class filled with random numbers of an
	 * given interval
	 * 
	 * @param m
	 *            Number of rows of the new Matrix
	 * @param n
	 *            Number of columns of the new Matrix
	 * @param low
	 *            lower bound of randomness reach
	 * @param high
	 *            upper bound of randomness reach
	 */
	public Matrix(int m, int n, float low, float high) {
		this.rows = (m != 0) ? m : 3;
		this.columns = (n != 0) ? n : 3;
		System.out.println("Generating " + rows + "x" + columns + " Matrix filled with random Numbers");
		this.data = new double[rows][columns];
		randomfill(low, high);
	}

	/**
	 * Copy Constructor for duplication of Matrices <br>
	 * http://www.javapractices.com/topic/TopicAction.do?Id=12 <br>
	 * // Matrix Alpha = new Matrix(0,0,1,10); <br>
	 * // Matrix Beta = new Matrix(Alpha); //use this to create a copy <br>
	 * // Matrix Gamma = Alpha; //this copies the reference don't use it
	 * 
	 * @param another
	 *            instance Matrix to be copied
	 */
	public Matrix(Matrix another) {
		this.data = new double[another.rows][another.columns];
		for (int i = 0; i < another.data.length; i++)
			for (int j = 0; j < another.data[1].length; j++)
				this.data[i][j] = another.data[i][j];
		// this.data = another.data.clone(); //doesn't work
		this.rows = another.rows;
		this.columns = another.columns;
	}

	public static Matrix fromArray(double A[][]) {
		for (int i = 0; i < A.length - 1; i++)
			for (int j = i + 1; j < A.length; j++)
				if (A[i].length != A[j].length || A[i].length == 0)
					throw new IllegalArgumentException("Not a vaild Array");
		Matrix B = new Matrix(A.length, A[1].length);
		B.data = A;
		return B;
	}

	/**
	 * Fills the Matrix of the current instance with random numbers
	 * 
	 * @param low
	 *            lower bound of randomness reach
	 * @param high
	 *            upper bound of randomness reach
	 */
	private void randomfill(float low, float high) {
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				data[i][j] = (int) (Math.random() * high + low);
	}

	/**
	 * Prints a Matrix M to the console in an easily readable form
	 * 
	 * @param A
	 *            instance of Matrix which data is to be printed
	 */
	public static void printM(Matrix A) {
		System.out.println(A.rows + "x" + A.columns + " Matrix: " + A.data);
		System.out.println(Arrays.deepToString(A.data).replace("], ", "]\n ").replace(".0", "") + "\n");
	}

	/**
	 * Prints a Matrix M to the console as an Array for debugging
	 * 
	 * @param A
	 *            instance of Matrix which data is to be printed
	 */
	public static void printMA(Matrix A) {
		System.out.println(A.rows + "x" + A.columns + " Matrix: " + A.data);
		System.out.println(Arrays.deepToString(A.data) + "\n");
	}

	/**
	 * Creates a transposed version of a Matrix
	 * 
	 * @param A
	 *            instance of Matrix to be transposed
	 * @return transposed Matrix as instance of the Matrix class
	 */
	public static Matrix transpose(Matrix A) {
		System.out.println("Transposing Statically: " + A.data + " ^T");
		Matrix B = new Matrix(A.columns, A.rows);
		for (int i = 0; i < B.rows; i++)
			for (int j = 0; j < B.columns; j++)
				B.data[i][j] = A.data[j][i];
		return B;
	}

	/**
	 * Overwrites the Matrix of the current Instance with a transposed version of
	 * itself
	 */
	public void T() {
		System.out.println("Transposing: " + data + " ^T");
		Matrix B = new Matrix(columns, rows); // temporary Matrix
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				B.data[j][i] = data[i][j];
		data = B.data;
		rows = B.rows;
		columns = B.columns;
	}

	/**
	 * Standard Matrix multiplication A*B
	 * 
	 * @param A
	 *            the first factor Matrix. Instance of the Matrix class
	 * @param B
	 *            the second factor Matrix. Instance of the Matrix class
	 * @return Returns the product Matrix as an instance of the Matrix class
	 */
	public static Matrix prod(Matrix A, Matrix B) {
		System.out.println("Calculating Matrix Product Statially: " + A.data + " * " + B.data);
		if (A.columns != B.rows) {
			throw new IllegalArgumentException("Wrong Dimensions : A.columns != B.rows");
		}
		Matrix C = new Matrix(A.rows, B.columns);
		for (int i = 0; i < A.rows; i++)
			for (int j = 0; j < B.columns; j++)
				for (int r = 0; r < A.columns; r++)
					C.data[i][j] += A.data[i][r] * B.data[r][j];
		return C;
	}

	/**
	 * Overwrites the Matrix of the current Instance with a product of the current
	 * and given one
	 * 
	 * @param B
	 *            the second factor Matrix. Instance of the Matrix class
	 */
	public void prod(Matrix B) {
		System.out.println("Calculating Matrix Product: " + data + " * " + B.data);
		if (columns != B.rows) {
			throw new IllegalArgumentException("Wrong Dimensions : columns != B.rows");
		}
		Matrix C = new Matrix(rows, B.columns);
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < B.columns; j++)
				for (int r = 0; r < columns; r++)
					C.data[i][j] += data[i][r] * B.data[r][j];
		data = C.data;
	}

	/**
	 * Multiplies all components of a given Matrix by a given Scalar
	 * 
	 * @param scalar
	 *            double by which every component is to be multiplied
	 * @param A
	 *            Matrix which will be multiplied by the scalar
	 * @return the by the scalar multiplied Matrix
	 */
	public static Matrix scalarmult(double scalar, Matrix A) {
		System.out.println("Multipling by Scalar Statically: " + scalar + " * " + A.data);
		Matrix B = new Matrix(A);
		for (int i = 0; i < A.rows; i++)
			for (int j = 0; j < A.columns; j++)
				B.data[i][j] *= scalar;
		return B;
	}

	/**
	 * Overwrites the Matrix of the current Instance with itself multiplied by a
	 * given scalar
	 * 
	 * @param scalar
	 *            double by which every component is to be multiplied
	 */
	public void scalarmult(double scalar) {
		System.out.println("Multipling by Scalar: " + scalar + "*" + data);
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				data[i][j] *= scalar;
	}

	/**
	 * returns the Product of two Matrices multiplied component wise
	 * 
	 * @param A
	 *            first factor Matrix
	 * @param B
	 *            second factor Matrix
	 * @return component wise product of the two Matrices
	 */
	public static Matrix mult(Matrix A, Matrix B) {
		System.out.println("Multipling Statically component wise: " + A.data + " + " + B.data);
		if (A.rows != B.rows || A.columns != B.columns) {
			throw new IllegalArgumentException("Wrong Dimensions : A.rows != B.rows || A.columns!=B.columns");
		}
		Matrix C = new Matrix(A.rows, A.columns);
		for (int i = 0; i < C.rows; i++)
			for (int j = 0; j < C.columns; j++)
				C.data[i][j] = A.data[i][j] * B.data[i][j];
		return C;
	}

	/**
	 * Overwrites the Matrix of the current Instance with itself multiplied to a
	 * given factor Matrix
	 * 
	 * @param B
	 *            factor Matrix
	 */
	public void mult(Matrix B) {
		System.out.println("Multipling component wise: " + data + " + " + B.data);
		if (rows != B.rows || columns != B.columns) {
			throw new IllegalArgumentException("Wrong Dimensions : rows != B.rows || columns!=B.columns");
		}
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				data[i][j] *= B.data[i][j];
	}

	/**
	 * returns the sum of two Matrices added component wise
	 * 
	 * @param A
	 *            first summand Matrix
	 * @param B
	 *            second summand Matrix
	 * @return component wise sum of the two Matrices
	 */
	public static Matrix add(Matrix A, Matrix B) {
		System.out.println("Adding Statically: " + A.data + " + " + B.data);
		if (A.rows != B.rows || A.columns != B.columns) {
			throw new IllegalArgumentException("Wrong Dimensions : A.rows != B.rows || A.columns!=B.columns");
		}
		Matrix C = new Matrix(A.rows, A.columns);
		for (int i = 0; i < C.rows; i++)
			for (int j = 0; j < C.columns; j++)
				C.data[i][j] = A.data[i][j] + B.data[i][j];
		return C;
	}

	/**
	 * Overwrites the Matrix of the current Instance with itself added to a given
	 * summand Matrix
	 * 
	 * @param B
	 *            summand Matrix
	 */
	public void add(Matrix B) {
		System.out.println("Adding: " + data + " + " + B.data);
		if (rows != B.rows || columns != B.columns) {
			throw new IllegalArgumentException("Wrong Dimensions : rows != B.rows || columns!=B.columns");
		}
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				data[i][j] += B.data[i][j];
	}

	/**
	 * "inverts" every component of a given Matrix 1/Aij
	 * 
	 * @param A
	 *            Matrix which is to be inverted
	 * @return the "inverted" Matrix
	 */
	public static Matrix invert(Matrix A) {
		System.out.println("Inverting Statically: " + A.data + " ij^(-1)");
		Matrix B = new Matrix(A);
		for (int i = 0; i < A.rows; i++)
			for (int j = 0; j < B.columns; j++)
				B.data[i][j] = 1 / B.data[i][j];
		return B;
	}

	/**
	 * Overwrites the Matrix of the current Instance with a component wise inverted
	 * Version of itself
	 */
	public void invert() {
		System.out.println("Inverting" + data + "-Aij");
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				data[i][j] = 1 / data[i][j];
	}

	/**
	 * "negates" every component of a given Matrix 1/Aij
	 * 
	 * @param A
	 *            Matrix which is to be inverted
	 * @return the "inverted" Matrix
	 */
	public static Matrix negate(Matrix A) {
		System.out.println("Negating Statically" + A.data + "-A ij");
		Matrix B = new Matrix(A);
		for (int i = 0; i < A.rows; i++)
			for (int j = 0; j < B.columns; j++)
				B.data[i][j] = -B.data[i][j];
		return B;
	}

	/**
	 * Overwrites the Matrix of the current Instance with a component wise negated
	 */
	public void negate() {
		System.out.println("Negating: " + data + "-Aij");
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				this.data[i][j] = -this.data[i][j];
	}
}
