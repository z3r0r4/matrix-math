# matrix-math
A Java Matrix Math Library

## Documentation

### `public class Matrix`

 * **Author:** Z3R0R4
 * **Version:** 0.1

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

Copy Constructor for duplication of Matrices <br> http://www.javapractices.com/topic/TopicAction.do?Id=12 <br> // Matrix Alpha = new Matrix(0,0,1,10); <br> // Matrix Beta = new Matrix(Alpha); //use this to create a copy <br> // Matrix Gamma = Alpha; //this copies the reference don't use it

 * **Parameters:** `another` — instance Matrix to be copied

### `private void randomfill(float low, float high)`

Fills the Matrix of the current instance with random numbers

 * **Parameters:**
   * `low` — lower bound of randomness reach
   * `high` — upper bound of randomness reach

### `public static void printM(Matrix A)`

Prints a Matrix M to the console in an easily readable form

 * **Parameters:** `A` — instance of Matrix which data is to be printed

### `public static void printMA(Matrix A)`

Prints a Matrix M to the console as an Array for debugging

 * **Parameters:** `A` — instance of Matrix which data is to be printed

### `public static Matrix transpose(Matrix A)`

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
