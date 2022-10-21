package com.example.app.automatedtests.constant.parts;

import org.junit.Ignore;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class PartSpringRunner extends SpringJUnit4ClassRunner {
    public static PartFilterClass filterClass = null;
    /**
     * Construct a new {@code SpringRunner} and initialize a
     * {@link TestContextManager TestContextManager}
     * to provide Spring testing functionality to standard JUnit 4 tests.
     *
     * @param clazz the test class to be run
     * @see #createTestContextManager(Class)
     */
    public PartSpringRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
    }

    @Override
    protected void runChild(FrameworkMethod method, RunNotifier notifier) {
    	
        Description description = describeChild(method);
        boolean runTest = true;

        if (filterClass != null){
            Boolean methodForThisClass = filterClass.isMethodForThisClass(description.getClassName(), method.getName());

            if (methodForThisClass != null) {
                runTest = methodForThisClass;
            }
        }
        if (method.getAnnotation(Ignore.class) == null && runTest) {
            runLeaf(methodBlock(method), description, notifier);
        } else {
            notifier.fireTestIgnored(description);
        }
    }
}
