package rakesh.test.calDistanceTest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import rakesh.test.calDistanceTest.model.Postaloutcode;

import java.util.Optional;

public interface PostalDistanceRepo extends JpaRepository<Postaloutcode, Long> {
}
