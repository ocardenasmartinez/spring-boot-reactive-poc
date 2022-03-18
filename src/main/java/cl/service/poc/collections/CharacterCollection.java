package cl.service.poc.collections;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(value = "Character")
@EqualsAndHashCode(callSuper = true)
public class CharacterCollection extends BaseCollection {

    private Integer idCharacter;
    private String name;
    private String status;
    private String species;
    private String type;
    private Integer episodeCount;

}
