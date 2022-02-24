package org.test.spring.resourceserver.oauth.google;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("secured")
public class SecuredController {
    
    @GetMapping
    public String getSecured() {        
        return "This is a response from a SECURED resource";
    }
}
