package bebao.ptittour.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TourTest extends AppEngineTestCase {

    private Tour model = new Tour();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
