package com.example.model;

/**
 * Created by dkazakov on 12.05.2014.
 */
public class FakeClass {

    private String field;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "" + FakeClass.class.getSimpleName() +
                "[" +
                "field=" + field +
                "]";
    }

}
