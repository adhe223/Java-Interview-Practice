package test;
import org.junit.Test;
import code.BracketValidator;
import static org.junit.Assert.assertEquals;

public class BracketValidatorTest {
    @Test
    public void validate_trueSimple() {
        String a = "{(hoola)}";
        BracketValidator tester = new BracketValidator();

        assertEquals(true, tester.validateV2(a));
    }

    @Test
    public void validate_trueHard() {
        String a = "{[(h)(o)]ola}";
        BracketValidator tester = new BracketValidator();

        assertEquals(true, tester.validateV2(a));
    }

    @Test
    public void validate_falseSimple() {
        String a = "{(}";
        BracketValidator tester = new BracketValidator();

        assertEquals(false, tester.validateV2(a));
    }

    @Test
    public void validate_falseHard() {
        String a = "{([)]}";
        BracketValidator tester = new BracketValidator();

        assertEquals(false, tester.validateV2(a));
    }

    @Test
    public void validate_new_trueSimple() {
        String a = "{(hoola)}";
        code.Strings.BracketValidator tester = new code.Strings.BracketValidator();

        assertEquals(true, tester.validate(a));
    }

    @Test
    public void validate_new_trueHard() {
        String a = "{[(h)(o)]ola}";
        code.Strings.BracketValidator tester = new code.Strings.BracketValidator();

        assertEquals(true, tester.validate(a));
    }

    @Test
    public void validate_new_falseSimple() {
        String a = "{(}";
        code.Strings.BracketValidator tester = new code.Strings.BracketValidator();

        assertEquals(false, tester.validate(a));
    }

    @Test
    public void validate_new_falseHard() {
        String a = "{([)]}";
        code.Strings.BracketValidator tester = new code.Strings.BracketValidator();

        assertEquals(false, tester.validate(a));
    }
}
