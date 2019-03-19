package storage;

import model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {
    protected ArrayList<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[storage.size()]);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected void updateResume(Object index, Resume resume) {
        storage.set((int) index, resume);
    }

    @Override
    protected void saveResume(Resume resume, Object index) {
        storage.add(resume);
    }

    @Override
    protected void deleteResume(Object index) {
        storage.remove((int) index);
    }

    @Override
    protected Object findIndex(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (uuid.equals(storage.get(i).getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected Resume returnStorageIndex(Object index) {
        return storage.get((int) index);
    }

    @Override
    protected boolean checkIndex(Object index) {
        return (int) index == -1;
    }
}
