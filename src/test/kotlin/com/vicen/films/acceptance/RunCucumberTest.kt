package com.vicen.films.acceptance

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(plugin = ["pretty"])
class RunCucumberTest
