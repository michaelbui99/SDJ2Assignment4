package kingdom;
//Consumer of GemDeposit
//Writer of TreasureRoom
import kingdom.gems.Gem;

import java.util.ArrayList;
import java.util.Random;

public class GemTransporter implements Runnable
{
  private GemDeposit<Gem> gemDeposit;
  private Random random = new Random();
  private ArrayList<Gem> gems;
  private String name;
  private TreasureRoomDoor treasureRoomDoor;

  public GemTransporter(String name , GemDeposit<Gem> gemDeposit, TreasureRoomDoor treasureRoomDoor)
  {
    this.gemDeposit = gemDeposit;
    gems = new ArrayList<>();
    this.name = name;
    this.treasureRoomDoor = treasureRoomDoor;
  }

  private int getTotalGemValue()
  {
    int sum = 0;
    for (Gem gem : gems)
    {
      sum += gem.getValue();
    }
    return sum;
  }

  @Override public void run()
  {
    while (true)
    {
      try
      {
        int valueTarget = random.nextInt(151) + 50;
        Catalogue.getInstance().targetDepositValue(name, valueTarget);
        while (getTotalGemValue() < valueTarget)
        {
            gems.add(gemDeposit.dequeue());
        }
        Catalogue.getInstance().gemTransporterFull(getTotalGemValue());
        Thread.sleep(3000);

        while(!gems.isEmpty())
        {
          for (Gem gem : gems)
          {
          treasureRoomDoor.acquireWriteAccess("GemTransporter");
          treasureRoomDoor.addValuable(gem);
          Catalogue.getInstance().addToTreasureRoom(gem);
          gems.remove(gem);
          treasureRoomDoor.releaseWriteAccess("GemTransporter");
          }
        }
      }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
    }
  }
}
