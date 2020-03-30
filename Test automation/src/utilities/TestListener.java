package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        Reporter.createTest(parseTestName(iTestResult.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Reporter.passStep("Test Passed.");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Reporter.failStep(iTestResult.getThrowable().getMessage(),
                        parseTestName(iTestResult.getTestName()) + System.currentTimeMillis());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Reporter.skipStep("Test Skipped.");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    public static String parseTestName(String testName) {
        StringBuilder newTestName = new StringBuilder();
        String[] camelCaseWords = testName.split("(?=[A-Z])");

        for (String word : camelCaseWords) {
            newTestName.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
        }

        return (newTestName.toString());
    }
}
