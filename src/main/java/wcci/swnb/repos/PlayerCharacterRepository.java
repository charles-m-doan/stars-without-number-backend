package wcci.swnb.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import wcci.swnb.entities.PlayerCharacter;

@Repository
public interface PlayerCharacterRepository extends CrudRepository<PlayerCharacter, Long> {

}
