package org.cloud.learn;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tappe on 6/11/2017.
 */

@RestController
public class Tesc {


    @RequestMapping("/dd")
    public String dd() {
        return "hello start";
    }
}
