package com.flink.testfactory;

import org.testng.annotations.DataProvider;

import com.flink.driverInit.DriverInitialization;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features", glue = { "classpath:com.flink.stepDefinitions" }, plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, tags = "@test")
public class TestRunner extends DriverInitialization {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
