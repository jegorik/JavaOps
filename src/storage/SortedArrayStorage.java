package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void saveResume(Resume resume, int index) {
        int valueIndex = -index - 1;
        System.arraycopy(storage, valueIndex, storage, valueIndex + 1, size - valueIndex);
        storage[valueIndex] = resume;
    }

    @Override
    protected void deleteResume(int index) {
        int indexToRemove = size - index - 1;
        System.arraycopy(storage, index + 1, storage, index, indexToRemove);
    }

    @Override
    protected int findIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

}
