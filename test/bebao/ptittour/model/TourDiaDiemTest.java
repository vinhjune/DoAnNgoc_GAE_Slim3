package bebao.ptittour.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TourDiaDiemTest extends AppEngineTestCase {

    private TourDiaDiem model = new TourDiaDiem();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
