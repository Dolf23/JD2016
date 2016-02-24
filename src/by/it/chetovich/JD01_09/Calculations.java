package by.it.chetovich.JD01_09;

/**
 * class for different operations with different types of variables
 */
public class Calculations {

    /**
     *
     * @param a float number, Class FloatVar field
     * @param b float number, Class FloatVar field
     * @return the sum of a and b
     */
    public static float add (float a, float b){
        return a+b;
    }

    /**
     *
     * @param a float [] array, Class VectorVar field
     * @param b float number, Class FloatVar field
     * @return the sum of vector a and number b
     */
    public static float[] add (float []a, float b){
        float[] result = new float[a.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = a[i] + b;
        }
        return result;
    }

    /**
     *
     * @param a float [][] array, Class MatrixVar field
     * @param b float number, Class FloatVar field
     * @return the sum of array a and number b
     */
    public static float[][] add (float [][]a, float b){
        float[][] result = new float[a.length][a[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length ; j++) {
                result[i][j] = a[i][j] + b;
            }
        }
        return result;
    }

    /**
     *
     * @param a float [] array, Class VectorVar field
     * @param b float [] array, Class VectorVar field
     * @return the sum of a and b
     */
    public static float [] add (float [] a, float [] b){
        float [] result = new float[a.length];
        for (int i = 0; i < result.length; i++) {
            result [i] = a[i] + b[i];
        }
        return result;
    }

    /**
     *
     * @param a float [][] array, Class MatrixVar field
     * @param b float [][] array, Class MatrixVar field
     * @return the sum of a and b
     */
    public static float [][] add (float [][] a, float [][] b){
        float [][] result = new float[a.length][a[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result [i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    /**
     *
     * @param a float number, Class FloatVar field
     * @param b float number, Class FloatVar field
     * @return the subtraction of a and b
     */
    public static float sub (float a, float b){
        return a-b;
    }



    /**
     *
     * @param a float [] array, Class VectorVar field
     * @param b float [] array, Class VectorVar field
     * @return the subtraction of a and b
     */
    public static float [] sub (float [] a, float [] b){
        float [] result = new float[a.length];
        for (int i = 0; i < result.length; i++) {
            result [i] = a[i] - b[i];
        }
        return result;
    }

    /**
     *
     * @param a float [] array, Class VectorVar field
     * @param b float number, Class FloatVar field
     * @return the subtraction of vector a and number b
     */
    public static float[] sub (float []a, float b){
        float[] result = new float[a.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = a[i] - b;
        }
        return result;
    }

    /**
     *
     * @param a float [][] array, Class MatrixVar field
     * @param b float number, Class FloatVar field
     * @return the subtraction of array a and number b
     */
    public static float[][] sub (float [][]a, float b){
        float[][] result = new float[a.length][a[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length ; j++) {
                result[i][j] = a[i][j] - b;
            }
        }
        return result;
    }


    /**
     *
     * @param a float [][] array, Class MatrixVar field
     * @param b float [][] array, Class MatrixVar field
     * @return the subtraction of a and b
     */
    public static float [][] sub (float [][] a, float [][] b){
        float [][] result = new float[a.length][a[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result [i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }

    /**
     *
     * @param a float number, Class FloatVar field
     * @param b float number, Class FloatVar field
     * @return the multiplication of a and b
     */
    public static float multi(float a, float b){
        return a*b;
    }

    /**
     *
     * @param a float number, Class FloatVar field
     * @param b float [] array, Class VectorVar field
     * @return the multiplication of a and b
     */
    public static float [] multi (float a, float [] b){
        float [] result = new float[b.length];
        for (int i = 0; i < result.length; i++) {
            result [i] = a*b[i];
        }
        return result;
    }

    /**
     *
     * @param a float number, Class FloatVar field
     * @param b float [][] array, Class MatrixVar field
     * @return the multiplication of a and b
     */
    public static float [][] multi (float a, float [][] b){
        float [][] result = new float[b.length][b[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result [i][j] = a*b[i][j];
            }
        }
        return result;
    }

    /**
     *
     * @param a float [] array, Class VectorVar field
     * @param b float [] array, Class VectorVar field
     * @return the multiplication of a and b
     */
    public static float multi (float [] a, float [] b) {
        float result = 1;
        if (a.length==b.length) {
            for (int i = 0; i < a.length; i++) {
                result += a[i] * b[i];
            }
            return result;
        }
        else{
            System.out.println("Векторы разной длины нельзя перемножить.");
            return 0;
        }

    }

    /**
     *
     * @param a float [] array, Class VectorVar field
     * @param b float [][] array, Class MatrixVar field
     * @return the multiplication of a and b - float [] result
     */
    public static float [] multi (float [] a, float [][] b){
            float [] result = new float[a.length];
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b.length; j++) {
                    result[i] += b[i][j]*a[j];
                }
            }
            return result;
    }

    /**
     *
     * @param a float [][] array, Class MatrixVar field
     * @param b float [][] array, Class MatrixVar field
     * @return the multiplication of a and b - float [][] result
     */
    public static float [][] multi (float[][] a, float[][] b) {
            float[][] result = new float[a.length][b[0].length];
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b[0].length; j++) {
                    for (int k = 0; k < b.length; k++) {
                        result[i][j] += a[i][k]+b[k][j];
                    }
                }
            }
            return result;
    }

    /**
     *
     * @param a float number, Class FloatVar field
     * @param b float number, Class FloatVar field
     * @return the result of division a and b
     */
    public static float divide (float a, float b){
        return a/b;
    }


}
