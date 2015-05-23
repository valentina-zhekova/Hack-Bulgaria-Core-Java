package com.hackbulgaria.corejava;

import java.net.URI;

public class CrawlLink implements Runnable {
    public void run() {
        URI result = crawl(asUri, needle);
    }
}
