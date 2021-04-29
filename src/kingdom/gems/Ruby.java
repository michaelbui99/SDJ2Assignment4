package kingdom.gems;

public class Ruby implements Gem
{
  public Ruby()
  {

  }

  @Override public int getValue()
  {
    return 25;
  }

  @Override public String getGemType()
  {
    return "Ruby";
  }
}
