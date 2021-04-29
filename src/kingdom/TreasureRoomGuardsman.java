package kingdom;

import kingdom.gems.Gem;

import java.util.List;
//Proxy


public class TreasureRoomGuardsman implements TreasureRoomDoor
{
  private int waitingWriters =0 ;
  private boolean activeWriter = false;
  private int activeReaders = 0;

  private TreasureRoom treasureRoom;

  public TreasureRoomGuardsman(TreasureRoom treasureRoom)
  {
    this.treasureRoom = treasureRoom;
  }

  @Override public synchronized void acquireReadAccess(String actorName)
      throws InterruptedException
  {
    // note in the catalogue a person entered
    while (waitingWriters > 0 || activeWriter)
    {
      wait();
    }
    treasureRoom.acquireReadAccess(actorName);
    activeReaders++;
    notifyAll();
  }

  @Override public synchronized void acquireWriteAccess(String actorName)
      throws InterruptedException
  {
    waitingWriters++;
    while(activeWriter || activeReaders > 0)
    {
      wait();
    }
    treasureRoom.acquireWriteAccess(actorName);
    waitingWriters--;
    activeWriter = true;
    notifyAll();
  }

  @Override public synchronized void releaseReadAccess(String actorName)
  {
    activeReaders--;
    treasureRoom.releaseReadAccess(actorName);
    if (activeReaders == 0)
    {
      notifyAll();
    }
  }

  @Override public synchronized void releaseWriteAccess(String actorName)
  {
    activeWriter = false;
    treasureRoom.releaseWriteAccess(actorName);
    notifyAll();
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
