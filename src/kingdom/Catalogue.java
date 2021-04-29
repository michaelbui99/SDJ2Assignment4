package kingdom;

import kingdom.gems.Gem;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//Singleton
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

  public void gemDeposit(Gem gem, String name)
  {
    System.out.println(gem.getGemType() + " is added to the deposit. Value: " + gem.getValue()+  " By " + name);
  }

  public void removeFromDeposit(Gem gem)
  {
    System.out.println(gem.getGemType() + " is removed from the deposit. Value: " + gem.getValue());
  }

  public void targetDepositValue(String name, int i)
  {
    System.out.println("Gem transporter " + name + " wants to collect gems with total value of: " + i );
  }

  public void gemTransporterFull(int i)
  {
    System.out.println("Gem transporter has hit the target value. Gem transporter currently has total value of: " + i);
  }

  public void waitingForGemDeposit()
  {
    System.out.println("Gem transporter is waiting for gems to be added to the deposit ");
  }

  public void partyTime()
  {
    System.out.println("Kings holds a party");
  }

  public void addToTreasureRoom(String actorName,Gem gem)
  {
    System.out.println( actorName + " added: " + gem.getGemType() + " Value: " + gem.getValue() + " to treasure room. Treasure room currently has: " + TreasureRoom.getWealth());
  }
  public void removeFromTreasureRoom(String actorName,Gem gem)
  {
    System.out.println( actorName + " removed: " + gem.getGemType() + " Value: " + gem.getValue() + " to treasure room");
  }

  public void partyOver()
  {
    System.out.println("Kings stops the party");
  }

  public void currentWealth()
  {
    System.out.println("Accountants calculated: "+ TreasureRoom.getWealth() + " in treasureroom");
  }

  public void waiting(String name)
  {
    System.out.println(name + " is waiting");
  }

  public void inTreasureRoom(String name)
  {
    System.out.println(name + " has entered the treasure room");
  }

  public void outTreasureRoom(String name)
  {
    System.out.println(name + " has left the treasure room");
  }

  public void kingPlanningAParty(int value)
  {
    System.out.println("The king is planning a party and he needs: " + value + " Treasure room currently has: " + TreasureRoom.getWealth());
  }
  public void partyCanceled()
  {
    System.out.println("The king has canceled the party");
  }
}