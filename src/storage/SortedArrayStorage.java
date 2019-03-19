package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void saveToArray(Resume resume, int index) {
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
    protected Object findIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected boolean checkIndex(Object index) {
        return (int) index < 0;
    }
}
