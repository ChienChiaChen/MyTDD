
import org.junit.*;
import static org.junit.Assert.*;

public class URLparserTest {

    @Test
    public void test_basic_http_protocol() {
        URLparser p = new URLparser("http://www.ncu.edu.tw");
        assertTrue(p.getProtocol().equals("http"));
    }

    @Test
    public void test_basic_ftp_protocol() {
        URLparser p = new URLparser("ftp://www.ncu.edu.tw");
        assertTrue(p.getProtocol().equals("ftp"));
    }
    @Test
    public void test_basic_generic_protocol() {
        URLparser p = new URLparser("xyz://www.ncu.edu.tw");
        assertTrue(p.getProtocol().equals("xyz"));
    }

    @Test
    public void test_simple_site() {
        URLparser p = new URLparser("xyz://www.ncu.edu.tw");
        assertTrue(p.getSite().equals("www.ncu.edu.tw"));
    }

    @Test
    public void test_simple_site_with_pathname() {
        URLparser p = new URLparser("xyz://www.ncu.edu.tw/index.xml");
        assertTrue(p.getSite().equals("www.ncu.edu.tw"));
    }

    @Test
    public void test_simple_site_with_slash() {
        URLparser p = new URLparser("xyz://www.ncu.edu.tw/");
        assertTrue(p.getSite().equals("www.ncu.edu.tw"));
    }
    @Test
    public void test_simple_pathname() {
        URLparser p = new URLparser("xyz://www.ncu.edu.tw/information_management");
        assertTrue(p.getPathname().equals("information_management"));
    }
    @Test
    public void test_complex_pathname() {
        URLparser p = new URLparser("xyz://www.ncu.edu.tw/information_management/index.html");
        assertArrayEquals("information_management/index.html".getBytes(),p.getPathname().getBytes());
    }

    @Test
    public void test_simple_empty_pathname() {
        URLparser p = new URLparser("xyz://www.ncu.edu.tw");
        assertTrue(p.getPathname().equals(""));
    }
    @Test
    public void test_simple_single_slash_pathname() {
        URLparser p = new URLparser("xyz://www.ncu.edu.tw/");
        assertTrue(p.getPathname().equals(""));
    }
}