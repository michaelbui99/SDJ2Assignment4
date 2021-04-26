package kingdom.gems;

public class GoldNugget extends Gem
{
  public GoldNugget()
  {
  }

  @Override public double getValue()
  {
    return 50;
  }

  @Override public String getGemType()
  {
    return "Gold nugget";
  }
}
