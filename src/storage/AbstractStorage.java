package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        String index = findIndex(resume.getUuid());
        if (checkIndex(index)) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            updateResume(index, resume);
        }
    }

    public void save(Resume resume) {
        String index = findIndex(resume.getUuid());
        if (checkIndex(index)) {
            saveResume(resume, index);
        } else {
            throw new ExistStorageException(resume.getUuid());
        }
    }

    public void delete(String uuid) {
        String index = findIndex(uuid);
        if (!checkIndex(index)) {
            deleteResume(index);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    public Resume get(String uuid) {
        String index = findIndex(uuid);
        if (checkIndex(index)) {
            throw new NotExistStorageException(uuid);
        } else {
            return returnStorageIndex(index);
        }
    }

    public int convertIndexToInt(String index) {
        return Integer.parseInt(index);
    }

    public String convertIndexToString(int index) {
        return Integer.toString(index);
    }


    public abstract void clear();

    public abstract Resume[] getAll();

    public abstract int size();

    protected abstract String findIndex(String uuid);

    protected abstract boolean checkIndex(String index);

    protected abstract void saveResume(Resume resume, String index);

    protected abstract void deleteResume(String index);

    protected abstract void updateResume(String index, Resume resume);

    protected abstract Resume returnStorageIndex(String index);

}
