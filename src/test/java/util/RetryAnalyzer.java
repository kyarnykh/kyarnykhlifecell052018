package util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 *
 */
public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private int retryMaxCount = 6;

    // решаем, требует ли тест перезапуска
    @Override
    public boolean retry(ITestResult testResult) {
        boolean result = false;
        if (testResult.getAttributeNames().contains("retry") == false) {
            System.out.println("retry count = " + retryCount + "\n" +"max retry count = " + retryMaxCount);
            if(retryCount < retryMaxCount){
                System.out.println("Retrying " + testResult.getName() + " with status "
                        + testResult.getStatus() + " for the try " + (retryCount+1) + " of "
                        + retryMaxCount + " max times.");
            }
        }
        return result;
    }
}