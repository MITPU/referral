package org.mitpu.referral.core.repositories.models;

public class Referrer extends Person {

    private Integer companyId;

    private CommMethodType commMethodType;

    private String commMethod;

    private Integer commStartTime;

    private Integer commEndTime;

    private ReferMethodType referMethodType;

    private String referMethod;

    public enum CommMethodType {

        EMAIL(0), PHONE(1), APPOINTMENT(2);

        public static CommMethodType getCommMethodType(byte value) {
            switch (value) {
            case 0:
                return EMAIL;
            case 1:
                return PHONE;
            case 2:
                return APPOINTMENT;
            default:
                return null;
            }
        }

        public final byte value;

        private CommMethodType(int value) {
            this.value = (byte) value;
        }
    }

    public enum ReferMethodType {

        INTERNAL(0), EXTERNAL(1);

        public static ReferMethodType getReferMethodType(byte value) {
            switch (value) {
            case 0:
                return INTERNAL;
            case 1:
                return EXTERNAL;
            default:
                return null;
            }
        }

        public final byte value;

        private ReferMethodType(int value) {
            this.value = (byte) value;
        }
    }

    // Builder class
    public static class ReferrerBuilder {
        private Integer id;

        private String firstname;

        private String middlename;

        private String lastname;

        private String email;

        private String phone;

        private String street1;

        private String street2;

        private String city;

        private String state;

        private String zip;

        private String country;

        private Integer companyId;

        private CommMethodType commMethodType;

        private String commMethod;

        private Integer commStartTime;

        private Integer commEndTime;

        private ReferMethodType referMethodType;

        private String referMethod;

        public void setId(Integer id) {
            this.id = id;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public void setMiddlename(String middlename) {
            this.middlename = middlename;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setStreet1(String street1) {
            this.street1 = street1;
        }

        public void setStreet2(String street2) {
            this.street2 = street2;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setState(String state) {
            this.state = state;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setCompanyId(Integer companyId) {
            this.companyId = companyId;
        }

        public void setCommMethodType(CommMethodType commMethodType) {
            this.commMethodType = commMethodType;
        }

        public void setCommMethod(String commMethod) {
            this.commMethod = commMethod;
        }

        public void setCommStartTime(Integer commStartTime) {
            this.commStartTime = commStartTime;
        }

        public void setCommEndTime(Integer commEndTime) {
            this.commEndTime = commEndTime;
        }

        public void setReferMethodType(ReferMethodType referMethodType) {
            this.referMethodType = referMethodType;
        }

        public void setReferMethod(String referMethod) {
            this.referMethod = referMethod;
        }

        public Referrer build() {
            return new Referrer(this);
        }
    }

    public Referrer() {
    }

    public Referrer(ReferrerBuilder builder) {
        setId(builder.id);
        setFirstname(builder.firstname);
        setMiddlename(builder.middlename);
        setLastname(builder.lastname);
        setEmail(builder.email);
        setPhone(builder.phone);
        setCity(builder.city);
        setState(builder.state);
        setZip(builder.zip);
        setCountry(builder.country);
        setCommEndTime(builder.commEndTime);
        setCommStartTime(builder.commStartTime);
        setCommMethodType(builder.commMethodType);
        setCommMethod(builder.commMethod);
        setCompanyId(builder.companyId);
        setReferMethod(builder.referMethod);
        setReferMethodType(builder.referMethodType);
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public CommMethodType getCommMethodType() {
        return commMethodType;
    }

    public void setCommMethodType(CommMethodType commMethodType) {
        this.commMethodType = commMethodType;
    }

    public String getCommMethod() {
        return commMethod;
    }

    public void setCommMethod(String commMethod) {
        this.commMethod = commMethod;
    }

    public Integer getCommStartTime() {
        return commStartTime;
    }

    public void setCommStartTime(Integer commStartTime) {
        this.commStartTime = commStartTime;
    }

    public Integer getCommEndTime() {
        return commEndTime;
    }

    public void setCommEndTime(Integer commEndTime) {
        this.commEndTime = commEndTime;
    }

    public ReferMethodType getReferMethodType() {
        return referMethodType;
    }

    public void setReferMethodType(ReferMethodType referMethodType) {
        this.referMethodType = referMethodType;
    }

    public String getReferMethod() {
        return referMethod;
    }

    public void setReferMethod(String referMethod) {
        this.referMethod = referMethod;
    }
}
