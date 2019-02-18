import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index < 0) {
            System.out.println("ERROR: " + resume.getUuid() + " don't exist.");
        } else {
            storage[index] = resume;
        }
    }

    @Override
    public void save(Resume resume) {
        if (size < STORAGE_LIMIT) {
            int index = findIndex(resume.getUuid());
            if (index < 0) {
                storage[size] = resume;
                size++;
            } else {
                System.out.println("ERROR: " + resume + " already exist.");
            }
        } else {
            System.out.println("No empty space in storage!");
        }
        sort(storage);
    }

    @Override
    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index >= 0) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("ERROR: " + uuid + " don't exist.");
        }
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    private void sort(Resume[] array) {
        boolean isSorted;
        do {
            isSorted = false;
            for (int i = 0; i < size-1; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    Resume temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                    isSorted = true;
                }
            }
        } while ((isSorted));
    }

    @Override
    protected int findIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        System.out.println(Arrays.binarySearch(storage, 0, size, searchKey));
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

}
