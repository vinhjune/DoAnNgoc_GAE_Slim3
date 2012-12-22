package bebao.ptittour.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PhuongTienServiceTest extends AppEngineTestCase {

    private PhuongTienService service = new PhuongTienService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
