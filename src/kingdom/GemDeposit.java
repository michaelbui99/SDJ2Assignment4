package kingdom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class GemDeposit<Gem> implements BlockingQueue<Gem>
{
  private ListADT<Gem> gemListADT = new ArrayListKingdom<Gem>();
  private int capacity;

  public GemDeposit(int capacity)
  {
   this.capacity = capacity;
  }

 @Override public synchronized boolean add(Gem gem)
 {
//  while (size() >= capacity)
//  {
//   try
//   {
//    wait();
//   }
//   catch (InterruptedException e)
//   {
//    e.printStackTrace();
//   }
//  }
//  gemListADT.add(gem);
//  notifyAll();
  return false;
 }

 @Override public boolean offer(Gem gem)
 {
  return false;
 }

 @Override public Gem remove()
 {
  return null;
 }

 @Override public Gem poll()
 {
  return null;
 }

 @Override public Gem element()
 {
  return null;
 }

 @Override public Gem peek()
 {
  return null;
 }

 @Override public void put(Gem gem) throws InterruptedException
 {
  while (size() >= capacity)
  {
   try
   {
    wait();
   }
   catch (InterruptedException e)
   {
    e.printStackTrace();
   }
  }
  gemListADT.add(gem);
  notifyAll();
 }

 @Override public boolean offer(Gem gem, long timeout, TimeUnit unit)
     throws InterruptedException
 {
  return false;
 }

 @Override public synchronized Gem take() throws InterruptedException
 {
  while (gemListADT.isEmpty())
  {
   wait();
  }
  Gem gem = gemListADT.remove(size()-1);
  notifyAll();
  return gem;
 }

 @Override public Gem poll(long timeout, TimeUnit unit)
     throws InterruptedException
 {

  return null;
 }

 @Override public int remainingCapacity()
 {
  return capacity-size();
 }

 @Override public boolean remove(Object o)
 {
  return false;
 }

 @Override public boolean containsAll(Collection<?> c)
 {
  return false;
 }

 @Override public boolean addAll(Collection<? extends Gem> c)
 {
  return false;
 }

 @Override public boolean removeAll(Collection<?> c)
 {
  return false;
 }

 @Override public boolean retainAll(Collection<?> c)
 {
  return false;
 }

 @Override public void clear()
 {

 }

 @Override public int size()
 {
  return 0;
 }

 @Override public boolean isEmpty()
 {
  return false;
 }

 @Override public boolean contains(Object o)
 {
  return false;
 }

 @Override public Iterator<Gem> iterator()
 {
  return null;
 }

 @Override public Object[] toArray()
 {
  return new Object[0];
 }

 @Override public <T> T[] toArray(T[] a)
 {
  return null;
 }

 @Override public int drainTo(Collection<? super Gem> c)
 {
  return 0;
 }

 @Override public int drainTo(Collection<? super Gem> c, int maxElements)
 {
  return 0;
 }
}
