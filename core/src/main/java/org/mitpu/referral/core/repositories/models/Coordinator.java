package org.mitpu.referral.core.repositories.models;

public class Coordinator extends Person {

    private Role role;

    public enum Role {

        REGULAR(0), ADMIN(1);

        public final byte role;

        private Role(int role) {
            this.role = (byte) role;
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
