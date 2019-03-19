package storage;

import exception.StorageException;
import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {

    int size;
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void updateResume(Object index, Resume resume) {
        storage[(int) index] = resume;
    }

    @Override
    protected void saveResume(Resume resume, Object index) {
        if (size < STORAGE_LIMIT) {
            saveToArray(resume, (int) index);
            size++;
        } else {
            throw new StorageException("Storage is full", resume.getUuid());
        }
    }

    @Override
    protected void deleteResume(Object index) {
        deleteFromArray((int) index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    protected Resume returnStorageIndex(Object index) {
        return storage[(int) index];
    }

    protected abstract void saveToArray(Resume resume, int index);

    protected abstract void deleteFromArray(int index);

}
