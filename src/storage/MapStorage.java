package storage;

import model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> storage = new HashMap<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        Resume[] temp = storage.values().toArray(new Resume[0]);
        return temp;
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected Object findIndex(String uuid) {
        return uuid;
    }

    @Override
    protected void saveResume(Resume resume, Object index) {
        storage.put((String) index, resume);
    }

    @Override
    protected void deleteResume(Object index) {
        storage.remove(index);
    }

    @Override
    protected void updateResume(Object index, Resume resume) {
        storage.put((String) index, resume);
    }

    @Override
    protected Resume returnStorageIndex(Object index) {
        return storage.get(index);
    }

    @Override
    protected boolean checkIndexCondition(Object index) {
        return !storage.containsKey(index);
    }
}
