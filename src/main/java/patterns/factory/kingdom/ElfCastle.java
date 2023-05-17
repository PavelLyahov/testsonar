package patterns.factory.kingdom;

public class ElfCastle implements Castle {

  public static final String DESCRIPTION = "This is the elven castle!";

  @Override
  public String getDescription() {
    return DESCRIPTION;
  }
}
