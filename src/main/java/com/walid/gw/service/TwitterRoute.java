package com.walid.gw.service;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author wmoustafa
 */
@Component
public class TwitterRoute extends RouteBuilder {

    public static final String ROUTE_ID = "twitterRoute";
    public static final String DIRECT_URI = "direct:twitter";

    @Override
    public void configure() {
        String uriPattern = "twitter-search:${header.keywords}";
        //@formatter:off
        from(DIRECT_URI)
            .routeId(ROUTE_ID)
            .log(String.format("Searching twitter for \"%s\"!", "${header.keywords}"))
            .toD(uriPattern);
        //@formatter:on
    }
}
