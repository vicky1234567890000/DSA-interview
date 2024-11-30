package core_java;

import java.io.Serializable;

public class SerializableSingleton implements Serializable {
    private static SerializableSingleton instance = null;

    private SerializableSingleton(){

    }

    public static SerializableSingleton getInstance(){
        if(instance == null){
            synchronized (SerializableSingleton.class){
                if(instance == null){
                    instance = new SerializableSingleton();
                }
            }

        }
        return instance;
    }

    protected Object readResolve(){
        return instance;
    }
}
