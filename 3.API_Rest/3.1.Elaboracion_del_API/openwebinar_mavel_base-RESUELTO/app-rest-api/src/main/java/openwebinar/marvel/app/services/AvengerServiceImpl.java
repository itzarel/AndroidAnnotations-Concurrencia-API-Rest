package openwebinar.marvel.app.services;

import openwebinar.marvel.app.domain.Avenger;
import openwebinar.marvel.app.repositories.AvengerRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AvengerServiceImpl implements AvengerService {
    private AvengerRepository repository;

    public AvengerServiceImpl(AvengerRepository avengerRepository) {
        this.repository = avengerRepository;
    }

    @Override
    public Long countAllByIdGreaterThanEqual(Long startIn) {
        return repository.countAllByIdGreaterThanEqual(startIn);
    }

    @Override
    public List<Avenger> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Avenger> findByLang(String lang) {
        return repository.findByLang(lang);
    }

    @Override
    public Avenger findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Avenger findByNameAndLang(String name, String lang) {
        return repository.findByNameAndLang(name, lang);
    }

    @Override
    public Avenger findByActorAndLang(String actor, String lang) {
        return repository.findByActorAndLang(actor, lang);
    }

    @Override
    public Avenger save(Avenger persisted) {
        return repository.save(persisted);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
