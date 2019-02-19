package com.edu.agh.exam.MatrixEx;

public interface Matrix<T extends Number> {

    T get(int row, int col);
    void set(int row, int col, T value);

}
