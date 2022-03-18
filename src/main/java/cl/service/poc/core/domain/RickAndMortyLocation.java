package cl.service.poc.core.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RickAndMortyLocation {

    private String name;
    private String type;
    private String dimension;
    private List<String> residents;
    private String url;
    private Date created;

}
