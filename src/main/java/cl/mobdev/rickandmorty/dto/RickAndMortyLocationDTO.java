package cl.mobdev.rickandmorty.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RickAndMortyLocationDTO {

    private String name;
    private String type;
    private String dimension;
    private List<String> residents;
    private String url;
    private Date created;

}
