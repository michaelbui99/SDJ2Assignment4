package kingdom;

import kingdom.gems.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GemMine
{
  private static Map<String, Gem> allInstances = new HashMap<>();


  private GemMine(String key)
  {

  }

  public static Gem getInstance(String key)
  {
    Gem instance = allInstances.get(key);
    if (instance == null)
    {
      synchronized (allInstances)
      {
        instance = allInstances.get(key);
        if (instance == null)
        {
          switch (key)
          {
            case "Diamond":
              instance = new Diamond();
              break;
            case "GoldNugget":
              instance = new GoldNugget();
              break;
            case "Jewel":
              instance = new Jewel();
              break;
            case "Ruby":
              instance = new Ruby();
            default:
              throw new IllegalArgumentException("No such valuable exists, trash!");
          }
          allInstances.put(key, instance);
          instance = allInstances.get(key);
        }
      }
    }
   return instance;
  }
}
