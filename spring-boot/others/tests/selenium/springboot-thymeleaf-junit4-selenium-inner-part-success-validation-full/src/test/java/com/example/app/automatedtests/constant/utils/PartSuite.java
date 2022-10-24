package com.example.app.automatedtests.constant.utils;

import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Using <code>Suite</code> as a runner allows you to manually
 * build a suite containing tests from many classes. It is the JUnit 4 equivalent of the JUnit 3.8.x
 * static {@link junit.framework.Test} <code>suite()</code> method. To use it, annotate a class
 * with <code>@RunWith(Suite.class)</code> and <code>@SuiteClasses({TestClass1.class, ...})</code>.
 * When you run this class, it will run all the tests in all the suite classes.
 *
 * @since 4.0
 */
public class PartSuite extends ParentRunner<Runner> {

    private static final String SUCCESS = "Success";
    private static final String VALIDATION = "Validation";
    private static final String FULL = "full";
    private static final String PART = "part";

    /**
     * Returns an empty suite.
     */
    public static Runner emptySuite() {
        try {
            return new PartSuite((Class<?>) null, new Class<?>[0]);
        } catch (InitializationError e) {
            throw new RuntimeException("This shouldn't be possible");
        }
    }

    /**
     * The <code>SuiteClasses</code> annotation specifies the classes to be run when a class
     * annotated with <code>@RunWith(Suite.class)</code> is run.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Inherited
    public @interface SuiteClasses {
        /**
         * @return the classes to be run
         */
        Class<?>[] value();
        boolean filterEnabled() default false;
    }

    private static Class<?>[] getAnnotatedClasses(Class<?> klass) throws InitializationError {
        SuiteClasses annotation = klass.getAnnotation(SuiteClasses.class);
        if (annotation == null) {
            throw new InitializationError(String.format("class '%s' must have a SuiteClasses annotation", klass.getName()));
        }

        Class<?>[] classes = annotation.value();
        boolean filterEnabled = annotation.filterEnabled();

        classes = filterClasses(classes, filterEnabled);

        return classes;
    }

    private static Class<?>[] filterClasses(Class<?>[] classes, boolean filterEnabled) {
        if (filterEnabled) {
            String part = System.getProperty(PART);
            if (part != null && part.equalsIgnoreCase(SUCCESS)) {
                classes = Arrays.stream(classes)
                        .filter(cl ->
                                (
                                        cl.getSimpleName().contains(SUCCESS)))
                        .toArray(Class<?>[]::new);
            } else if (part != null && part.equalsIgnoreCase(VALIDATION)){

                classes = Arrays.stream(classes)
                        .filter(cl ->
                                (
                                        cl.getSimpleName().contains(VALIDATION)))
                        .toArray(Class<?>[] :: new);
            } else if (part != null && part.equalsIgnoreCase(FULL)){
                classes = Arrays.stream(classes)
                        .filter(cl ->
                                (
                                        cl.getSimpleName().contains(SUCCESS) ||
                                        cl.getSimpleName().contains(VALIDATION)))
                        .toArray(Class<?>[] :: new);
            } else if (part != null){
                String[] classNames = part.split(",");

                FilterClass filterClass = new FilterClass();
                for (String p : classNames) {
                    String[] split = p.split("\\.");
                    if (split.length == 1) {
                        filterClass.addMethodForClass(p);
                    } else if (split.length == 2) {
                        filterClass.addMethodForClass(split[0], split[1]);
                    }
                }

                CustomSpringRunner.filterClass = filterClass;

                classes = Arrays.stream(classes)
                        .filter(cl ->
                                (
                                        isValidClass(cl, filterClass)))
                        .toArray(Class<?>[] :: new);
            }
        }
        return classes;
    }

    private static boolean isValidClass(Class<?> cl, FilterClass classNames) {
        return classNames.getClasses().stream().anyMatch(c -> cl.getSimpleName().contains(c));
    }

    private final List<Runner> runners;

    /**
     * Called reflectively on classes annotated with <code>@RunWith(Suite.class)</code>
     *
     * @param klass the root class
     * @param builder builds runners for classes in the suite
     */
    public PartSuite(Class<?> klass, RunnerBuilder builder) throws InitializationError {
        this(builder, klass, getAnnotatedClasses(klass));
    }

    /**
     * Call this when there is no single root class (for example, multiple class names
     * passed on the command line to {@link org.junit.runner.JUnitCore}
     *
     * @param builder builds runners for classes in the suite
     * @param classes the classes in the suite
     */
    public PartSuite(RunnerBuilder builder, Class<?>[] classes) throws InitializationError {
        this(null, builder.runners(null, classes));
    }

    /**
     * Call this when the default builder is good enough. Left in for compatibility with JUnit 4.4.
     *
     * @param klass the root of the suite
     * @param suiteClasses the classes in the suite
     */
    protected PartSuite(Class<?> klass, Class<?>[] suiteClasses) throws InitializationError {
        this(new AllDefaultPossibilitiesBuilder(true), klass, suiteClasses);
    }

    /**
     * Called by this class and subclasses once the classes making up the suite have been determined
     *
     * @param builder builds runners for classes in the suite
     * @param klass the root of the suite
     * @param suiteClasses the classes in the suite
     */
    protected PartSuite(RunnerBuilder builder, Class<?> klass, Class<?>[] suiteClasses) throws InitializationError {
        this(klass, builder.runners(klass, suiteClasses));
    }

    /**
     * Called by this class and subclasses once the runners making up the suite have been determined
     *
     * @param klass root of the suite
     * @param runners for each class in the suite, a {@link Runner}
     */
    protected PartSuite(Class<?> klass, List<Runner> runners) throws InitializationError {
        super(klass);
        this.runners = Collections.unmodifiableList(runners);
    }

    @Override
    protected List<Runner> getChildren() {
        return runners;
    }

    @Override
    protected Description describeChild(Runner child) {
        return child.getDescription();
    }

    @Override
    protected void runChild(Runner runner, final RunNotifier notifier) {
        runner.run(notifier);
    }

}
