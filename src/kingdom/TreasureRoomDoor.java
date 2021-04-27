package kingdom;

import kingdom.gems.Gem;

import java.util.List;

public interface TreasureRoomDoor {

    void acquireReadAccess(String actorName) throws InterruptedException;

    void acquireWriteAccess(String actorName) throws InterruptedException;

    void releaseReadAccess(String actorName);

    void releaseWriteAccess(String actorName);

    Gem retrieveValuable();

    void addValuable(Gem v);

    List<Gem> lookAtAllGems();

}
