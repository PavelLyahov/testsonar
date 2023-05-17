package patterns.factory.kingdom;

public class App implements Runnable {

    private final Kingdom kingdom = new Kingdom();

    public Kingdom getKingdom() {
        return kingdom;
    }

    public static void main(String[] args) {
        var app = new App();
        app.run();
    }

    @Override
    public void run() {
        createKingdom(Kingdom.FactoryMaker.KingdomType.ELF);
        createKingdom(Kingdom.FactoryMaker.KingdomType.ORC);
    }

    public void createKingdom(final Kingdom.FactoryMaker.KingdomType kingdomType) {
        final KingdomFactory kingdomFactory = Kingdom.FactoryMaker.makeFactory(kingdomType);
        kingdom.setKing(kingdomFactory.createKing());
        kingdom.setCastle(kingdomFactory.createCastle());
        kingdom.setArmy(kingdomFactory.createArmy());
    }
}