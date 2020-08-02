package org.mitpu.referral.core.repositories.models;

public class Coordinator extends Person {

    private Role role;

    public enum Role {

        REGULAR(0), ADMIN(1);

        public static Role getRole(byte value) {
            switch (value) {
            case 0:
                return REGULAR;
            case 1:
                return ADMIN;
            default:
                return null;
            }
        }

        public final byte value;

        private Role(int value) {
            this.value = (byte) value;
        }
    }

    public Coordinator() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
