package com.walid.gw.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wmoustafa
 */
@Controller
@RequestMapping("/")
public class SearchController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping()
    public String home(@RequestParam(value = "keywords", defaultValue = "java") String keywords,
                       Model model) {
        logger.debug("Received a search for keywords \"{}\"", keywords);
        List<String> tweets = new ArrayList<>();
        tweets.add("Java is cool");
        tweets.add("Java is old");
        model.addAttribute("tweets", tweets);
        return "home";
    }
}
