package com.iyurenko.server.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author iyurenko
 * @since 16.03.16.
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @RequestMapping("/me")
    public Map user() {
        Map<String, String> map = new HashMap<>();
        map.put("id", "45retr534gh");
        map.put("name", "Super customer");
        return map;
    }

}
