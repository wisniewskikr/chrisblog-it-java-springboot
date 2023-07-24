package com.example.app.automatedtests.constant.utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FilterClass {

    private List<FilterClassMethods> classMethods;

    public Optional<FilterClassMethods> getMethodForClass(String className){
        return classMethods.stream()
                .filter(cm -> className.contains(cm.getClassName()))
                .findFirst();

    }
    public Boolean isMethodForThisClass(String className, String methodName){
        Optional<FilterClassMethods> methodForClass = getMethodForClass(className);
        if (methodForClass.isPresent()) {
            if (methodForClass.get().getMethodsName().size() > 0) {
                return methodForClass.get().getMethodsName().stream().anyMatch(methodName::contains);
            } else {
                return true;
            }
        }
        return null;
    }

    public List<String> getClasses(){
        return classMethods
                .stream()
                .map(FilterClassMethods::getClassName)
                .collect(Collectors.toList());
    }

    public FilterClass(){
        classMethods = new ArrayList<>();
    }

    public void addMethodForClass(String className, String methodName) {
        Optional<FilterClassMethods> classMethodss = classMethods.stream()
                .filter(fcm -> fcm.getClassName().equalsIgnoreCase(className))
                .findFirst();

        if (classMethodss.isPresent()) {
            classMethodss.get().addMethod(methodName);
        } else {
            classMethods.add(new FilterClass.FilterClassMethods(className, methodName));
        }
    }

    public void addMethodForClass(String className) {
        Optional<FilterClassMethods> classMethodss = classMethods.stream()
                .filter(fcm -> fcm.getClassName().equalsIgnoreCase(className))
                .findFirst();

        if (!classMethodss.isPresent()) {
            classMethods.add(new FilterClassMethods(className));
        }
    }

    class FilterClassMethods {
        private String className;
        private List<String> methodsName;

        FilterClassMethods(String className, String methodName) {
            this.className = className;
            methodsName = new ArrayList<>();
            addMethod(methodName);
        }

        public FilterClassMethods(String className) {
            this.className = className;
            methodsName = new ArrayList<>();
        }

        void addMethod(String methodName){
            boolean contains = methodsName.contains(methodName);
            if (!contains) {
                methodsName.add(methodName);
            }
        }

        public String getClassName() {
            return className;
        }

        public List<String> getMethodsName() {
            return methodsName;
        }
    }
}