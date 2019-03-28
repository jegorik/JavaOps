package storage;

import exception.StorageException;
import model.Resume;
import org.junit.Assert;
import org.junit.Test;

import static storage.AbstractArrayStorage.STORAGE_LIMIT;

public class AbstractArrayStorageTest extends AbstractStorageTest {
    private Storage storage;

    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
        this.storage = storage;
    }

    @Test(expected = StorageException.class)
    public void saveOverFlow() {
        storage.clear();
        try {
            for (int i = 0; i < STORAGE_LIMIT; i++) {
                Resume resume = new Resume("TestName" + i);
                storage.save(resume);
            }
        } catch (StorageException e) {
            Assert.fail("Storage overflow!");
        }
        storage.save(new Resume("Overflow"));
    }
}