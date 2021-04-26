package kingdom.gems;

public class Diamond extends Gem
{
  public Diamond()
  {
  }

  @Override public double getValue()
  {
    return 10;
  }

  @Override public String getGemType()
  {
    return "Diamond";
  }
}
