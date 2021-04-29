package kingdom;

import kingdom.gems.Gem;

import java.util.ArrayList;
import java.util.List;

public class TreasureRoom implements TreasureRoomDoor {
    private static List<Gem> gems;
    private int waitingWriters =0 ;
    private boolean activeWriter = false;
    private int activeReaders = 0;

    public TreasureRoom() {
        gems = new ArrayList<>();
    }

    public static double getWealth()
    {
        double sum = 0;
        for (Gem gem : gems )
        {
            sum += gem.getValue();
        }
        return sum;
    }

    // access methods

    public synchronized void acquireReadAccess(String actorName)
        throws InterruptedException
    {
        // note in the catalogue a person entered
        Catalogue.getInstance().inTreasureRoom(actorName);
    }

    public synchronized void acquireWriteAccess(String actorName)
        throws InterruptedException
    {
        // note in the catalogue a person entered

        Catalogue.getInstance().inTreasureRoom(actorName);
    }

    public synchronized void releaseReadAccess(String actorName)
    {
       //note in the catalogue a person left
        activeReaders--;
        Catalogue.getInstance().outTreasureRoom(actorName);
        if (activeReaders == 0)
        {
            notifyAll();
        }
    }

    public synchronized void releaseWriteAccess(String actorName)
    {
        // note in the catalogue a person left

        Catalogue.getInstance().outTreasureRoom(actorName);
    }

    // interact methods

    public Gem retrieveValuable()
    {
        Gem v = null;
        if (gems.size() > 0)
        {
            v = gems.remove(0);
        }
        return v;
    }

    public void addValuable(Gem v)
    {
        gems.add(v);
    }

    @Override
    public List<Gem> lookAtAllGems()
    {
        return new ArrayList<Gem>(gems);
    }
}
