package com.edu.agh.XMLSerialize;

import com.edu.agh.Person;
import com.edu.agh.SerializationException;
import com.edu.agh.Serializator;
import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


//You require xstream-[version].jar, xpp3-[version].jar and xmlpull-[version].jar in the classpath


public class XMLSerializer<T extends Serializable> implements Serializator{

    private static XStream xStream = new XStream();
    private final static String output = "serializedXMl.xml";
    private final static Charset ENCODING = StandardCharsets.UTF_8;



    public static <T extends Serializable> void processObject(T object){
        exportXML(object);
    }

    private static void exportXML(Object object){

        try(Writer writer = new BufferedWriter
                (new OutputStreamWriter
                        (new FileOutputStream(output), ENCODING.name()))) {
            writer.write(serializeXML(object));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String serializeXML(Object object){
        return xStream.toXML(object);
    }


    @Override
    public void serialize(Serializable object) throws IOException {
        processObject(object);
    }

    @Override
    public T deserialize(String file) throws SerializationException{
        T newObject = null;
        try{
            newObject = (T)xStream.fromXML(new FileReader(file));
            System.out.println(newObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newObject;
    }
}
