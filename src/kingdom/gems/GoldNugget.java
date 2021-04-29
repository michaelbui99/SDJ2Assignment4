package kingdom.gems;

public class GoldNugget implements Gem
{
  public GoldNugget()
  {
  }

  @Override public int getValue()
  {
    return 50;
  }

  @Override public String getGemType()
  {
    return "Gold nugget";
  }
}
