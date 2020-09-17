package com.walid.gw.service;

import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author wmoustafa
 */
@Component
public class TwitterRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("direct:twitter").routeId("twitterRoute").log(
                String.format("Searching twitter for %s!", "${header.q}")).to(
                        ExchangePattern.InOut, "stream:out");
    }
}
