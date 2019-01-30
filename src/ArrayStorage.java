import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int size;
    private Resume[] storage = new Resume[10000];

    void clear() {
        //Swap existing "uuids" to "null".
        int steps = size;
        for (int i = 0; i < steps; i++) {
            storage[i] = null;
            size--;
        }
    }

    void save(Resume resume) {
        //Search for first "null" value inside array and swap "null" to "resume".
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = resume;
                size++;
                break;
            }
        }
    }

    Resume get(String uuid) {
        //Search inside array for "uuid". If "uuid" is found, return "uuid" as result value. In case when "uuid" is not found, catch exception and show "error" msg.
        Resume result = null;
        try {
            for (Resume value : storage) {
                if (value.uuid.equals(uuid)) {
                    result = value;
                    break;
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
                break;
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
        size--;
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
