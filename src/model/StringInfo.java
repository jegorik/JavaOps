package model;

import java.util.Objects;

public class StringInfo extends Section {
    private String stringData;

    public StringInfo(String stringData) {
        Objects.requireNonNull(stringData, "stringData must not be null");
        this.stringData = stringData;
    }

    public String getData() {
        return stringData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringInfo that = (StringInfo) o;
        return stringData.equals(that.stringData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stringData);
    }

    @Override
    public String toString() {
        return "StringInfo{" +
                "data='" + stringData + '\'' +
                '}';
    }
}
