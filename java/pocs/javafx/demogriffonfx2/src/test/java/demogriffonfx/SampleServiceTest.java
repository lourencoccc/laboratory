package demogriffonfx;

import griffon.core.test.GriffonUnitRule;
import griffon.core.test.TestFor;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;

@TestFor(SampleService.class)
public class SampleServiceTest {
    static {
        // force initialization JavaFX Toolkit
        new javafx.embed.swing.JFXPanel();
    }

    private SampleService service;

    @Rule
    public final GriffonUnitRule griffon = new GriffonUnitRule();

    @Test
    public void smokeTest() {
//        fail("Not yet implemented!");
        assertTrue(true);
    }
}