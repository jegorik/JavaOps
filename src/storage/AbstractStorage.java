package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {
    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    public abstract void clear();

    public abstract int size();

    protected abstract SK getSearchKey(String uuid);

    protected abstract void doSave(SK index, Resume resume);

    protected abstract void doDelete(SK index);

    protected abstract void doUpdate(SK index, Resume resume);

    protected abstract Resume doGet(SK index);

    protected abstract List<Resume> doCopyGetAll();

    protected abstract boolean isExist(SK index);

    public void update(Resume resume) {
        LOG.info("Update " + resume);
        SK searchKey = getExistedSearchKey(resume.getUuid());
        doUpdate(searchKey, resume);
    }

    public void save(Resume resume) {
        LOG.info("Save " + resume);
        SK searchKey = getNotExistedSearchKey(resume.getUuid());
        doSave(searchKey, resume);
    }

    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        SK searchKey = getExistedSearchKey(uuid);
        doDelete(searchKey);
    }

    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        SK searchKey = getExistedSearchKey(uuid);
        return doGet(searchKey);
    }

    private SK getExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            LOG.warning("Resume " + uuid + " non exist.");
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK getNotExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            LOG.warning("ERROR: " + uuid + " already exist.");
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    @Override
    public List<Resume> getAllSorted() {
        LOG.info("GetAllSorted ");
        return doCopyGetAll();
    }

}
