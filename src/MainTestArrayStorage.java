import model.Resume;
import storage.SortedArrayStorage;
import storage.Storage;

/**
 * Test for your storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    private static final Storage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        final  Resume resume1 = new Resume();
        resume1.setUuid("uuid1");
        final    Resume resume2 = new Resume();
        resume2.setUuid("uuid2");
        final   Resume resume3 = new Resume();
        resume3.setUuid("uuid3");

        ARRAY_STORAGE.save(resume3);
        ARRAY_STORAGE.save(resume1);
        ARRAY_STORAGE.save(resume2);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(resume1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.update(resume1);
        printAll();
        ARRAY_STORAGE.delete(resume2.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    private static void printAll() {
        System.out.println("\nGet All");
        for (Resume resume : ARRAY_STORAGE.getAll()) {
            System.out.println(resume);
        }
    }
}
