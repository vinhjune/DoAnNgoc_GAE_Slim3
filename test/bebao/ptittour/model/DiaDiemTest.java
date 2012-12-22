package bebao.ptittour.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class DiaDiemTest extends AppEngineTestCase {

    private DiaDiem model = new DiaDiem();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
