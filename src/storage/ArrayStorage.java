package storage;

import model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    private int size;
    private final int STORAGE_LIMIT = 10000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];

    public void save(Resume resume) {
        if (size < STORAGE_LIMIT) {
            int index = findIndex(resume.getUuid());
            if (index == -1) {
                storage[size] = resume;
                size++;
            } else {
                System.out.println("ERROR: " + resume + " already exist.");
            }
        } else {
            System.out.println("No empty space in storage!");
        }
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index != -1) {
            storage[index]= storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("ERROR: " + uuid + " don't exist.");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    protected int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}