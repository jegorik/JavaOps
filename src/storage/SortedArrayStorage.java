package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void saveResume(Resume resume, int index) {
        int valueIndex = -index - 1;
        System.arraycopy(storage, valueIndex, storage, valueIndex + 1, size - valueIndex);
        storage[valueIndex] = resume;
        size++;
    }

    @Override
    protected void deleteResume(int index) {
        Resume[] tempStorage = new Resume[STORAGE_LIMIT - 1];
        int indexToRemove = size - index - 1;
        System.arraycopy(storage, 0, tempStorage, 0, index);
        System.arraycopy(storage, index + 1, tempStorage, index, indexToRemove);
        size--;
        storage = tempStorage;
    }

    @Override
    protected int findIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

}
