package openwebinar.marvel.app.repositories;


import openwebinar.marvel.app.domain.Avenger;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface AvengerRepository extends Repository<Avenger, Long> {
    Long countAllByIdGreaterThanEqual(Long startIn);

    List<Avenger> findAll();
    List<Avenger> findByLang(String lang);

    Avenger findById(Long id);
    Avenger findByNameAndLang(String name, String lang);
    Avenger findByActorAndLang(String actor, String lang);

    Avenger save(Avenger persisted);
    void deleteById(Long id);
}