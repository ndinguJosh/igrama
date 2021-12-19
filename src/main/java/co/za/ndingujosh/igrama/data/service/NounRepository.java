package co.za.ndingujosh.igrama.data.service;

import co.za.ndingujosh.igrama.data.entity.Noun;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NounRepository extends JpaRepository<Noun, Integer> {

}