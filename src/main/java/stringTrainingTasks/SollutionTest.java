package stringTrainingTasks;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SollutionTest {
    @Test
    public void tests() {
        Assert.assertEquals(Solution.camelCase("camelCasing"), "camel Casing");
        Assert.assertEquals(Solution.camelCase("camelCasingTest"), "camel Casing Test");
        Assert.assertEquals(Solution.camelCase("camelcasingTTTest"), "camelcasing T T Test");
    }

    @Test
    public void testSomeUnderscoreLowerStart() {
        String input = "the_Stealth_Warrior";
        System.out.println("input: "+input);
        Assert.assertEquals(Solution.toCamelCase(input), "theStealthWarrior");
    }

    @Test
    void testAllIdentical() {
        Assert.assertEquals(Solution.countBetter(new Integer[]{65, 101, 87, 52, 85, 80, 31, 103, 72, 17, 106, 5, 7, 41, 97, 49, 91, 70, 44, 67, 111, 76, 73, 47, 25, 93, 82, 50, 59, 55, 109, 90, 28, 19, 77, 12, 104, 100, 21, 66, 102, 56, 96, 43, 10, 39, 113, 110, 62, 75, 14, 27, 58, 36, 16, 45, 4, 23, 33}), 576460752303423487L);
    }

    @Test
    public void testCleanString() {
        Assert.assertEquals( BackspaceInString.cleanString("abc#d##c"), "ac");
        Assert.assertEquals(BackspaceInString.cleanString("abc####d##c#"), "");
    }
}