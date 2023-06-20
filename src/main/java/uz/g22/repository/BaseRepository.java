package uz.g22.repository;

import java.util.UUID;

public interface BaseRepository<T> {
    T save(T t);
    T getById(UUID id);

    void deleteById(UUID id);

    T update(T update);

}
