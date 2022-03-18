package cl.service.poc.dao;

import cl.service.poc.collections.CharacterCollection;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterReactiveRepository extends ReactiveMongoRepository<CharacterCollection, String> {

}
