package cl.service.poc.core.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveCharacter {

    private String id;
    private Integer idCharacter;
    private String name;
    private String status;
    private String species;
    private String type;
    private Integer episodeCount;

}
