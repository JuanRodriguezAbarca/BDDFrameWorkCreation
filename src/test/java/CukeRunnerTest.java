import com.sun.javafx.runtime.SystemProperties;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.Before;
import org.junit.runner.RunWith;

import static org.junit.runners.Parameterized.*;

/**
 * Created by Juan_Rodriguez on 6/30/2015.
 */

@RunWith(Cucumber.class)
@CucumberOptions(

        monochrome = false,
        format = {"pretty", "html:target/cucumber-html-report","json:target/cucumber.json"}, snippets = SnippetType.CAMELCASE,
        features="src/test/resources",
        tags = {"@RESTtestHTTPC1"
        }


)


public class CukeRunnerTest {

    @Parameters(name = "driver")
    public void init(String driver) throws Exception{

    }

}
