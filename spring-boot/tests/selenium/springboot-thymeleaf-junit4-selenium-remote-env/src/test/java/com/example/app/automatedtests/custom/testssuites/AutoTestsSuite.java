package com.example.app.automatedtests.custom.testssuites;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.example.app.automatedtests.custom.tests.InputTest;
import com.example.app.automatedtests.custom.tests.OutputTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({InputTest.class, OutputTest.class})
public class AutoTestsSuite {}
