package kingdom.gems;

public class Jewel extends Gem
{
  public Jewel()
  {
  }

  @Override public double getValue()
  {
    return 25;
  }

  @Override public String getGemType()
  {
    return "Jewel";
  }
}
