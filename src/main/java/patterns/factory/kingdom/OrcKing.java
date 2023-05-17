package patterns.factory.kingdom;

public class OrcKing implements King {

  public static final String DESCRIPTION = "This is the orc king!";

  @Override
  public String getDescription() {
    return DESCRIPTION;
  }
}
