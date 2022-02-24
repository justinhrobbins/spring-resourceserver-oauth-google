package org.test.spring.resourceserver.oauth.google;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("unsecured")
public class UnsecuredController {

    @GetMapping
    public String getUnsecured() {        
        return "This is an UNSECURED resource";
    }
}
