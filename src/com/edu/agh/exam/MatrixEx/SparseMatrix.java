package com.edu.agh.exam.MatrixEx;


import com.agh.DimensionNotMatchingException;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SparseMatrix<T extends Number> implements Matrix<T> {

    Map<Integer, Map<Integer, T>> matrix;
    private final int x;
    private final int y;

    public SparseMatrix(int row, int col) {
        this.x = row;
        this.y = col;
        matrix = new TreeMap<>();
        T def = (T) new Integer(0);
        for(int i = 0; i < row; i ++) {
            matrix.put(i, new TreeMap<>());
            for(int j = 0; j < col; j++) {
                matrix.get(i).put(j, def);
            }
        }
    }



    @Override
    public T get(int row, int col) {
        return matrix.get(row).get(col);
    }

    @Override
    public void set(int row, int col, T value) {
        matrix.get(row).put(col, value);
    }

    public void print() {
        matrix.entrySet().forEach(System.out::println);
    }

    public static  <T extends Number>Matrix<Double> add(Matrix<T> a, Matrix<T> b) throws DimensionNotMatchingException{

        if(a == null || b == null)
            return null;

        SparseMatrix<T> matrixA = (SparseMatrix) a;
        SparseMatrix<T> matrixB = (SparseMatrix) b;

        if(matrixA.x != matrixB.x || matrixA.y != matrixB.y)
            throw new DimensionNotMatchingException("Matrixes can't be sumed");

        Matrix<Double> result = new SparseMatrix<>(matrixA.x, matrixA.y);

        for(int i = 0; i < matrixA.x; i++) {
            for(int j = 0; j < matrixA.y; j++) {
                result.set(i, j, (Double) matrixA.get(i, j) + (Double) matrixB.get(i, j));
            }
        }
        return result;
    }




}
