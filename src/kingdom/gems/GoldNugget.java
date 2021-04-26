package kingdom.gems;

public class GoldNugget extends Gem
{
  public GoldNugget(double value, String gemType, String color)
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
