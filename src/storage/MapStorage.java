package storage;

import model.Resume;

import java.util.Map;
import java.util.TreeMap;

public class MapStorage extends AbstractStorage {
    private Map<Integer, Resume> storage = new TreeMap<>();
    private int lastPositionIndex = 0;

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        Resume[] temp = new Resume[storage.size()];
        int counter = 0;
        for (Map.Entry<Integer, Resume> value : storage.entrySet()) {
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
    protected int findIndex(String uuid) {
        for (Map.Entry<Integer, Resume> value : storage.entrySet()) {
            Resume resume = value.getValue();
            int position = value.getKey();
            if (uuid.equals(resume.getUuid())) {
                return value.getKey();
            }
        }
        return -1;
    }

    @Override
    protected void saveResume(Resume resume, int index) {
        lastPositionIndex = (lastPositionIndex + (-(index)));
        storage.put(lastPositionIndex, resume);
    }

    @Override
    protected void deleteResume(int index) {
        storage.remove(index);
    }

    @Override
    protected void updateResume(int index, Resume resume) {
        storage.put(index, resume);
    }

    @Override
    protected Resume returnStorageIndex(int index) {
        return storage.get(index);
    }
}
