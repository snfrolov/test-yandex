package steps;

import cucumber.api.java.ru.И;
import lombok.extern.slf4j.Slf4j;
import ru.alfabank.alfatest.cucumber.api.AkitaScenario;
import ru.alfabank.steps.DefaultSteps;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

@Slf4j
public class Steps {
    AkitaScenario akitaScenario = AkitaScenario.getInstance();
    DefaultSteps ds = new DefaultSteps();

    @И("^значение из переменной \"([^\"]*)\" (меньше|больше) на (\\d+) значения из переменной \"([^\"]*)\"$")
    public void checkingLessOrBiggerCounterFromTwoVariables(String firstVariableName, String lessOrBigger, int count, String secondVariableName) {
        int countFromFirstVariable = getCounterFromString(firstVariableName);
        int countFromSecondVariable = getCounterFromString(secondVariableName);
        switch (lessOrBigger){
            case ("меньше"):
                int finalLessCount = countFromSecondVariable - count;
                assertEquals(String.format("Значения из переменной [%s] не меньше на [%d] и не равно значению из переменной [%s]",
                        firstVariableName, count, secondVariableName),
                        finalLessCount, countFromFirstVariable);
            case ("больше"):
                int finalBiggerCount = countFromSecondVariable + count;
                assertEquals(String.format("Значения из переменной [%s] не больше на [%d] и не равно значению из переменной [%s]",
                        firstVariableName, count, secondVariableName),
                        finalBiggerCount, countFromFirstVariable);
        }
    }

    private int getCounterFromString(String variableName) {
        String valueOfVariableString = (String)akitaScenario.getVar(variableName);
        Matcher matcher = Pattern.compile("-?\\d+").matcher(valueOfVariableString);
        String stringForTransferToInt = matcherForString(matcher);
        return Integer.parseInt(stringForTransferToInt);
    }

    private String matcherForString(Matcher matcher) {
        String stringForMatching = null;
        while (matcher.find()) {
            stringForMatching = matcher.group();
        }
        if (stringForMatching == null) {
            throw new IllegalArgumentException("Класс/элемент не содержит необходимые данные");
        }
        return stringForMatching;
    }
}
