package kingdom.gems;

public class WoodenCoin extends Gem
{
  public WoodenCoin()
  {
  }

  @Override public int getValue()
  {
    return 1;
  }

  @Override public String getGemType()
  {
    return "Not a gem... it is a piece of wood!!";
  }
}
