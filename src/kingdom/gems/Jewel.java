package kingdom.gems;

public class Jewel implements Gem
{
  public Jewel()
  {
  }

  @Override public int getValue()
  {
    return 15;
  }

  @Override public String getGemType()
  {
    return "Jewel";
  }
}
