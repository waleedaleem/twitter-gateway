package com.walid.gw.controller;

import static com.walid.gw.service.TwitterRoute.DIRECT_URI;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import twitter4j.Status;

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

        if (Objects.nonNull(keywords)) {
            List<Status> tweets = producer.requestBodyAndHeader(
                    DIRECT_URI, "SEARCH", "keywords", keywords, List.class);
            if (Objects.nonNull(tweets) && !tweets.isEmpty()) {
                List<String> tweetsAsText = tweets.stream().map(Status::getText).collect(
                        Collectors.toList());
                model.addAttribute("tweets", tweets);
            }
        }
        return "home";
    }
}
