package bebao.ptittour.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class DiaDiemServiceTest extends AppEngineTestCase {

    private DiaDiemService service = new DiaDiemService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
