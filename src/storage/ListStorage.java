package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    protected List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public List<Resume> doCopyGetAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected void doUpdate(Object searchKey, Resume resume) {
        storage.set((int) searchKey, resume);
    }

    @Override
    protected void doSave(Object searchKey, Resume resume) {
        storage.add(resume);
    }

    @Override
    protected void doDelete(Object searchKey) {
        storage.remove((int) searchKey);
    }

    @Override
    protected Object getSearchKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (uuid.equals(storage.get(i).getUuid())) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storage.get((int) searchKey);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }
}
