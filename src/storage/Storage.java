package storage;

import model.Resume;

/**
 * Array based storage interface for Resumes
 */
public interface Storage {

    void clear();

    Resume update(Resume resume);

    Resume save(Resume resume);

    Resume get(String uuid);

    void delete(String uuid);

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    Resume[] getAll();

    int size();
}