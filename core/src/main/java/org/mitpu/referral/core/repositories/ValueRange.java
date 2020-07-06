package org.mitpu.referral.core.repositories;

public class ValueRange {

    public int maxValue;

    public int minValue;

    public ValueRange(int minValue, int maxValue) {
        this.maxValue = maxValue;
        this.minValue = minValue;
    }
}
