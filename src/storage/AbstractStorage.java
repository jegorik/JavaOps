package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        Object index = findIndex(resume.getUuid());
        if (checkIndex(index)) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            updateResume(index, resume);
        }
    }

    public void save(Resume resume) {
        Object index = findIndex(resume.getUuid());
        if (checkIndex(index)) {
            saveResume(resume, index);
        } else {
            throw new ExistStorageException(resume.getUuid());
        }
    }

    public void delete(String uuid) {
        Object index = findIndex(uuid);
        if (!checkIndex(index)) {
            deleteResume(index);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    public Resume get(String uuid) {
        Object index = findIndex(uuid);
        if (checkIndex(index)) {
            throw new NotExistStorageException(uuid);
        } else {
            return returnStorageIndex(index);
        }
    }

    public abstract void clear();

    public abstract Resume[] getAll();

    public abstract int size();

    protected abstract Object findIndex(String uuid);

    protected abstract boolean checkIndex(Object index);

    protected abstract void saveResume(Resume resume, Object index);

    protected abstract void deleteResume(Object index);

    protected abstract void updateResume(Object index, Resume resume);

    protected abstract Resume returnStorageIndex(Object index);

}
