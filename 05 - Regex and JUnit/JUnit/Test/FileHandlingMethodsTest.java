import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

    public class FileHandlingMethodsTest {

        private final String testFile = "testFile.txt";
        private final String content = "Hello, this is a test!";

        @Before
        public void setup() throws IOException {
            FileHandlingMethods.writeToFile(testFile, content);
        }

        @After
        public void cleanup() {
            File file = new File(testFile);
            if (file.exists()) {
                file.delete();
            }
        }

        @Test
        public void testWriteAndReadContent() throws IOException {
            String readContent = FileHandlingMethods.readFromFile(testFile);
            assertEquals(content, readContent);
        }

        @Test
        public void testFileExistsAfterWriting() {
            File file = new File(testFile);
            assertTrue(file.exists());
        }

        @Test(expected = IOException.class)
        public void testIOExceptionWhenFileDoesNotExist() throws IOException {
            FileHandlingMethods.readFromFile("nonExistentFile.txt");
        }
    }
