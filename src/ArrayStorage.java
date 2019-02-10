import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int size;
    private Resume[] storage = new Resume[10000];

   public void clear() {
        //Swap existing "uuids" to "null".
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void update(String uuid, Resume resume) {
        //Check for "resume" and update it.
        String result = checkUuid(uuid);
        if (result == null) {
            System.out.println("ERROR: " + uuid + " don't exist.");
        } else {
            storage[Integer.parseInt(result)] = resume;
        }
    }

    public void save(Resume resume) {
        //Check for "resume" in array and save it.
        if (size < 10_000) {
            String result = checkUuid(resume.getUuid());
            if (result == null) {
                storage[size] = resume;
                size++;
            } else {
                System.out.println("ERROR: " + resume + " already exist.");
            }
        }else {
            System.out.println("No empty space in storage!");
        }
    }

    public Resume get(String uuid) {
        //Search inside array for "uuid".
        String check = checkUuid(uuid);
        Resume result = null;
        if (check == null) {
            System.out.println("ERROR: " + uuid + " don't exist.");
        } else {
            result = storage[Integer.parseInt(check)];
        }
        return result;
    }

    public void delete(String uuid) {
        //Check for "uuid" in array and delete it.
        String result = checkUuid(uuid);
        if (result != null) {
            storage[Integer.parseInt(result)]= storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("ERROR: " + uuid + " don't exist.");
        }
    }

    private String checkUuid(String uuid) {
        //Check for "uuid" in array. "uuid" found? If "true" - return result as array value.
        String result = null;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                result = Integer.toString(i);
                break;
            }
        }
        return result;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        //Return amount of resumes inside array.
        return size;
    }
}