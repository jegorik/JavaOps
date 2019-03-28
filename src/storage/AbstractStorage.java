package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

import java.util.List;

public abstract class AbstractStorage implements Storage {

    public abstract void clear();

    public abstract int size();

    protected abstract Object getSearchKey(String uuid);

    protected abstract void doSave(Object index, Resume resume);

    protected abstract void doDelete(Object index);

    protected abstract void doUpdate(Object index, Resume resume);

    protected abstract Resume doGet(Object index);

    protected abstract List<Resume> doCopyGetAll();

    protected abstract boolean isExist(Object index);

    public void update(Resume resume) {
        Object searchKey = getExistedSearchKey(resume.getUuid());
        doUpdate(searchKey, resume);
    }

    public void save(Resume resume) {
        Object searchKey = getNotExistedSearchKey(resume.getUuid());
        doSave(searchKey, resume);
    }

    public void delete(String uuid) {
        Object searchKey = getExistedSearchKey(uuid);
        doDelete(searchKey);
    }

    public Resume get(String uuid) {
        Object searchKey = getExistedSearchKey(uuid);
        return doGet(searchKey);
    }

    private Object getExistedSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getNotExistedSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    @Override
    public List<Resume> getAllSorted() {
        return doCopyGetAll();
    }

}
