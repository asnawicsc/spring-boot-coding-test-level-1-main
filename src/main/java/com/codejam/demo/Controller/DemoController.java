package com.codejam.demo.Controller;

import com.codejam.demo.Exceptions.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "demo")
public class DemoController {


    @GetMapping(path = "/unit-test")
    ResponseEntity<Integer> getUnitTestResult() throws CustomException {
        return null;
    }

}
