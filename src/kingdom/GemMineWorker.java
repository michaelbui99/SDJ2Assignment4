package kingdom;

//Producer
import kingdom.gems.Gem;

import java.util.Random;

public class GemMineWorker implements Runnable
{
  private GemDeposit<Gem> gemDeposit;
  private String[] gems = {"Diamond", "GoldNugget", "Jewel", "Ruby", "WoodenCoin"};
  private String name;

  public GemMineWorker(String name,GemDeposit<Gem> gemDeposit)
  {
    this.name = name;
    this.gemDeposit = gemDeposit;
  }

  @Override public void run()
  {
    while (true)
    {
      try
      {
        Random random = new Random();
        int randInt  = random.nextInt(gems.length);
        Gem gem = GemMine.getInstance(gems[randInt]);
        gemDeposit.enqueue(gem);
        Catalogue.getInstance().gemDeposit((kingdom.gems.Gem) gem, name);
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
