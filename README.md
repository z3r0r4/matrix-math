# matrix-math.clean
A Java Matrix Math Library<br>
credit to [AvoLord](https://github.com/Avolord) and his [JavaScript Matrix Library](https://github.com/Avolord/AvoMatrix) for providing some inspiration
## Documentation
You can find the Javadoc Documentation [here](https://z3r0r4.github.io/matrix-math/Matrix.html)<br>
Or you can find all the raw Javadoc comments [converted](https://delight-im.github.io/Javadoc-to-Markdown) to Markdown in this README.md.


## Documentation

### `public class Matrix`

 * **Author:** Z3R0R4
 * **Version:** 0.1-gamma.1

### `private double data[][]`

 * **Parameters:** `data` — 2D Array that holds the Components of the Matrix

### `private int rows, columns`

 * **Parameters:**
   * `rows` — Variable that holds the number of rows of the Matrix, also called

     'm', running variable 'i'
   * `columns` — Variable that holds the number of columns of the Matrix, also

     called 'n', running variable 'j'

### `public Matrix(int m, int n)`

Creates an instance of the Matrix class filled only with zeroes

 * **Parameters:**
   * `m` — Number of rows of the new Matrix
   * `n` — Number of columns of the new Matrix

### `public Matrix(int m, int n, double diagfill)`

Creates an Matrix (an instance of the Matrix class), which is filled with a given number on the diagonal currently only square Matrices can be created

 * **Parameters:**
   * `m` — Number of rows of the new diagonal Matrix
   * `n` — Number of columns of the new diagonal Matrix
   * `diagfill` — Number on the diagonal

### `public Matrix(int m, int n, float low, float high)`

Creates an instance of the Matrix class filled with random numbers of an given interval

 * **Parameters:**
   * `m` — Number of rows of the new Matrix
   * `n` — Number of columns of the new Matrix
   * `low` — lower bound of randomness reach
   * `high` — upper bound of randomness reach

### `public Matrix(Matrix another)`

Copy Constructor for duplication of Matrices

 * **Parameters:** `another` — instance Matrix to be copied

### `public double[][] getData()`

Returns the Data or the Matrix of the Object it was called upon

 * **Returns:** 2D-Double Array holding all the components of the Matrix

     <p>

### `public double getData(int i, int j)`

Returns the Matrix component with the coordinates i,j

 * **Parameters:**
   * `i` — index of row in which the value is found
   * `j` — index of column in which the value is found

### `public void setData(double[][] aData)`

Sets the Data of the Matrix (all components) to new values determined by the given Array

 * **Parameters:** `aData` — double 2D-Array of fitting length

### `public void setData(double aDatapoint, int i, int j)`

Sets the Matrix component with the coordinates i,j to the specified data value

 * **Parameters:**
   * `aDatapoint` — value which the component shall be set to
   * `i` — index of row in which the value is found
   * `j` — index of column in which the value is found

### `public int getRows()`

Returns the Number of Rows of the instance on which it was invoked

 * **Returns:** Number of Rows

### `public int getColumns()`

Returns the Number of Columns of the instance on which it was invoked

 * **Returns:** Number of Columns

### `public void info(Object c)`

(EXPERIMENTAL) Prints information about the Object invoked on to the console

 * **Parameters:** `c` — modifier for verbosity

### `public Matrix copy()`

Copies all attributes of the current instance and returns it as a new instance

 * **Returns:** a new instance of the Matrix class with the same attributes as the

     one on which the method was invoked

### `public static Matrix fromArray(double A[][])`

creates and returns an Matrix Object containing the values specified in the given Array

 * **Parameters:** `A` — 2D-Double Array which holds the components of the new Matrix
 * **Returns:** an new Matrix Object containing the data of the Array

### `private void randomfill(double min, double max)`

Fills the Matrix of the current instance with random numbers

 * **Parameters:**
   * `low` — lower bound of randomness reach
   * `high` — upper bound of randomness reach

### `public String toString_auto()`

by AvoLord

### `public static Matrix fromString(String matrix)`

by AvoLord

### `public static void printM(Matrix A)`

Prints a Matrix M to the console in an easily readable form

 * **Parameters:** `A` — instance of Matrix which data is to be printed

### `public static void printMA(Matrix A)`

Prints a Matrix M to the console as an Array for debugging

 * **Parameters:** `A` — instance of Matrix which data is to be printed

### `public static Matrix T(Matrix A)`

Creates a transposed version of a Matrix

 * **Parameters:** `A` — instance of Matrix to be transposed
 * **Returns:** transposed Matrix as instance of the Matrix class

### `public void T()`

Overwrites the Matrix of the current Instance with a transposed version of itself

### `public static Matrix prod(Matrix A, Matrix B)`

Standard Matrix multiplication A*B

 * **Parameters:**
   * `A` — the first factor Matrix. Instance of the Matrix class
   * `B` — the second factor Matrix. Instance of the Matrix class
 * **Returns:** Returns the product Matrix as an instance of the Matrix class

### `public void prod(Matrix B)`

Overwrites the Matrix of the current Instance with a product of the current and given one

 * **Parameters:** `B` — the second factor Matrix. Instance of the Matrix class

### `public static Matrix scalarmult(double scalar, Matrix A)`

Multiplies all components of a given Matrix by a given Scalar

 * **Parameters:**
   * `scalar` — double by which every component is to be multiplied
   * `A` — Matrix which will be multiplied by the scalar
 * **Returns:** the by the scalar multiplied Matrix

### `public void scalarmult(double scalar)`

Overwrites the Matrix of the current Instance with itself multiplied by a given scalar

 * **Parameters:** `scalar` — double by which every component is to be multiplied

### `public static Matrix mult(Matrix A, Matrix B)`

returns the Product of two Matrices multiplied component wise

 * **Parameters:**
   * `A` — first factor Matrix
   * `B` — second factor Matrix
 * **Returns:** component wise product of the two Matrices

### `public void mult(Matrix B)`

Overwrites the Matrix of the current Instance with itself multiplied to a given factor Matrix

 * **Parameters:** `B` — factor Matrix

### `public static Matrix add(Matrix A, Matrix B)`

returns the sum of two Matrices added component wise

 * **Parameters:**
   * `A` — first summand Matrix
   * `B` — second summand Matrix
 * **Returns:** component wise sum of the two Matrices

### `public void add(Matrix B)`

Overwrites the Matrix of the current Instance with itself added to a given summand Matrix

 * **Parameters:** `B` — summand Matrix

### `public static Matrix invert(Matrix A)`

"inverts" every component of a given Matrix 1/Aij

 * **Parameters:** `A` — Matrix which is to be inverted
 * **Returns:** the "inverted" Matrix

### `public void invert()`

Overwrites the Matrix of the current Instance with a component wise inverted Version of itself

### `public static Matrix negate(Matrix A)`

"negates" every component of a given Matrix 1/Aij

 * **Parameters:** `A` — Matrix which is to be inverted
 * **Returns:** the "inverted" Matrix

### `public void negate()`

Overwrites the Matrix of the current Instance with a component wise negated
