package com.agh;

import java.util.List;

public interface Distance<T extends Number> {

    double distance(List<T> dimension1, List<T> dimension2) throws DimensionNotMatchingException;

}
