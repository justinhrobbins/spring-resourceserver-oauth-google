package org.test.spring.resourceserver.oauth.google;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("secured")
public class SecuredController {
    
    @GetMapping
    public String getSecured() {        
        return "This is a SECURED resource";
    }
}
