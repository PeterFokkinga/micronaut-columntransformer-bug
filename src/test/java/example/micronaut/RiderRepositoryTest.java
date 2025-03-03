package example.micronaut;

import example.micronaut.domain.Rider;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class RiderRepositoryTest {
    @Inject
    RiderRepository riderRepository;

    @Test
    void successfulTest() {
        var rider = new Rider();
        rider.setName("Peter");
        rider.setFinishTime(Duration.ofHours(3).plusMinutes(45));
        var saved = riderRepository.save(rider);

        var check = riderRepository.findById(saved.getId());
        assertTrue(check.isPresent());
        assertEquals(rider.getFinishTime(), check.get().getFinishTime());
    }
}
