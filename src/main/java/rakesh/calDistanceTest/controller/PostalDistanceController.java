package rakesh.calDistanceTest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rakesh.calDistanceTest.VO.PostalDistanceVO;
import rakesh.calDistanceTest.service.PostalDistanceService;

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
