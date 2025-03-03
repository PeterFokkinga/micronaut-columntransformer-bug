package example.micronaut;

import example.micronaut.domain.Report;
import example.micronaut.domain.Rider;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
public class ReportRepositoryTest {
    @Inject
    RiderRepository riderRepository;
    @Inject
    ReportRepository reportRepository;

    @Test
    void failingTest() {
        var rider = new Rider();
        rider.setName("Peter");
        rider.setFinishTime(Duration.ofHours(3).plusMinutes(45));
        var savedRider = riderRepository.save(rider);

        var report = new Report();
        report.setRider(rider);
        report.setMessage("Hello, World!");
        var savedReport = reportRepository.save(report);

        var check = reportRepository.findById(savedReport.getId());
        assertTrue(check.isPresent());
        assertEquals(rider.getFinishTime(), check.get().getRider().getFinishTime());
    }
}
