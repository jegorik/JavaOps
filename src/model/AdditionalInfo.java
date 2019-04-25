package model;

import java.util.List;
import java.util.Objects;

public class AdditionalInfo extends Section {
    private List<CompanyInfo> companyInfos;

    public AdditionalInfo(List<CompanyInfo> companyInfos) {
        Objects.requireNonNull(companyInfos, "Company info must not be null");
        this.companyInfos = companyInfos;
    }

    public List<CompanyInfo> getCompanyInfos() {
        return companyInfos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdditionalInfo that = (AdditionalInfo) o;
        return companyInfos.equals(that.companyInfos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyInfos);
    }

    @Override
    public String toString() {
        return "AdditionalInfo{" +
                "companyInfos=" + companyInfos +
                '}';
    }
}
