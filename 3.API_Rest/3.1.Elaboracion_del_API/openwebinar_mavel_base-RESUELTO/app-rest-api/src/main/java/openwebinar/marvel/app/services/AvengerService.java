package openwebinar.marvel.app.services;

import openwebinar.marvel.app.domain.Avenger;

import java.util.List;

public interface AvengerService {
    Long countAllByIdGreaterThanEqual(Long startIn);

    List<Avenger> findAll();
    List<Avenger> findByLang(String lang);

    Avenger findById(Long id);
    Avenger findByNameAndLang(String name, String lang);
    Avenger findByActorAndLang(String actor, String lang);

    Avenger save(Avenger persisted);
    void deleteById(Long id);

}
