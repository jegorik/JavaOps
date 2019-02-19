package storage;

import model.Resume;
import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {

    protected int size;
    protected final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index < 0) {
            System.out.println("ERROR: " + resume.getUuid() + " don't exist.");
        } else {
            storage[index] = resume;
        }
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            System.out.println("ERROR: " + uuid + " don't exist.");
            return null;
        } else {
            return storage[index];
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    protected abstract int findIndex(String uuid);
}
