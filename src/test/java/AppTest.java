import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;


public class AppTest {

    @Test
    public void shouldBeNumToFizzReplaced() {
        String expectedValue = "Fizz";
        String actual =  App.numToFizzBuzzReplace(6);
        Assert.assertEquals(expectedValue, actual);
    }

    @Test
    public void shouldBeNumToBuzzReplaced() {
        String expectedValue = "Buzz";
        String actual =  App.numToFizzBuzzReplace(10);
        Assert.assertEquals(expectedValue, actual);
    }

    @Test
    public void shouldBeNumToFizzBuzzReplaced() {
        String expectedValue = "FizzBuzz";
        String actual =  App.numToFizzBuzzReplace(15);
        Assert.assertEquals(expectedValue, actual);
    }



    @Test
    public void shouldBeCheckFileException() {
        File file = App.fileCreation("src/main/resources/inputTest.txt");
        Assert.assertThrows(RuntimeException.class, () -> App.checkFile(file));
    }

    @Test
    public void shouldBeCheckReaderCreation() {
        File file = App.fileCreation("src/main/resources/input1.txt");
        Assert.assertThrows(FileNotFoundException.class, () ->App.fileReaderCreation(file));
    }


}
