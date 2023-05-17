/*
 * This project is licensed under the MIT license. Module model-view-viewmodel is using ZK framework licensed under LGPL (see lgpl-3.0.txt).
 *
 * The MIT License
 * Copyright © 2014-2022 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package patterns.factory.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import patterns.factory.kingdom.App;
import patterns.factory.kingdom.ElfArmy;
import patterns.factory.kingdom.ElfCastle;
import patterns.factory.kingdom.ElfKing;
import patterns.factory.kingdom.Kingdom;
import patterns.factory.kingdom.OrcArmy;
import patterns.factory.kingdom.OrcCastle;
import patterns.factory.kingdom.OrcKing;


class AbstractFactoryTest {

    private final App app = new App();

    @Test
    void verifyKingCreation() {
        app.createKingdom(Kingdom.FactoryMaker.KingdomType.ELF);
        final var kingdom = app.getKingdom();

        final var elfKing = kingdom.getKing();
        Assert.assertTrue(elfKing instanceof ElfKing);
        Assert.assertEquals(ElfKing.DESCRIPTION, elfKing.getDescription());

        app.createKingdom(Kingdom.FactoryMaker.KingdomType.ORC);
        final var orcKing = kingdom.getKing();
        Assert.assertTrue(orcKing instanceof OrcKing);
        Assert.assertEquals(OrcKing.DESCRIPTION, orcKing.getDescription());
    }

    @Test
    void verifyCastleCreation() {
        app.createKingdom(Kingdom.FactoryMaker.KingdomType.ELF);
        final var kingdom = app.getKingdom();

        final var elfCastle = kingdom.getCastle();
        Assert.assertTrue(elfCastle instanceof ElfCastle);
        Assert.assertEquals(ElfCastle.DESCRIPTION, elfCastle.getDescription());

        app.createKingdom(Kingdom.FactoryMaker.KingdomType.ORC);
        final var orcCastle = kingdom.getCastle();
        Assert.assertTrue(orcCastle instanceof OrcCastle);
        Assert.assertEquals(OrcCastle.DESCRIPTION, orcCastle.getDescription());
    }

    @Test
    void verifyArmyCreation() {
        app.createKingdom(Kingdom.FactoryMaker.KingdomType.ELF);
        final var kingdom = app.getKingdom();

        final var elfArmy = kingdom.getArmy();
        Assert.assertTrue(elfArmy instanceof ElfArmy);
        Assert.assertEquals(ElfArmy.DESCRIPTION, elfArmy.getDescription());

        app.createKingdom(Kingdom.FactoryMaker.KingdomType.ORC);
        final var orcArmy = kingdom.getArmy();
        Assert.assertTrue(orcArmy instanceof OrcArmy);
        Assert.assertEquals(OrcArmy.DESCRIPTION, orcArmy.getDescription());
    }

    @Test
    void verifyElfKingdomCreation() {
        app.createKingdom(Kingdom.FactoryMaker.KingdomType.ELF);
        final var kingdom = app.getKingdom();

        final var king = kingdom.getKing();
        final var castle = kingdom.getCastle();
        final var army = kingdom.getArmy();
        Assert.assertTrue(king instanceof ElfKing);
        Assert.assertEquals(ElfKing.DESCRIPTION, king.getDescription());
        Assert.assertTrue(castle instanceof ElfCastle);
        Assert.assertEquals(ElfCastle.DESCRIPTION, castle.getDescription());
        Assert.assertTrue(army instanceof ElfArmy);
        Assert.assertEquals(ElfArmy.DESCRIPTION, army.getDescription());
    }

    @Test
    void verifyOrcKingdomCreation() {
        app.createKingdom(Kingdom.FactoryMaker.KingdomType.ORC);
        final var kingdom = app.getKingdom();

        final var king = kingdom.getKing();
        final var castle = kingdom.getCastle();
        final var army = kingdom.getArmy();
        Assert.assertTrue(king instanceof OrcKing);
        Assert.assertEquals(OrcKing.DESCRIPTION, king.getDescription());
        Assert.assertTrue(castle instanceof OrcCastle);
        Assert.assertEquals(OrcCastle.DESCRIPTION, castle.getDescription());
        Assert.assertTrue(army instanceof OrcArmy);
        Assert.assertEquals(OrcArmy.DESCRIPTION, army.getDescription());
    }
}
