package storage;

import model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {
    protected ArrayList<Resume> storage = new ArrayList<>();

    @Override
    protected void clearResume() {
        storage.removeAll(storage);
    }

    @Override
    protected void updateResume(int index, Resume resume) {
        storage.set(index, resume);
    }

    @Override
    protected boolean checkSpace() {
        return true;
    }

    @Override
    protected int findIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return storage.indexOf(searchKey);
    }

    @Override
    protected Resume returnStorageIndex(int index) {
        return storage.get(index);
    }

    @Override
    protected void saveResume(Resume resume, int index) {
        storage.add(resume);
    }

    @Override
    protected void deleteResume(int index) {
        storage.remove(index);
    }

    protected Resume[] getAllResumes() {
        return storage.toArray(new Resume[storage.size()]);
    }

    protected int getSize() {
        return storage.size();
    }
}
