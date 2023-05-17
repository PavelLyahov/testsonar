package patterns.factory.kingdom;

public interface KingdomFactory {

  Castle createCastle();

  King createKing();

  Army createArmy();

}
