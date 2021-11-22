package defaults;

import com.aventstack.extentreports.ExtentReports;

public class ExtentSingleton {
    private static ExtentReports extent;

    private ExtentSingleton() {}

    public static ExtentReports getExtent() {
        if (extent == null) {
            extent = new ExtentReports();
        }
        return extent;
    }
}
