package bebao.ptittour.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PhuongTienTest extends AppEngineTestCase {

    private PhuongTien model = new PhuongTien();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
