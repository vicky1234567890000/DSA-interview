package core_java.multithreading;

public class SharedResource {

    private boolean isItemPresent;

    public synchronized void addItem(){
        isItemPresent = true;
        System.out.println("addItem method invoked by thread = " + Thread.currentThread().getName());
        System.out.println("Item added successfully");
        notifyAll();
    }

    public synchronized void consumeItem(){
        System.out.println("consumeItem method invoked by thread = " + Thread.currentThread().getName());

        while(!isItemPresent){
            System.out.println("thread : " + Thread.currentThread().getName() + " is waiting now");

            try{
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Item consumed successfully");
        isItemPresent = false;
    }
}
