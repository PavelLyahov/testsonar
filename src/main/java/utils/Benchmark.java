package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Benchmark implements ITestListener {
    private long startTime;
    private int nano = 1000_000_000;

    @Override
    public void onTestStart(ITestResult result) {
        startTime = System.nanoTime();
    }

    private void showExecutableTime() {
        Logger.getInstance().info("Executed time: " + (double) (System.nanoTime() - startTime) / nano + " seconds");
//        System.out.println("Executed time: " + (double) (System.nanoTime() - startTime) / nano + " seconds");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        showExecutableTime();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        showExecutableTime();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        showExecutableTime();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        showExecutableTime();
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Suite has started");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Suite has finished");
    }

    public static String getTestMethodName(ITestResult result) {
        List<String> list = new ArrayList<>();
        Object instance = result.getInstance();
            return (result.getParameters().length != 0) ? result.getName() + "_" +
                    String.join("_", Arrays.stream(result.getParameters()).map(o -> o.toString()).collect(Collectors.toList()))
                    : result.getName();

    }

}
