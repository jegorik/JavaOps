package storage;

import exception.StorageException;
import model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {

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
    protected void doUpdate(Integer index, Resume resume) {
        storage[index] = resume;
    }

    @Override
    protected void doSave(Integer index, Resume resume) {
        if (size < STORAGE_LIMIT) {
            saveToArray(index, resume);
            size++;
        } else {
            throw new StorageException("Storage is full", resume.getUuid());
        }
    }

    @Override
    protected void doDelete(Integer index) {
        deleteFromArray(index);
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
    protected Resume doGet(Integer index) {
        return storage[index];
    }

    @Override
    protected boolean isExist(Integer index) {
        return index >= 0;
    }

}
