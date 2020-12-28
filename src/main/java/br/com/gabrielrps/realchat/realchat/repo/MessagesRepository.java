package br.com.gabrielrps.realchat.realchat.repo;

import br.com.gabrielrps.realchat.realchat.model.MessageChat;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface MessagesRepository extends CrudRepository<MessageChat, String> {

    List<MessageChat> findAllByTo(String to);

    @Query("{$or : [{$and : [{from: ?0}, {to : ?1}]},{$and : [{to: ?0}, {from : ?1}]}]}")
    Collection<MessageChat> findAllByFromAndToOrToAndFrom(String from, String to);
}
