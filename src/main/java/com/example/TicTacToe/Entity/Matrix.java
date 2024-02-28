package com.example.TicTacToe.Entity;

public class Matrix {

    private final int[][] matrix;

    public Matrix() {
        this.matrix = new int[3][3];

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j <3; j++) {
                this.matrix[i][j] = -1;
            }
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int row, int column, int entry) {
        this.matrix[row][column] = entry;
    }
}
