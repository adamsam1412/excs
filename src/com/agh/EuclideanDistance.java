package com.agh;

import java.util.Iterator;
import java.util.List;

public class EuclideanDistance<T extends Number> implements Distance {

    @Override
    public double distance(List dimension1, List dimension2) throws DimensionNotMatchingException {
        Iterator iterator = dimension1.iterator();
        while (iterator.hasNext()) {
            dimension1.add("ABC");
        }
        return 0;
    }


}
