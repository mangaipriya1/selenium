package com.inmate.cucumber_project;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "D:\\Cucumber_Automation\\src\\test\\java\\Feature\\new.feature"
		,glue = {"step_defintion"}	
		,tags={
				"~@Dashboard",
				 "~@Grievances",
				"~@InitiateMessages",
				// "~@Messages",
			//	 "~@Photos",
			//	"~@Notice"
				
		}
		)

public class Testrunner {

}
