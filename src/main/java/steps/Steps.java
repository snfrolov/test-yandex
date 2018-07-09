package steps;

import cucumber.api.java.mk_cyrl.И;
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

}
