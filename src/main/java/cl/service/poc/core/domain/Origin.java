package cl.service.poc.core.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Origin {

    private String name;
    private String url;
    private String dimension;
    private List<String> residents;

}
