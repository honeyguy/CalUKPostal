package rakesh.test.calDistanceTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rakesh.test.calDistanceTest.VO.PostalDistanceVO;
import rakesh.test.calDistanceTest.exception.PostalNotFoundException;
import rakesh.test.calDistanceTest.model.Postaloutcode;
import rakesh.test.calDistanceTest.repo.PostalDistanceRepo;

import javax.transaction.Transactional;

@Service
@Transactional
public class PostalDistanceService {
    private final PostalDistanceRepo postalDistanceRepo;
    private final static double EARTH_RADIUS = 6371;

    @Autowired
    public PostalDistanceService(PostalDistanceRepo postalDistanceRepo) {
        this.postalDistanceRepo = postalDistanceRepo;
    }

    public PostalDistanceVO findDistanceByPostal(String postal1, String postal2) {

        Postaloutcode post1 =
                postalDistanceRepo.findAll().stream().filter(x -> x.getPostcode().equalsIgnoreCase(postal1)).findFirst()
                        .orElseThrow(() -> new PostalNotFoundException("Postal1  " + postal1 + " was not found"));

        Postaloutcode post2 =
                postalDistanceRepo.findAll().stream().filter(x -> x.getPostcode().equalsIgnoreCase(postal2)).findFirst()
                .orElseThrow(()-> new PostalNotFoundException("Postal2  " + postal2 + " was not found"));

        double calDistanceByPostal = calculateDistance(post1.getLatitude(), post1.getLongitude(),
                post2.getLatitude(), post2.getLongitude());

        String distanceUnit = Double.toString(calDistanceByPostal)  + " km";

        PostalDistanceVO postalDistanceVO = new PostalDistanceVO(post1, post2, distanceUnit);

        System.out.println("calDistanceByPostal="+ calDistanceByPostal);

        return postalDistanceVO;
    }

    private double calculateDistance(double latitude, double longitude, double latitude2, double
            longitude2) {
        // Using Haversine formula! See Wikipedia;
        double lon1Radians = Math.toRadians(longitude);
        double lon2Radians = Math.toRadians(longitude2);
        double lat1Radians = Math.toRadians(latitude);
        double lat2Radians = Math.toRadians(latitude2);
        double a = haversine(lat1Radians, lat2Radians)
                + Math.cos(lat1Radians) * Math.cos(lat2Radians) * haversine(lon1Radians, lon2Radians);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return (EARTH_RADIUS * c);
    }
    private double haversine(double deg1, double deg2) {
        return square(Math.sin((deg1 - deg2) / 2.0));
    }
    private double square(double x) {
        return x * x;
    }

}
