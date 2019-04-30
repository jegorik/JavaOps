package model;

import java.util.List;
import java.util.Objects;

public class BilletedTextListSection extends AbstractSection {
    private List<String> list;

    public BilletedTextListSection(List list) {
        Objects.requireNonNull(list, "list must not be null");
        this.list = list;
    }

    public List<String> getData() {
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BilletedTextListSection billetedTextListSection = (BilletedTextListSection) o;
        return list.equals(billetedTextListSection.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    @Override
    public String toString() {
        return "BilletedTextListSection{" +
                "data=" + list +
                '}';
    }
}
