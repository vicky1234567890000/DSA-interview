package core_java;

public class MultiThreadSingleton {

    private static MultiThreadSingleton instance = null;


    private MultiThreadSingleton(){

    }

    public static MultiThreadSingleton getInstance(){
        if(instance == null){

            synchronized (MultiThreadSingleton.class){
                if(instance == null){
                    instance = new MultiThreadSingleton();
                }
            }
        }

        return instance;
    }


    public Object readResolve(){
      return instance;
    }

}
