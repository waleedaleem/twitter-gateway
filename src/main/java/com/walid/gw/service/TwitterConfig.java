package com.walid.gw.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wmoustafa
 */
@Component
@ConfigurationProperties("twitter")
public class TwitterConfig {

    private String pageCount;
    private String pageSize;

    public String getPageCount() {
        return pageCount;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }
}
