package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStorageTest {
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final String UUID_DUMMY = "UUID_DUMMY";
    private static final Resume RESUME1 = new Resume(UUID_1, "Name1");
    private static final Resume RESUME2 = new Resume(UUID_2, "Name2");
    private static final Resume RESUME3 = new Resume(UUID_3, "Name3");
    private static final Resume RESUME4 = new Resume(UUID_4, "Name4");
    private static final Resume DUMMY = new Resume(UUID_DUMMY, "UUID_DUMMY");

    protected Storage storage;

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME1);
        storage.save(RESUME2);
        storage.save(RESUME3);
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void save() {
        storage.save(RESUME4);
        Assert.assertEquals(RESUME4, storage.get("uuid4"));
        Assert.assertEquals(4, storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(RESUME1);
    }

    @Test
    public void update() {
        Resume testResume = new Resume(UUID_1, "TestName");
        storage.update(testResume);
        Assert.assertEquals(testResume, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(DUMMY);
    }

    @Test
    public void get() {
        Assert.assertEquals(RESUME2, storage.get(UUID_2));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("UUID_DUMMY");
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_1);
        Assert.assertEquals(2, storage.size());
        storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("UUID_DUMMY");
    }

    @Test
    public void getAll() {
        List<Resume> test = new ArrayList<>();
        test.add(RESUME1);
        test.add(RESUME2);
        test.add(RESUME3);
        List<Resume> result = storage.getAllSorted();
        Assert.assertEquals(test, result);
        Assert.assertEquals(3, result.size());
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

}
