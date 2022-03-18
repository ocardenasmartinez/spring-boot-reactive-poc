package cl.service.poc.infra.secundary.dao;

import cl.service.poc.infra.secundary.dao.collections.CharacterCollection;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterReactiveRepository extends ReactiveMongoRepository<CharacterCollection, String> {

}
