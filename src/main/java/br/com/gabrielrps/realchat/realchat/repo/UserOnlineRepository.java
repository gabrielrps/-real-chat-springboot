package br.com.gabrielrps.realchat.realchat.repo;

import br.com.gabrielrps.realchat.realchat.model.UserOnline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserOnlineRepository extends CrudRepository<UserOnline, String> {

    void deleteAllByUserUsername(String username);

    List<UserOnline> findAllByUserUsernameNot(String username);
}
