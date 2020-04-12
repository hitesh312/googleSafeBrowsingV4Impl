import com.safebrosing.GoogleSafeBrowsing;
import org.junit.Assert;
import org.junit.Test;

public class GoogleSafeBrowsingTest {

    GoogleSafeBrowsing safeBrowsing = new GoogleSafeBrowsing();

    @Test
    public void lookupTest(){
        Assert.assertFalse(safeBrowsing.isSafe("http://malware.testing.google.test/testing/malware/"));
        Assert.assertTrue(safeBrowsing.isSafe("http://www.google.com/"));
    }

}
