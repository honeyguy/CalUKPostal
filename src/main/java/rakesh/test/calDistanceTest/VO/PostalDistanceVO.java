package rakesh.test.calDistanceTest.VO;

import lombok.Data;
import rakesh.test.calDistanceTest.model.Postaloutcode;

@Data
public class PostalDistanceVO {
    private Postaloutcode postcode1;
    private Postaloutcode postcode2;
    private String distanceUnit;

    public PostalDistanceVO(Postaloutcode postcode1, Postaloutcode postcode2, String distanceUnit) {
        this.postcode1 = postcode1;
        this.postcode2 = postcode2;
        this.distanceUnit = distanceUnit;
    }
}
