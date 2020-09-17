package com.walid.gw.controller;

import static com.walid.gw.service.TwitterRoute.DIRECT_URI;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private ProducerTemplate producer;

    @Autowired
    public void setProducerTemplate(ProducerTemplate producerTemplate) {
        this.producer = producerTemplate;
    }

    @GetMapping()
    public String home(@RequestParam(value = "keywords", required = false) String keywords,
                       Model model) {
        logger.debug("Received a search for keywords \"{}\"", keywords);
        List<String> tweets = new ArrayList<>();
        producer.sendBodyAndHeader(DIRECT_URI, "SEARCH", "keywords", keywords);
        if (Objects.nonNull(keywords)) {
            tweets.add(keywords + " is cool");
            tweets.add(keywords + " is old");
        }
        model.addAttribute("tweets", tweets);
        return "home";
    }
}
