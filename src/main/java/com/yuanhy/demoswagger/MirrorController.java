package com.yuanhy.demoswagger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuanhy
 * @date 2020-12-19 18:39
 */
@RestController
public class MirrorController {
    @GetMapping("/mirror")
    public String mirror(){
        return "mirror";
    }
}
