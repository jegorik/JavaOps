import model.Resume;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MainCollections {
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME1 = new Resume(UUID_1);
    private static final Resume RESUME2 = new Resume(UUID_2);
    private static final Resume RESUME3 = new Resume(UUID_3);

    public static void main(String[] args) {
        ArrayList<Resume> collection = new ArrayList<>();
        Map<Integer, String> mass = new TreeMap<>();
        collection.add(RESUME1);
        collection.add(RESUME2);
        collection.add(RESUME3);

        for (Resume value : collection) {
            System.out.println(value);
        }

        Iterator<Resume> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Resume resume = iterator.next();
            if (resume.getUuid().equals(UUID_2)) {
                iterator.remove();
            }
        }

        System.out.println(collection.toString());
        System.out.println(collection.get(1));
        System.out.println(collection.indexOf(RESUME3));
        collection.clear();
        System.out.println(collection);

        mass.put(1, "val1");
        mass.put(2, "val2");
        mass.put(3, "val3");

        System.out.println(mass.get(2));
    }
}
