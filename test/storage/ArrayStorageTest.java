package storage;

public class ArrayStorageTest extends AbstractArrayStorageTest {
    private static Storage storage;

    public ArrayStorageTest() {
        super(storage = new ArrayStorage());
    }
}