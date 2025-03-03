package example.micronaut.domain;

import io.micronaut.data.annotation.*;
import io.micronaut.data.annotation.sql.ColumnTransformer;
import lombok.Data;

import java.time.Duration;

import static io.micronaut.data.annotation.GeneratedValue.Type.SEQUENCE;

@MappedEntity
@Data
public class Rider {
    @Id
    @GeneratedValue(value = SEQUENCE, ref = "rider_id_seq")
    private int id;

    private String name;

    @ColumnTransformer(read = "to_char(finish_time, 'PTHH24HMIM')")
    Duration finishTime;
}
