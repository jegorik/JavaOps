package model;

import java.time.LocalDate;
import java.util.Objects;

public class CompanyInfo {
    private String companyName;
    private String specialization;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    public CompanyInfo(String companyName, String specialization, String description, LocalDate startDate, LocalDate endDate) {
        Objects.requireNonNull(companyName, "companyName must not be null");
        Objects.requireNonNull(specialization, "specialization must not be null");
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(endDate, "endDate must not be null");
        this.companyName = companyName;
        this.specialization = specialization;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyInfo that = (CompanyInfo) o;
        return companyName.equals(that.companyName) &&
                specialization.equals(that.specialization) &&
                description.equals(that.description) &&
                startDate.equals(that.startDate) &&
                endDate.equals(that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, specialization, description, startDate, endDate);
    }

    @Override
    public String toString() {
        return "CompanyInfo{" +
                "companyName='" + companyName + '\'' +
                ", specialization='" + specialization + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}

