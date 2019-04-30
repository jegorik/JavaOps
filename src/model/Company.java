package model;

import java.time.LocalDate;
import java.util.Objects;

public class Company {
    private String name;
    private String specialization;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    public Company(String name, String specialization, String description, LocalDate startDate, LocalDate endDate) {
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(specialization, "specialization must not be null");
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(endDate, "endDate must not be null");
        this.name = name;
        this.specialization = specialization;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
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
        Company that = (Company) o;
        return name.equals(that.name) &&
                specialization.equals(that.specialization) &&
                description.equals(that.description) &&
                startDate.equals(that.startDate) &&
                endDate.equals(that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, specialization, description, startDate, endDate);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}

