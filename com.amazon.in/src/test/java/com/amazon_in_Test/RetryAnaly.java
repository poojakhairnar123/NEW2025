package com.amazon_in_Test;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class RetryAnaly {
	
		
	    int count = 0;
	    int retryLimit = 2; // how many times to retry (after first failure)

	    public boolean retry(ITestResult result) {
	        if (count < retryLimit) {
	            count++;
	            System.out.println("Retrying test: " + result.getName() + " | Attempt: " + (count + 1));
	            return true;  // tell TestNG to re-run the test
	        }
	        return false; // stop retrying
	    }
	}

