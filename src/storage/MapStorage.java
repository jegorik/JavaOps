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
        Resume[] temp = new Resume[storage.size()];
        int counter = 0;
        for (Map.Entry<String, Resume> value : storage.entrySet()) {
            Resume resume = value.getValue();
            temp[counter] = resume;
            counter++;
        }
        return temp;
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected String findIndex(String uuid) {
        return uuid;
    }

    @Override
    protected void saveResume(Resume resume, String index) {
        storage.put(index, resume);
    }

    @Override
    protected void deleteResume(String index) {
        storage.remove(index);
    }

    @Override
    protected void updateResume(String index, Resume resume) {
        storage.put(index, resume);
    }

    @Override
    protected Resume returnStorageIndex(String index) {
        return storage.get(index);
    }

    @Override
    protected boolean checkIndex(String index) {
        return !storage.containsKey(index);
    }
}
