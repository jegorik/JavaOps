package storage;

import model.Resume;

import java.util.Collections;

public class ListStorage extends AbstractStorage {

    @Override
    protected void updateResume(int index, Resume resume) {
        storage.set(index, resume);
    }

    @Override
    protected void saveResume(Resume resume, int index) {
        storage.add(resume);
    }

    @Override
    protected void deleteResume(int index) {
        storage.remove(index);
    }

    @Override
    protected int findIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        Collections.sort(storage);
        return Collections.binarySearch(storage, searchKey);
    }

    @Override
    protected Resume returnStorageIndex(int index) {
        return storage.get(index);
    }
}
