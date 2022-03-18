package cl.service.poc.infra.secundary.repository;

import cl.service.poc.infra.secundary.collections.CharacterCollection;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterReactiveRepository extends ReactiveMongoRepository<CharacterCollection, String> {

}
