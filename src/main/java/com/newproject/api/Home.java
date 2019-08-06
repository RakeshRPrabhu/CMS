package com.newproject.api;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class Home {

    @GetMapping
    public String Home()
    {
        return "Application Works" +new Date();
    }
}
