package kingdom;

public class Accountant implements Runnable
{
  private TreasureRoomDoor treasureRoomDoor;


  public Accountant(TreasureRoomDoor treasureRoomDoor)
  {
    this.treasureRoomDoor = treasureRoomDoor;
  }

  @Override public void run()
  {
    while(true)
    {
      try
      {
        treasureRoomDoor.acquireReadAccess("Accountant");
        double wealth = TreasureRoom.getWealth();
        Thread.sleep(2000);
        Catalogue.getInstance().currentWealth();
        treasureRoomDoor.releaseReadAccess("Accountant");
        Thread.sleep(2000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
