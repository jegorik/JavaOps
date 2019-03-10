package storage;

import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {

    int size;
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    @Override
    protected boolean checkSpace() {
        return size < STORAGE_LIMIT;
    }

    @Override
    protected void clearResume() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void updateResume(int index, Resume resume) {
        storage[index] = resume;
    }

    @Override
    protected Resume returnStorageIndex(int index) {
        return storage[index];
    }

    protected void incrementSize() {
        size++;
    }

    protected void decrementSize() {
        storage[size - 1] = null;
        size--;
    }

    protected Resume[] getAllResumes() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected int getSize() {
        return size;
    }
}
