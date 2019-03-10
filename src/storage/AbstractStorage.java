package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import exception.StorageException;
import model.Resume;

public abstract class AbstractStorage implements Storage {

    public void clear() {
        clearResume();
    }

    public void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            updateResume(index, resume);
        }
    }

    public void save(Resume resume) {
        checkSpace();
        if (checkSpace()) {
            int index = findIndex(resume.getUuid());
            if (index < 0) {
                saveResume(resume, index);
            } else {
                throw new ExistStorageException(resume.getUuid());
            }
        } else {
            throw new StorageException("Storage is full", resume.getUuid());
        }
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            return returnStorageIndex(index);
        }
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index >= 0) {
            deleteResume(index);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    public Resume[] getAll() {
        return getAllResumes();
    }

    public int size() {
        return getSize();
    }

    protected abstract int findIndex(String uuid);

    protected abstract void saveResume(Resume resume, int index);

    protected abstract boolean checkSpace();

    protected abstract void deleteResume(int index);

    protected abstract void clearResume();

    protected abstract void updateResume(int index, Resume resume);

    protected abstract Resume returnStorageIndex(int index);

    protected abstract Resume[] getAllResumes();

    protected abstract int getSize();
}
