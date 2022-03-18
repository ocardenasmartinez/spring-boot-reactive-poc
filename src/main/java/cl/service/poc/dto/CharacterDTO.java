package cl.service.poc.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
public class CharacterDTO {

    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private Integer episodeCount;
    private OriginDTO origin;

    @Override
    public boolean equals(Object o) {
        var characterDTO = (CharacterDTO)o;
        return Objects.equals(this.getId(), characterDTO.getId());
    }

}
