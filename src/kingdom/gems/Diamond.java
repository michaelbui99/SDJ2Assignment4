package kingdom.gems;

public class Diamond implements Gem
{
  public Diamond()
  {
  }

  @Override public int getValue()
  {
    return 30;
  }

  @Override public String getGemType()
  {
    return "Diamond";
  }
}
