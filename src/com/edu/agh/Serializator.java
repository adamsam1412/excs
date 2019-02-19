package com.edu.agh;

import java.io.IOException;
import java.io.Serializable;

public interface Serializator<T extends Serializable>  {

    void serialize(T object) throws IOException;
    T deserialize(String file) throws SerializationException;
}
