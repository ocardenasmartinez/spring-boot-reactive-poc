package cl.mobdev.rickandmorty.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OriginDTO {

    private String name;
    private String url;
    private String dimension;
    private List<String> residents;

}
