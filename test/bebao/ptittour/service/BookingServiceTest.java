package bebao.ptittour.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class BookingServiceTest extends AppEngineTestCase {

    private BookingService service = new BookingService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
