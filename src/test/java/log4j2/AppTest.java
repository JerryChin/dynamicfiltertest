package log4j2;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
   private static final Logger logger = LogManager.getLogger(AppTest.class);

   @Test
   public void testDynamicFilterDefaultThresholdShouldFilterAnythingLowerThanError() {
       // we've defined a lovely context-wide DynamicThresholdFilter in log4j2.xml, and it's default threshold
       // is set to ERROR, as stated in the document (https://logging.apache.org/log4j/2.x/manual/filters.html),
       // "if there is no matching key in the key/value pairs
       // then this level (specified in default threshold) will be compared against the event's level."

       // so the line which immediately follows should be rejected.
       Assert.assertFalse(logger.isEnabled(Level.INFO));

       // the line below should be passed.
       Assert.assertTrue(logger.isEnabled(Level.ERROR));
   }
}
