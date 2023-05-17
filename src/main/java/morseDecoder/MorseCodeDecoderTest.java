package morseDecoder;

import org.testng.Assert;
import org.testng.annotations.Test;


public class MorseCodeDecoderTest {
    @Test
    public void testExampleFromDescription() {
        Assert.assertEquals(MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. ."), "HEY JUDE");
    }
}
