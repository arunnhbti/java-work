package com.arun.test;

public enum TestEnum implements enumI {
    SAMPLE("value");

    private String value;

    private TestEnum(String value) {
        this.setValue(value);
    }

    @Override
    public String myEnumMethod(String parSample) {
        return null;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String parValue) {
        value = parValue;
    }

}
