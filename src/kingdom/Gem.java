package kingdom;

public abstract class Gem
{
  private double value;
  private String gemType;
  private String color;

  public Gem(double value, String gemType, String color)
  {
    this.value = value;
    this.gemType = gemType;
    this.color = color;
  }

  public double getValue()
  {
    return value;
  }

  public String getGemType()
  {
    return gemType;
  }

  public String getColor()
  {
    return color;
  }
}
