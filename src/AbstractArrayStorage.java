public abstract class AbstractArrayStorage implements Storage {

    protected int size;
    protected final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    public int size() {
        return size;
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

    protected abstract int findIndex(String uuid);
}
