package storage;

import model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(o -> o.getUuid());


    @Override
    protected void saveToArray(int index, Resume resume) {
        int valueIndex = -index - 1;
        System.arraycopy(storage, valueIndex, storage, valueIndex + 1, size - valueIndex);
        storage[valueIndex] = resume;
    }

    @Override
    protected void deleteFromArray(int index) {
        int indexToRemove = size - index - 1;
        System.arraycopy(storage, index + 1, storage, index, indexToRemove);

    }

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "TestName");
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }
}
