package org.example;

import java.util.Objects;

/**
 * Репрезентация подстроки
 */
public final class Feature implements Comparable<Feature> {
    private final String value;
    private final Integer representationValue;
    private final boolean isInt;

    public String getValue() {
        return value;
    }

    public Integer getRepresentationValue() {
        return representationValue;
    }

    public boolean isInt() {
        return isInt;
    }

    private Feature() {
        this(null, false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Feature feature = (Feature) o;

        if (isInt != feature.isInt) return false;
        if (!value.equals(feature.value)) return false;
        return Objects.equals(representationValue, feature.representationValue);
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + (representationValue != null ? representationValue.hashCode() : 0);
        result = 31 * result + (isInt ? 1 : 0);
        return result;
    }

    public Feature(String value, boolean isInt) {
        if (isInt) {
            this.value = value;
            this.isInt = true;
            this.representationValue = Integer.valueOf(value);
        } else {
            this.value = value;
            this.isInt = false;
            representationValue = null;
        }
    }


    @Override
    public String toString() {
        return "[ value=%s ]".formatted(value);
    }

    @Override
    public int compareTo(Feature second) {
        if (this.isInt() && second.isInt()) {
            return this.getRepresentationValue().compareTo(second.getRepresentationValue());
        } else return this.getValue().compareTo(second.getValue());
    }
}
