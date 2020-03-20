import org.junit.Test;
import org.junit.Assert;


import static org.junit.Assert.*;

public class Calculator1Test {


    @Test
    public final void whenAddIsUsedThenItWorks() {
        Assert.assertEquals(0, Calculator1.add(""));
        Assert.assertEquals(3, Calculator1.add("3"));
        Assert.assertEquals(3+6, Calculator1.add("3,6"));
        Assert.assertEquals(3+6+15+18+46+33, Calculator1.add("3,6,15,18,46,33"));
        Assert.assertEquals(3+6+15, Calculator1.add("3,6\n15"));
        Assert.assertEquals(3+6+15, Calculator1.add("//;\n3;6;15"));
        Assert.assertEquals(3+1000+6, Calculator1.add("3,1000,1001,6,1234"));
    }

    @Test
    public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
        Calculator1.add("1,2");
        Assert.assertTrue(true);
    }

    @Test(expected = RuntimeException.class)
    public final void whenNonNumberIsUsedThenExceptionIsThrown() {
        Calculator1.add("1,X");
    }

    @Test
    public final void whenEmptyStringIsUsedThenReturnValueIs0() {
        Assert.assertEquals(0, Calculator1.add(""));
    }

    @Test
    public final void whenOneNumberIsUsedThenReturnValueIsThatSameNumber() {
        Assert.assertEquals(3, Calculator1.add("3"));
    }

    @Test
    public final void whenTwoNumbersAreUsedThenReturnValueIsTheirSum() {
        Assert.assertEquals(3+6, Calculator1.add("3,6"));
    }

    @Test
    public final void whenAnyNumberOfNumbersIsUsedThenReturnValuesAreTheirSums() {
        Assert.assertEquals(3+6+15+18+46+33, Calculator1.add("3,6,15,18,46,33"));
    }

    @Test
    public final void whenNewLineIsUsedBetweenNumbersThenReturnValuesAreTheirSums() {
        Assert.assertEquals(3+6+15, Calculator1.add("3,6\n15"));
    }

    @Test
    public final void whenSemicolonDelimiterIsSpecifiedThenItIsUsedToSeparateNumbers() {
        Assert.assertEquals(3+6+15, Calculator1.add("//;\n3;6;15"));
    }

    @Test(expected = RuntimeException.class)
    public final void whenNegativeNumberIsUsedThenRuntimeExceptionIsThrown() {
        Calculator1.add("3,-6,15,18,46,33");
    }
}