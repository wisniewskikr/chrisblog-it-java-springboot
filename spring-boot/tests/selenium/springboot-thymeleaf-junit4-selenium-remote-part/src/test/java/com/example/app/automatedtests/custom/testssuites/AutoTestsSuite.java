package com.example.app.automatedtests.custom.testssuites;


import org.junit.runner.RunWith;

import com.example.app.automatedtests.constant.utils.PartSuite;
import com.example.app.automatedtests.constant.utils.PartSuite.SuiteClasses;
import com.example.app.automatedtests.custom.tests.InputTest;
import com.example.app.automatedtests.custom.tests.OutputTest;


@RunWith(PartSuite.class)
@PartSuite.SuiteClasses(
        value = {
        		InputTest.class,
        		OutputTest.class
        },
        filterEnabled = true)
public class AutoTestsSuite {

}
