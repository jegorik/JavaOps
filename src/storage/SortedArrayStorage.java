package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        if (size < STORAGE_LIMIT) {
            int index = findIndex(resume.getUuid());
            if (index < 0) {
                index = - index - 1;
                System.arraycopy(storage, index, storage, index + 1, size - index);
                storage[index] = resume;
                size++;
            } else {
                System.out.println("ERROR: " + resume + " already exist.");
            }
        } else {
            System.out.println("No empty space in storage!");
        }
    }

    @Override
    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index >= 0) {
            System.arraycopy(storage, index + 1, storage, index, size - index - 1);
            storage[size] = null;
            size--;
        } else {
            System.out.println("ERROR: " + uuid + " don't exist.");
        }
    }

    @Override
    protected int findIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

}
