package kingdom;

import kingdom.*;
import kingdom.gems.Gem;

import java.util.ArrayList;
import java.util.Random;

public class King implements Runnable
{
  //Writer for Treasure room

  private Random random = new Random();
  private ArrayList<Gem> gems;
  private String name;
  private TreasureRoomDoor treasureRoomDoor;
  private boolean notEnoughGems = true;
  private int targetValue;

  public King(String name, TreasureRoomDoor treasureRoomDoor)
  {
    this.name = name;
    gems = new ArrayList<>();
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
        treasureRoomDoor.acquireWriteAccess("King");
        targetValue = random.nextInt(101) + 50;
        Catalogue.getInstance().kingPlanningAParty(targetValue);
        notEnoughGems = true;
        if (!treasureRoomDoor.lookAtAllGems().isEmpty())
        {

        while (getTotalGemValue() < targetValue && notEnoughGems)
        {

          Gem retrievedGem = treasureRoomDoor.retrieveValuable();
          Catalogue.getInstance().removeFromTreasureRoom("King", retrievedGem);
          gems.add(retrievedGem);
          if (treasureRoomDoor.lookAtAllGems().isEmpty() && getTotalGemValue() < targetValue)
          {

            for (Gem gem : gems)
            {
              treasureRoomDoor.addValuable(gem);
              Catalogue.getInstance().addToTreasureRoom("King", gem);
            }
            gems.clear();
            Catalogue.getInstance().partyCanceled();
            treasureRoomDoor.releaseWriteAccess("King");
            notEnoughGems = false;
          }

          if (getTotalGemValue() >= targetValue)
          {

            treasureRoomDoor.releaseWriteAccess("King");
            Catalogue.getInstance().partyTime();
            Catalogue.getInstance().partyOver();
            Thread.sleep(3000);
          }
        }
            gems.clear();
        }
        else
          {

            treasureRoomDoor.releaseWriteAccess("King");
            Thread.sleep(1000);
          }

      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
   }
   }
   }


