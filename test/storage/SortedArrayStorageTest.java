package storage;

public class SortedArrayStorageTest extends AbstractArrayStorageTest {
    private static Storage storage;

    public SortedArrayStorageTest() {
        super(storage = new SortedArrayStorage());
    }
}
