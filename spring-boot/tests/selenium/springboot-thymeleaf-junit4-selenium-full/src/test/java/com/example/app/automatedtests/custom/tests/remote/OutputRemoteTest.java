package com.example.app.automatedtests.custom.tests.remote;

import org.junit.runner.RunWith;
import com.example.app.automatedtests.constant.parts.PartSpringRunner;
import com.example.app.automatedtests.custom.tests.common.OutputTest;

@RunWith(PartSpringRunner.class)
public class OutputRemoteTest extends OutputTest {
	
	protected static int port = 8080;

}
