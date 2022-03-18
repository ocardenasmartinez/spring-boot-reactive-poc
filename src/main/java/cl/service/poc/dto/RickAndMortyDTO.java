package cl.service.poc.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
public class RickAndMortyDTO {

    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private RickAndMortyOriginDTO origin;
    private RickAndMortyLocationDTO location;
    private String image;
    private List<String> episode;
    private String url;
    private Date created;

    @Override
    public boolean equals(Object o) {
        var rickAndMortyDTO = (RickAndMortyDTO)o;
        return Objects.equals(rickAndMortyDTO.getId(), this.getId());
    }

}

