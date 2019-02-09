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

    void update(String uuid, Resume resume) {
        //Check for "resume". "Resume" exist? If "true" - update "resume".
        // If "false" - show error msg.
        Resume result = checkUuid(uuid);
        if (result != null) {
            result = resume;
        } else {
            System.out.println("ERROR: " + uuid + " don't exist.");
        }
    }

    void save(Resume resume) {
        //Check for "resume" in array. "Resume" exist? If "true" - print a msg.
        // If "false" - add "resume" to array. Increment size.
        String result = checkResume(resume);
        if (result == null) {
            storage[size] = resume;
            size++;
        } else {
            System.out.println("ERROR: " + resume + " already exist.");
        }
    }

    Resume get(String uuid) {
        //Search inside array for "uuid". If "uuid" is found, return "uuid" as result value.
        //In case when "uuid" is not found, show error msg.
        Resume check = checkUuid(uuid);
        if (check == null) {
            System.out.println("ERROR: " + uuid + " don't exist.");
        }
        return check;
    }

    void delete(String uuid) {
        //Check for "uuid" in array. "uuid" found? If "true" - Swap existing "uuids" to "null". After "sort" array to move "null" value to the end.
        //If "false" - show error msg.
        Resume result = checkUuid(uuid);
        if (result != null) {
            result = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("ERROR: " + uuid + " don't exist.");
        }
    }

    String checkResume(Resume resume) {
        //Check for "Resume" in array. "Resume" found? If "true" - return result array index.
        //If "false" - show error msg. Return null;
        String result = null;
        for (int i = 0; i < size; i++) {
            if (storage[i] == resume) {
                result = Integer.toString(i);
                break;
            }
        }
        return result;
    }

    Resume checkUuid(String uuid) {
        //Check for "uuid" in array. "uuid" found? If "true" - return result as array value.
        //If "false" - show error msg. Return null;
        Resume result = null;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                result = storage[i];
                break;
            }
        }
        return result;
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
