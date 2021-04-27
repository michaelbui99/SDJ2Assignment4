package kingdom;

import kingdom.gems.Gem;

import java.util.List;
//Proxy


public class TreasureRoomGuardsman implements TreasureRoomDoor
{

  private TreasureRoom treasureRoom;

  public TreasureRoomGuardsman(TreasureRoom treasureRoom)
  {
    this.treasureRoom = treasureRoom;
  }

  @Override public void acquireReadAccess(String actorName)
      throws InterruptedException
  {
    if (actorName.equals("Accountant"))
    {
      treasureRoom.acquireReadAccess(actorName);
    }
  }

  @Override public void acquireWriteAccess(String actorName)
      throws InterruptedException
  {
    if (actorName.equals("King") || actorName.equals("GemTransporter"))
    {
      treasureRoom.acquireWriteAccess(actorName);
    }
  }

  @Override public  void releaseReadAccess(String actorName)
  {
      releaseReadAccess(actorName);
  }

  @Override public void releaseWriteAccess(String actorName)
  {
      releaseWriteAccess(actorName);
  }

  @Override public Gem retrieveValuable()
  {
    return treasureRoom.retrieveValuable();
  }

  @Override public void addValuable(Gem v)
  {
    treasureRoom.addValuable(v);
  }

  @Override public List<Gem> lookAtAllGems()
  {
    return treasureRoom.lookAtAllGems();
  }
}
