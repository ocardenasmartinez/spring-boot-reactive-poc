package cl.service.poc.core.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
public class Character {

    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private Integer episodeCount;
    private Origin origin;

    @Override
    public boolean equals(Object o) {
        var characterDTO = (Character)o;
        return Objects.equals(this.getId(), characterDTO.getId());
    }

}
