package utils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import base.DriverManager;
import java.io.File;
import java.nio.file.Files;

public class ScreenshotUtils {
    public static String capture(String testName) {
        try {
            File src = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            //File dest = new File("screenshots/" + testName + ".png");
            
            String fileName = testName + "_" + System.currentTimeMillis() + ".png";
            File dest = new File("screenshots/" + fileName);
            
         // Create folder if not exists
            dest.getParentFile().mkdirs();
            Files.copy(src.toPath(), dest.toPath());
            
            System.out.println(dest.getAbsolutePath());
            return dest.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
		
    }
}