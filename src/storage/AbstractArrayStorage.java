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
    protected void updateResume(String index, Resume resume) {
        storage[convertIndexToInt(index)] = resume;
    }

    @Override
    protected void saveResume(Resume resume, String index) {
        if (size < STORAGE_LIMIT) {
            saveToArray(resume, convertIndexToInt(index));
            size++;
        } else {
            throw new StorageException("Storage is full", resume.getUuid());
        }
    }

    @Override
    protected void deleteResume(String index) {
        deleteFromArray(convertIndexToInt(index));
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
    protected Resume returnStorageIndex(String index) {
        return storage[convertIndexToInt(index)];
    }

    protected abstract void saveToArray(Resume resume, int index);

    protected abstract void deleteFromArray(int index);

}
