package br.com.gabrielrps.realchat.realchat.repo;

import br.com.gabrielrps.realchat.realchat.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findByUsername(String username);
}
