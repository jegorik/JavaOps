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

    public void save(Resume resume) {
        if (size < STORAGE_LIMIT) {
            int index = findIndex(resume.getUuid());
            if (index < 0) {
                saveResume(resume, index);
                size++;
            } else {
                System.out.println("ERROR: " + resume + " already exist.");
            }
        } else {
            System.out.println("No empty space in storage!");
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

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index >= 0) {
            deleteResume(index);
            size--;
        } else {
            System.out.println("ERROR: " + uuid + " don't exist.");
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    protected abstract int findIndex(String uuid);

    protected abstract void saveResume(Resume resume, int index);

    protected abstract void deleteResume(int index);
}
