package org.mitpu.referral.core.repositories.models;

import java.time.LocalDateTime;

public class Candidate extends Person {

    private WorkAuthorization workAuthorization;

    private LocalDateTime date;

    private String about;

    private String linkedin;

    private Stage stage;

    private Status status;

    private Integer coordinatorId;

    public enum Stage {
        INITIAL(0), READY_TO_REFER(1), MISMATCH_POSITION(2), RESUME_REVISION(3), TO_REFERRER(4);

        public static Stage getStage(byte value) {
            switch (value) {
            case 0:
                return INITIAL;
            case 1:
                return READY_TO_REFER;
            case 2:
                return MISMATCH_POSITION;
            case 3:
                return TO_REFERRER;
            default:
                return null;
            }
        }

        public final byte value;

        private Stage(int value) {
            this.value = (byte) value;
        }
    }

    public enum Status {
        NEW(0), IN_PROGRESS(1), DEACTIVE(2), GOT_JOB(3), DONE(4), BLOCKED(5);

        public static Status getStatus(byte value) {
            switch (value) {
            case 0:
                return NEW;
            case 1:
                return IN_PROGRESS;
            case 2:
                return DEACTIVE;
            case 3:
                return GOT_JOB;
            case 4:
                return DONE;
            case 5:
                return BLOCKED;
            default:
                return null;
            }
        }

        public final byte value;

        private Status(int value) {
            this.value = (byte) value;
        }
    }

    // Builder class
    public static class CandidateBuilder {
        private Integer id;

        private String firstname;

        private String middlename;

        private String lastname;

        private String email;

        private String phone;

        private LocalDateTime date;

        private String about;

        private String city;

        private String state;

        private String zip;

        private String country;

        private WorkAuthorization workAuthorization;

        private String linkedin;

        private Stage stage;

        private Status status;

        private Integer coordinatorId;

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

        public void setWorkAuthorization(WorkAuthorization workAuthorization) {
            this.workAuthorization = workAuthorization;
        }

        public void setLinkedin(String linkedin) {
            this.linkedin = linkedin;
        }

        public void setStage(Stage stage) {
            this.stage = stage;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public void setCoordinatorId(Integer coordinatorId) {
            this.coordinatorId = coordinatorId;
        }

        public void setDate(LocalDateTime date) {
            this.date = date;
        }

        public void setAbout(String about) {
            this.about = about;
        }

        public Candidate build() {
            return new Candidate(this);
        }
    }

    public Candidate() {
    }

    public Candidate(CandidateBuilder candidateBuilder) {
        setId(candidateBuilder.id);
        setFirstname(candidateBuilder.firstname);
        setMiddlename(candidateBuilder.middlename);
        setLastname(candidateBuilder.lastname);
        setEmail(candidateBuilder.email);
        setPhone(candidateBuilder.phone);
        setCity(candidateBuilder.city);
        setState(candidateBuilder.state);
        setZip(candidateBuilder.zip);
        setCountry(candidateBuilder.country);
        this.workAuthorization = candidateBuilder.workAuthorization;
        this.linkedin = candidateBuilder.linkedin;
        this.stage = candidateBuilder.stage;
        this.status = candidateBuilder.status;
        this.coordinatorId = candidateBuilder.coordinatorId;
        this.about = candidateBuilder.about;
        this.date = candidateBuilder.date;
    }

    public WorkAuthorization getWorkAuthorization() {
        return workAuthorization;
    }

    public void setWorkAuthorization(WorkAuthorization workAuthorization) {
        this.workAuthorization = workAuthorization;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getCoordinatorId() {
        return coordinatorId;
    }

    public void setCoordinatorId(Integer coordinatorId) {
        this.coordinatorId = coordinatorId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
