package com.company;

public class Main {
    public static void main(String[] args) {
        com.company.Matrix firstMatrix = new com.company.Matrix(2, 2);
        System.out.println("first Matrix:");
        firstMatrix.displayMatrix();

        com.company.Matrix secondMatrix = new com.company.Matrix(2,2);
        System.out.println("second Matrix:");
        secondMatrix.displayMatrix();

        System.out.println("Matrix +");
        firstMatrix.sumWithNewMatrix(secondMatrix.getMatrix());
        System.out.println("Matrix * n"); // где n = число
        firstMatrix.multiply(10);
        firstMatrix.displayMatrix();

        System.out.println("Matrix * Matrix");
        double[][] result = com.company.Matrix.mullMatrix(firstMatrix.getMatrix(), secondMatrix.getMatrix());
        com.company.Matrix.displayMatrix(result);

        System.out.println("rectangular Matrix");
        com.company.RectangleMatrix rectMatrix = new com.company.RectangleMatrix(2,2);
        rectMatrix.displayMatrix();
        double determinant = rectMatrix.determinant(rectMatrix.getMatrix());
        System.out.printf("Определитель: %.3f", determinant);
    }
}


class Matrix {
    protected int columns;
    protected int rows;
    protected double [][] M; //

    Matrix (int m, int n) {
        this.rows = m;
        this.columns = n;
        this.M = new double[m][n];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                M[i][j] = Math.random() * 100;
            }
        }
    }

    void displayMatrix() {
        for (int i = 0; i < this.rows; i++) {
            System.out.println();
            System.out.print("|");
            for (int j = 0; j < this.columns; j++) {
                System.out.printf(" %.3f", this.M[i][j]);
            }
            System.out.print(" |");
        }
        System.out.println();
    }

    static void displayMatrix(double[][] M) {
        for (int i = 0; i < M.length; i++) {
            System.out.println();
            System.out.print("|");
            for (int j = 0; j < M[0].length; j++) {
                System.out.printf(" %.3f", M[i][j]);
            }
            System.out.print(" |");
        }
        System.out.println();
    }

    void sumWithNewMatrix(double[][] newM) {
        if (newM[0].length != this.columns || newM.length != this.rows) {
            throw new IllegalArgumentException(
                    "Нельзя сложить матрицы! Начальная матрица: " + this.rows + "x" + this.columns +
                            " А ваша: " + newM.length + "x" + newM[0].length);
        }
        double[][] result = new double[this.rows][this.columns];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result[i][j] = this.M[i][j] + newM[i][j];
            }
        }
        displayMatrix(result);
    }

    void multiply(int asd) {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.M[i][j] *= asd;
            }
        }
    }

    double[][] getMatrix() {
        return this.M;
    }

    static public double[][] multiplyMatrix(double[][] A, double[][] B) {
        if (A[0].length != B.length) {
            throw new IllegalArgumentException(
                    "Нельзя умножить матрицы! Начальная матрица: " + A[0].length + "x" + A.length +
                            " Вторая: " + B.length + "x" + B[0].length + " т.е. " + A[0].length + "!=" + B.length);
        }
        double[][] result = new double[B.length][A[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                for (int k = 0; k < result.length; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

}

class RectangleMatrix extends com.company.Matrix {

    RectangleMatrix(int rows, int columns) {
        super(rows, columns);
    }

    double[][] minor(double[][] M, int i, int j) {
        double[][] minor = new double[M.length-1][M.length-1];
        for (int k = 0; k < M.length; k++) {
            for (int l = 0; k != i && l < M[k].length; l++) {
                if (l != j) {
                    minor[(k < i) ? k : k - 1][(l < j) ? l : l - 1] = M[k][l];
                }
            }
        }
        return minor;
    }

    double determinant(double[][] M) {
        if (M[0].length != M.length){
            throw new IllegalArgumentException(
                    "Невозможно найти определителm vаша матрица размером: MxN А должна быть NxN");
        }
        if (M.length == 2) {
            return M[0][0] * M[1][1] - M[0][1] * M[1][0];
        }
        double determinant = 0;
        for (int c = 0; c < M.length; c++) {
            determinant += (Math.pow((-1), c) * M[0][c] * determinant(minor(M, 0, c)));
        }
        return determinant;
    }

}
