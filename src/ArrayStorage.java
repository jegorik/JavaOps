import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int size;
    private Resume[] storage = new Resume[10_000];

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index == -1) {
            System.out.println("ERROR: " + resume.getUuid() + " don't exist.");
        } else {
            storage[index] = resume;
        }
    }

    public void save(Resume resume) {
        if (size < storage.length) {
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

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index == -1) {
            System.out.println("ERROR: " + uuid + " don't exist.");
            return null;
        } else {
            return storage[index];
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

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    private int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}