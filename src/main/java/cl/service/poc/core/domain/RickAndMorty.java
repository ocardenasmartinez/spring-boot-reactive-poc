package cl.service.poc.core.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
public class RickAndMorty {

    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private RickAndMortyOrigin origin;
    private RickAndMortyLocation location;
    private String image;
    private List<String> episode;
    private String url;
    private Date created;

    @Override
    public boolean equals(Object o) {
        var rickAndMortyDTO = (RickAndMorty)o;
        return Objects.equals(rickAndMortyDTO.getId(), this.getId());
    }

}

