package com.walid.gw.service;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wmoustafa
 */
@Component
public class TwitterRoute extends RouteBuilder {

    public static final String ROUTE_ID = "twitterRoute";
    public static final String DIRECT_URI = "direct:twitter";

    @Autowired
    TwitterConfig twitterConfig;

    @Autowired
    TweetExtractor tweetExtractor;

    @Override
    public void configure() {
        //@formatter:off
        StringBuilder uriPattern = new StringBuilder("twitter-search:${header.keywords}")
            .append("?filterOld=false")
            .append("&numberOfPages=").append(twitterConfig.getPageCount())
            .append("&count=").append(twitterConfig.getPageSize());
        
        from(DIRECT_URI)
            .routeId(ROUTE_ID)
            .log(String.format("Searching twitter for \"%s\"!", "${header.keywords}"))
            .toD(uriPattern.toString())
            .bean(tweetExtractor);
        //@formatter:on
    }
}
