import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int size;
    private Resume[] storage = new Resume[10000];

    void clear() {
        //Swap existing "uuids" to "null".
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume resume) {
        //Search for first "null" value inside array and swap "null" to "resume".
        for (int i = size; i <= size; i++) {
            storage[i] = resume;
        }
        size++;
    }

    Resume get(String uuid) {
        //Search inside array for "uuid". If "uuid" is found, return "uuid" as result value. In case when "uuid" is not found, catch exception and show "error" msg.
        Resume result = null;
        try {
            for (int i = 0; i < size; i++) {
                if (storage[i].uuid.equals(uuid)) {
                    result = storage[i];
                }
            }
        } catch (NullPointerException exception) {
            System.out.println(uuid + " don't exist.");
        }
        return result;
    }

    void delete(String uuid) {
        //Swap existing "uuids" to "null". After "sort" array to move "null" value to the end.
        for (int i = 0; i < size ; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
            }
        }

        for (int i = 0; i < size-1; i++) {
            Resume nullValue;
            if (storage[i] == null & storage[i+1] != null) {
                nullValue = storage[i];
                storage[i] = storage[i + 1];
                storage[i + 1] = nullValue;
            }
        }

        for (int i = 0; i < size; i++) {
            if (storage[i] == null) {
                size--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    int size() {
        //Return amount of resumes inside array.
        return size;
    }
}
