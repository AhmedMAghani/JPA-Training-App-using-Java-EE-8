package com.JPAJakartaEE8.Entity;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class Qualification {
    private String schoolName;
    private LocalDate dateCompleted;
    private String qualificationAwarded;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public LocalDate getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(LocalDate dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public String getQualificationAwarded() {
        return qualificationAwarded;
    }

    public void setQualificationAwarded(String qualificationAwarded) {
        this.qualificationAwarded = qualificationAwarded;
    }
}
