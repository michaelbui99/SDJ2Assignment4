package kingdom;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Catalogue
{
  private static Lock lock = new ReentrantLock();
  private static Catalogue catalogue;

  private Catalogue()
  {
  }

  public static Catalogue getInstance()
  {
    if (catalogue == null)
    {
      synchronized (lock)
      {
        if (catalogue == null)
        {
          catalogue = new Catalogue();
        }
      }
    }
      return catalogue;
  }

  public void gemDeposit(Gem gem)
  {
    System.out.println(gem.getGemType() + " is added to the treasure room!!");
  }

  public void partyTime()
  {
    System.out.println("Kings holds a party");
  }

  public void partyOver()
  {
    System.out.println("Kings stops the party");
  }

  public void currentWealth()
  {
    System.out.println("Accountants calculated: "+ TreasureRoom.getwealth() + "in treasureroom");
  }

}