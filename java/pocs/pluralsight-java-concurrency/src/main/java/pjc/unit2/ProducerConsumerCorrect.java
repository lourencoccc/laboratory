package pjc.unit2;

/**
 * Created by lourenco on 15/08/17.
 */
public class ProducerConsumerCorrect {

  private static Object lock = new Object();

  private static int[] buffer;
  private static int count;

  static class Producer {
    void produce(){
      synchronized (lock) {
        if (isFull(buffer)) {
          try{
              //releasing the lock
              lock.wait();
          }catch (InterruptedException e){
            e.printStackTrace();
          }
        }
        buffer[count++] = 1;
        //release a thread in WAIT state and puts it in RUNNABLE state
        lock.notify();
      }
    }
  }

  static class Consumer {
    void consume(){
      synchronized (lock) {
        if (isEmpty(buffer)) {
          try{
            //releasing the lock
            lock.wait();
          }catch (InterruptedException e){
            e.printStackTrace();
          }
        }
        buffer[--count] = 0;
        //release a thread in WAIT state and puts it in RUNNABLE state
        lock.notify();
      }
    }
  }

  static boolean isEmpty(int[] buffer) {
    return count == 0;
  }

  static boolean isFull(int[] buffer) {
    return count == buffer.length;
  }

  public static void main(String[] args) throws InterruptedException {
    buffer = new int[10];
    count = 0;

    Producer producer = new Producer();
    Consumer consumer = new Consumer();

    Runnable produceTask =  () -> {
      for (int i = 0; i < 50; i++) {
        producer.produce();
      }
      System.out.println("Done producing");
    };

    Runnable consumeTask =  () -> {
      for (int i = 0; i < 43; i++) {
        consumer.consume();
      }
      System.out.println("Done consuming");
    };

    Thread consumerThread = new Thread(consumeTask);
    Thread producerThread = new Thread(produceTask);

    consumerThread.start();
    producerThread.start();

    consumerThread.join();
    producerThread.join();


    System.out.println("Data in the buffer: " + count);

  }



}