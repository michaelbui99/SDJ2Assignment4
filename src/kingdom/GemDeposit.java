package kingdom;
//adapter
public class GemDeposit<Gem> implements BlockingQueueKingdom<Gem>
{
  private ListADT<Gem> gemListADT = new ArrayListKingdom<Gem>();
  private int capacity;

  public GemDeposit(int capacity)
  {
   this.capacity = capacity;
  }

 @Override public synchronized void enqueue(Gem gem) throws InterruptedException
 {
  while (isFull())
  {
   Catalogue.getInstance().waiting("Mine worker");
   wait();
  }
  gemListADT.add(gem);
  notifyAll();
//  Catalogue.getInstance().gemDeposit((kingdom.gems.Gem) gem);
 }

 @Override public synchronized Gem dequeue() throws InterruptedException
 {
  while (gemListADT.isEmpty())
  {
   Catalogue.getInstance().waitingForGemDeposit();
   wait();
  }
  Gem gem = gemListADT.remove(gemListADT.size()-1);
  notifyAll();
  Catalogue.getInstance().removeFromDeposit((kingdom.gems.Gem) gem);
  return gem;
 }

 @Override public boolean isFull()
 {
  return capacity == gemListADT.size();
 }
}
