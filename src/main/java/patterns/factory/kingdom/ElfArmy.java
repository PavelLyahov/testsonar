package patterns.factory.kingdom;

public class ElfArmy implements Army {

  public static final String DESCRIPTION = "This is the elven army!";

  @Override
  public String getDescription() {
    return DESCRIPTION;
  }
}
