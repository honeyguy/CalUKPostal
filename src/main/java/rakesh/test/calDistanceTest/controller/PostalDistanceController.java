package rakesh.test.calDistanceTest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rakesh.test.calDistanceTest.VO.PostalDistanceVO;
import rakesh.test.calDistanceTest.model.Postaloutcode;
import rakesh.test.calDistanceTest.service.PostalDistanceService;

import java.util.List;

@RestController
@RequestMapping("/postal")
public class PostalDistanceController {
    private final PostalDistanceService postalDistanceService;

    public PostalDistanceController(PostalDistanceService postalDistanceService) {
        this.postalDistanceService = postalDistanceService;
    }

    @GetMapping("/find/{postal1}/{postal2}")
    public ResponseEntity<PostalDistanceVO> getDistanceByPostal (@PathVariable("postal1") String postal1,
                                                              @PathVariable("postal2") String postal2) {
        PostalDistanceVO postalDistanceVO = postalDistanceService.findDistanceByPostal(postal1, postal2);
        return new ResponseEntity<>(postalDistanceVO, HttpStatus.OK);
    }


}
