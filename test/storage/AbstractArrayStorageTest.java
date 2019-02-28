package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import exception.StorageException;
import model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public abstract class AbstractArrayStorageTest {
    private Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static Resume resume1 = new Resume(UUID_1);
    private static Resume resume2 = new Resume(UUID_2);
    private static Resume resume3 = new Resume(UUID_3);


    AbstractArrayStorageTest(Storage storage) {
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
        Assert.assertEquals(3, storage.size());
        Resume resume4 = new Resume("uuid4");
        storage.save(resume4);
        Assert.assertEquals(resume4, storage.get("uuid4"));
        Assert.assertEquals(4, storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(resume1);
    }

    @Test
    public void update() {
        Resume result = resume3;
        storage.update(resume3);
        Assert.assertEquals(result, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        Resume resume4 = new Resume();
        storage.update(resume4);
    }

    @Test
    public void get() {
        Resume result = resume2;
        Assert.assertEquals(result, storage.get(UUID_2));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test
    public void delete() {
        Assert.assertEquals(3, storage.size());
        storage.delete("uuid1");
        Assert.assertEquals(2, storage.size());
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
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void storageFull() {
        storage.clear();
        try {
            int STORAGE_LIMIT = 10000;
            for (int i = 0; i < STORAGE_LIMIT; i++) {
                Resume resume = new Resume();
                storage.save(resume);
            }
        } catch (StorageException e) {
            Assert.fail();
        }
        try {
            storage.save(new Resume());
        } catch (StorageException e) {
            assertTrue("Storage is full", true);
        }
    }
}