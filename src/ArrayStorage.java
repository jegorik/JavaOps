import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];

    void clear() {
        // check array for existing "uuids" and swap them to "null".
        int size = 0;
        for (Resume value : storage) {
            if (value != null) {
                size++;
            } else {
                break;
            }
        }
        for (int i = 0; i < size ; i++) {
            storage[i] = null;
        }
    }

    void save(Resume resume) {
        // search for first "null" value in array and swap "null" to "resume".
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = resume;
                break;
            }
        }
    }

    Resume get(String uuid) {
        //search in array for "uuid". If "uuid" is found, return "uuid" as result value. In case when "uuid" is not found, catch exception and show "error" msg.
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
        //check array for existing "uuids" and swap them to "null". After "sort" array to move "null" value to the end.
        int size = 0;
        for (Resume value : storage) {
            if (value != null) {
                size++;
            } else {
                break;
            }
        }

        for (int i = 0; i < storage.length ; i++) {
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

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    Resume[] getAll() {
        int size = 0;
        for (Resume value : storage) {
            if (value != null) {
                size++;
            } else {
                break;
            }
        }
        return Arrays.copyOfRange(storage, 0, size);
    }

    int size() {
        //check array for existing "uuids" and return size.
        int size = 0;
        for (Resume value : storage ){
            if (value != null) {
                size++;
            } else {
                break;
            }
        }
        return size;
    }
}
