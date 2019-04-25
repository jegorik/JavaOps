package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {
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
    protected void doUpdate(Integer searchKey, Resume resume) {
        storage.set(searchKey, resume);
    }

    @Override
    protected void doSave(Integer searchKey, Resume resume) {
        storage.add(resume);
    }

    @Override
    protected void doDelete(Integer searchKey) {
        storage.remove((int) searchKey);
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (uuid.equals(storage.get(i).getUuid())) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        return storage.get(searchKey);
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey != null;
    }
}
