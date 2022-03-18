package cl.service.poc.infra.secundary.dao.collections;

import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Getter
public abstract class BaseCollection {

    @Id
    private String id;
    private final Date modifiedAt = Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));

}



