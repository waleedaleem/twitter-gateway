package com.walid.gw.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.walid.gw.entity.Tweet;

import twitter4j.Status;

/**
 * extracts a {@link Tweet} entity from {@link Status}
 * 
 * @author wmoustafa
 */
@Component
public class TweetExtractor {

    public List<Tweet> extract(List<Status> statusList) {
        if (statusList != null) {
            return statusList.stream().map(Tweet::new).sorted(
                    Comparator.comparing(Tweet::getRetweetCount).reversed()).collect(
                            Collectors.toList());
        }
        return Collections.emptyList();
    }
}
