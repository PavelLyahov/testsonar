package morseDecoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class MorseCodeDecoder {
    public static final String WORD_DELIMITER = "   ";
    public static final String CHAR_DELIMITER = " ";

    public static String decode(String morseCode) {
        return Arrays.stream(morseCode.trim().split(WORD_DELIMITER))
                .map(MorseCodeDecoder::decodeWord)
                .collect(Collectors.joining(" "));
    }

    private static String decodeWord(String morseWord) {
        return Arrays.stream(morseWord.trim().split(CHAR_DELIMITER))
                .map(MorseCode::get)
                .collect(Collectors.joining());
    }

    enum MorseCode {
        A("a", ".-"),
        B("b", "-..."),
        C("c", "-.-."),
        D("d", "-.."),
        E("e", "."),
        F("f", "..-."),
        G("g", "--."),
        H("h", "...."),
        I("i", ".."),
        J("j", ".---"),
        K("k", "-.-"),
        L("l", ".-.."),
        M("m", "--"),
        N("n", "-."),
        O("o", "---"),
        P("p", ".--."),
        Q("q", "--.-"),
        R("r", ".-."),
        S("s", "..."),
        T("t", "-"),
        U("u", "..-"),
        V("v", "...-"),
        W("w", ".--"),
        X("x", "-..-"),
        Y("y", "-.--"),
        Z("z", "--.."),
        NUMBER_1("1", ".----"),
        NUMBER_2("2", "..---"),
        NUMBER_3("3", "...--"),
        NUMBER_4("4", "....-"),
        NUMBER_5("5", "....."),
        NUMBER_6("6", "-...."),
        NUMBER_7("7", "--..."),
        NUMBER_8("8", "---.."),
        NUMBER_9("9", "----."),
        NUMBER_0("0", "-----"),
        SIGN_DOT(".", ".-.-.-"),
        SIGN_COMMA(",", "--..--"),
        SIGN_QUESTION("?", "..--..");

        private String sign;
        private String script;
        private static HashMap<String, String> code = new HashMap<>();

        MorseCode(String sign, String script) {
            this.sign = sign;
            this.script = script;
        }

        static {
            code.put(MorseCode.A.script, MorseCode.A.sign);
            code.put(MorseCode.B.script, MorseCode.B.sign);
            code.put(MorseCode.C.script, MorseCode.C.sign);
            code.put(MorseCode.D.script, MorseCode.D.sign);
            code.put(MorseCode.E.script, MorseCode.E.sign);
            code.put(MorseCode.F.script, MorseCode.F.sign);
            code.put(MorseCode.G.script, MorseCode.G.sign);
            code.put(MorseCode.H.script, MorseCode.H.sign);
            code.put(MorseCode.I.script, MorseCode.I.sign);
            code.put(MorseCode.J.script, MorseCode.J.sign);
            code.put(MorseCode.K.script, MorseCode.K.sign);
            code.put(MorseCode.L.script, MorseCode.L.sign);
            code.put(MorseCode.M.script, MorseCode.M.sign);
            code.put(MorseCode.N.script, MorseCode.N.sign);
            code.put(MorseCode.O.script, MorseCode.O.sign);
            code.put(MorseCode.P.script, MorseCode.P.sign);
            code.put(MorseCode.Q.script, MorseCode.Q.sign);
            code.put(MorseCode.R.script, MorseCode.R.sign);
            code.put(MorseCode.S.script, MorseCode.S.sign);
            code.put(MorseCode.T.script, MorseCode.T.sign);
            code.put(MorseCode.U.script, MorseCode.U.sign);
            code.put(MorseCode.V.script, MorseCode.V.sign);
            code.put(MorseCode.W.script, MorseCode.W.sign);
            code.put(MorseCode.X.script, MorseCode.X.sign);
            code.put(MorseCode.Y.script, MorseCode.Y.sign);
            code.put(MorseCode.Z.script, MorseCode.Z.sign);
        }

        public static String get(String script) {
            return code.get(script);
        }

    }
}
