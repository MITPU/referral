package org.mitpu.referral.core.repositories.models;

public enum WorkAuthorization {
    CPT(0), OPT(1), H1B(2), GC(3), CITIZEN(4);

    public static WorkAuthorization getWorkAuthorization(byte value) {
        switch (value) {
            case 0:
                return CPT;
            case 1:
                return OPT;
            case 2:
                return H1B;
            case 3:
                return GC;
            case 4:
                return CITIZEN;
            default:
                return null;
        }
    }

    public final byte value;

    private WorkAuthorization(int value) {
        this.value = (byte) value;
    }
}