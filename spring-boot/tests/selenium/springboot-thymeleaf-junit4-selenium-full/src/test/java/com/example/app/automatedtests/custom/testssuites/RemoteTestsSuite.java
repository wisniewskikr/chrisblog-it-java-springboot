package com.example.app.automatedtests.custom.testssuites;


import org.junit.runner.RunWith;

import com.example.app.automatedtests.constant.parts.PartSuite;
import com.example.app.automatedtests.custom.tests.remote.InputRemoteTest;
import com.example.app.automatedtests.custom.tests.remote.OutputRemoteTest;


@RunWith(PartSuite.class)
@PartSuite.SuiteClasses(
        value = {
        		InputRemoteTest.class,
        		OutputRemoteTest.class
        },
        filterEnabled = true)
public class RemoteTestsSuite {

}
