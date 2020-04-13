package com.b1a9idps.clotheshouse.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
public class SinglePageController {
    @GetMapping("/**/{path:[^.]*}")
    fun index(): String {
        return "forward:/index.html";
    }
}
