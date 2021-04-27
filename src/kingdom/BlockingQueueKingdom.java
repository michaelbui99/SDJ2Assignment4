package kingdom;

public interface BlockingQueueKingdom<T>
{
  void enqueue(T t) throws InterruptedException;
  T dequeue() throws InterruptedException;
  boolean isFull();
}
