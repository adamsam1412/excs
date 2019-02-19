package com.edu.agh.Study;

@FunctionalInterface
public interface Predicate<T> {

    boolean test(T t);

    default Predicate<T> and(Predicate<T> other){
        return t -> test(t) && other.test(t);
    }

    default Predicate<T> or(Predicate<T> other){
        return t -> test(t) || other.test(t);
    }

    static <U>Predicate<String> isEqualsTo(U u){

        return s -> s.equals(u);
    }
}
