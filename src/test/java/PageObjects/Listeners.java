package PageObjects;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener
{
    public void onFinish(ITestContext arg0)
    {
        // TODO Auto-generated method stub
    }

    public void onStart(ITestContext arg0)
    {
        // TODO Auto-generated method stub
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0)
    {
        // TODO Auto-generated method stub
    }

    public void onTestFailure(ITestResult arg0)
    {
        System.out.println("ERROR");
    }

    public void onTestSkipped(ITestResult arg0)
    {
        // TODO Auto-generated method stub
    }

    public void onTestStart(ITestResult arg0)
    {
        // TODO Auto-generated method stub
    }

    public void onTestSuccess(ITestResult arg0)
    {
        // TODO Auto-generated method stub
    }
}

