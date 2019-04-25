package model;

import java.util.List;
import java.util.Objects;

public class ListInfo extends Section {
    private List<String> listData;

    public ListInfo(List listData) {
        Objects.requireNonNull(listData, "listData must not be null");
        this.listData = listData;
    }

    public List<String> getData() {
        return listData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListInfo listInfo = (ListInfo) o;
        return listData.equals(listInfo.listData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listData);
    }

    @Override
    public String toString() {
        return "ListInfo{" +
                "data=" + listData +
                '}';
    }
}
