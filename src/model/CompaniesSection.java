package model;

import java.util.List;
import java.util.Objects;

public class CompaniesSection extends AbstractSection {
    private List<Company> companies;

    public CompaniesSection(List<Company> companies) {
        Objects.requireNonNull(companies, "Company info must not be null");
        this.companies = companies;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompaniesSection that = (CompaniesSection) o;
        return companies.equals(that.companies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companies);
    }

    @Override
    public String toString() {
        return "CompaniesSection{" +
                "companies=" + companies +
                '}';
    }
}
