package kingdom;

import kingdom.gems.Gem;

public class KingdomStart
{
  public static void main(String[] args)
  {
    GemDeposit<Gem> deposit = new GemDeposit(200);
    TreasureRoom treasureRoom = new TreasureRoom();
    TreasureRoomDoor treasureRoomDoor = new TreasureRoomGuardsman(treasureRoom);
    Accountant accountant = new Accountant(treasureRoomDoor);

    GemTransporter gemTransporter1 = new GemTransporter("Transporter 1" ,deposit, treasureRoomDoor);
    GemTransporter gemTransporter2 = new GemTransporter("Transporter 2" ,deposit, treasureRoomDoor);
    GemMineWorker gemMineWorker1 = new GemMineWorker("Miner 1", deposit);
    GemMineWorker gemMineWorker2 = new GemMineWorker("Miner 2" ,deposit);

    King king = new King("King", treasureRoomDoor);

    Thread t1 = new Thread(gemTransporter1, "TransporterThread1");
    Thread t2 = new Thread(gemTransporter2, "TransporterThread2");

    Thread t3 = new Thread(gemMineWorker1, "WorkerThread1");
    Thread t4 = new Thread(gemMineWorker2, "WorkerThread2");

    Thread t5 = new Thread(accountant, "AccountantThread");
    Thread t6 = new Thread(king, "KingThread");

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
    t6.start();
  }
}
