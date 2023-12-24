import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CommandsTest {

    @Test
    public void testLoadCommands() {
        // Assuming you have a test file named "test.txt" in your resources folder
        Commands commands = new Commands("test.txt");

        // Check if the commands list is not empty
        assertFalse(commands.isEmpty());

        // Check if the first command in the list is as expected
        // Replace "expectedCommand" with the actual command
        String expectedCommand = "Your expected command here";
        assertEquals(expectedCommand, commands.get(0));
    }

    @Test
    public void testFileNotFound() {
        // This file does not exist
        Exception exception = assertThrows(FileNotFoundException.class, () -> {
            new Commands("nonExistentFile.txt");
        });

        String expectedMessage = "File not found!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
