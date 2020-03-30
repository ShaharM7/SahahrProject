package utilities;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener implements ISuiteListener {
    @Override
    public void onStart(ISuite iSuite) {
        Reporter.initialize();
    }

    @Override
    public void onFinish(ISuite iSuite) {
        Reporter.generateReport();
    }
}
