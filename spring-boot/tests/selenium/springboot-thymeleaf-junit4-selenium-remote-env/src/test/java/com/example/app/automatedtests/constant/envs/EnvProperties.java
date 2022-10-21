package com.example.app.automatedtests.constant.envs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvProperties {

    private static final String AUTOMATED_TESTS_DEV_PROPERTIES = "automated-tests-dev.properties";
    private static final String AUTOMATED_TESTS_PROD_PROPERTIES = "automated-tests-prod.properties";

    private static InputStream resourceAsStream = null;

    private static Properties properties = new Properties();

    private static String property;

    public static final String ENV_CONTEXT = "env.context";

    static {
        try {
            property = System.getProperty(ENV_CONTEXT);
            if (property == null){
                property = "default";
            }

            setPropertiesEnvironment(property);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getApplicationPropertyName(){
        return String.format("application-%s.properties", property);
    }

    public static String getProperty(String propertyName){
        String property = System.getProperty(propertyName);
        if (property != null){
            return property;
        }

        return properties.getProperty(propertyName);
    }

    public static void setPropertiesEnvironment(String env) throws IOException {
        String resource;
        switch (env) {
            case "dev":
                resource = AUTOMATED_TESTS_DEV_PROPERTIES;
                break;
            case "prod":
                resource = AUTOMATED_TESTS_PROD_PROPERTIES;
                break;
            default:
                resource = AUTOMATED_TESTS_DEV_PROPERTIES;
        }
        resourceAsStream = EnvProperties.class.getClassLoader().getResourceAsStream(resource);
        reloadProperties();
    }

    private static void reloadProperties() throws IOException {
        properties = new Properties();
        properties.load(resourceAsStream);
    }

}
