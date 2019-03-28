package storage;

import exception.StorageException;
import model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected abstract Integer getSearchKey(String uuid);

    protected abstract void saveToArray(int index, Resume resume);

    protected abstract void deleteFromArray(int index);

    int size;
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void doUpdate(Object index, Resume resume) {
        storage[(int) index] = resume;
    }

    @Override
    protected void doSave(Object index, Resume resume) {
        if (size < STORAGE_LIMIT) {
            saveToArray((int) index, resume);
            size++;
        } else {
            throw new StorageException("Storage is full", resume.getUuid());
        }
    }

    @Override
    protected void doDelete(Object index) {
        deleteFromArray((int) index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    public List<Resume> doCopyGetAll() {
        Resume[] result = Arrays.copyOfRange(storage, 0, size);
        return Arrays.asList(result);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    protected Resume doGet(Object index) {
        return storage[(int) index];
    }

    @Override
    protected boolean isExist(Object index) {
        return (int) index >= 0;
    }

}
