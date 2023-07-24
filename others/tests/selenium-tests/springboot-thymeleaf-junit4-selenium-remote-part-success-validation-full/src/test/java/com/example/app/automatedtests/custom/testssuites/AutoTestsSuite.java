package com.example.app.automatedtests.custom.testssuites;


import org.junit.runner.RunWith;

import com.example.app.automatedtests.constant.utils.PartSuite;
import com.example.app.automatedtests.custom.tests.InputSuccessTest;
import com.example.app.automatedtests.custom.tests.InputValidationTest;


@RunWith(PartSuite.class)
@PartSuite.SuiteClasses(
        value = {
        		InputSuccessTest.class,
        		InputValidationTest.class
        },
        filterEnabled = true)
public class AutoTestsSuite {

}
