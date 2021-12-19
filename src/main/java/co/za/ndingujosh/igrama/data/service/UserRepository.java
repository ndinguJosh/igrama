package co.za.ndingujosh.igrama.data.service;

import co.za.ndingujosh.igrama.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}