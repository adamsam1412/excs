package com.edu.agh.exam.Vector;

public interface Vector<T extends Number> {

    T get(int index) throws InvalidIndexException;
    void set (int index, T value) throws InvalidIndexException;
    void add(Vector<T> vector) throws InvalidDimensionalityException;
    double dotProduct(Vector<T> vector) throws InvalidDimensionalityException, InvalidIndexException;
}
