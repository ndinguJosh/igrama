package co.za.ndingujosh.igrama.data.service;

import co.za.ndingujosh.igrama.data.entity.Noun;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NounService {

    private NounRepository repository;

    public NounService(@Autowired NounRepository repository) {
        this.repository = repository;
    }

    public Optional<Noun> get(Integer id) {
        return repository.findById(id);
    }

    public Noun update(Noun entity) {
        return repository.save(entity);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Page<Noun> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public int count() {
        return (int) repository.count();
    }

}
