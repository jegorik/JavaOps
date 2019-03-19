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
    protected void updateResume(String index, Resume resume) {
        storage.set(convertIndexToInt(index), resume);
    }

    @Override
    protected void saveResume(Resume resume, String index) {
        storage.add(resume);
    }

    @Override
    protected void deleteResume(String index) {
        storage.remove(convertIndexToInt(index));
    }

    @Override
    protected String findIndex(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (uuid.equals(storage.get(i).getUuid())) {
                return convertIndexToString(i);
            }
        }
        return "-1";
    }

    @Override
    protected Resume returnStorageIndex(String index) {
        return storage.get(convertIndexToInt(index));
    }

    @Override
    protected boolean checkIndex(String index) {
        return index.equals("-1");
    }
}
