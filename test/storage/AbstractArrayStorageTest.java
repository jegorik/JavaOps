package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import exception.StorageException;
import model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static storage.AbstractArrayStorage.STORAGE_LIMIT;

public abstract class AbstractArrayStorageTest {
    private Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final Resume resume1 = new Resume(UUID_1);
    private static final Resume resume2 = new Resume(UUID_2);
    private static final Resume resume3 = new Resume(UUID_3);


    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void save() {
        Resume resume4 = storage.save(new Resume("uuid4"));
        Assert.assertEquals(resume4, storage.get("uuid4"));
        Assert.assertEquals(4, storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(resume1);
    }

    @Test
    public void update() {
        Resume result = storage.update(new Resume(UUID_3));
        Assert.assertSame(result, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(new Resume("test"));
    }

    @Test
    public void get() {
        Assert.assertEquals(resume2, storage.get(UUID_2));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_1);
        Assert.assertEquals(2, storage.size());
        storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("dummy");
    }

    @Test
    public void getAll() {
        Resume[] test = {resume1, resume2, resume3};
        Resume[] result = storage.getAll();
        Assert.assertArrayEquals(test, result);
        Assert.assertEquals(3, result.length);
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test(expected = StorageException.class)
    public void saveOverFlow() {
        storage.clear();
        try {
            for (int i = 0; i < STORAGE_LIMIT; i++) {
                Resume resume = new Resume();
                storage.save(resume);
            }
        } catch (StorageException e) {
            Assert.fail("Storage overflow!");
        }
        storage.save(new Resume());
        assertTrue("Storage is full", true);
    }
}