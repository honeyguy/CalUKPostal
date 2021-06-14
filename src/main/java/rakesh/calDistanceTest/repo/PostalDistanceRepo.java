package rakesh.calDistanceTest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import rakesh.calDistanceTest.model.Postaloutcode;

public interface PostalDistanceRepo extends JpaRepository<Postaloutcode, Long> {
}
