package com.sinlov.my.test;

import java.net.URI;

/**
 * <pre>
 *     sinlov
 *
 *     /\__/\
 *    /`    '\
 *  ≈≈≈ 0  0 ≈≈≈ Hello world!
 *    \  --  /
 *   /        \
 *  /          \
 * |            |
 *  \  ||  ||  /
 *   \_oo__oo_/≡≡≡≡≡≡≡≡o
 *
 * </pre>
 * Created by sinlov on 16/8/26.
 */
public class URLTest {
    public static void main(String[] args) {
        String serverUrl = "10.8.230.246:31313/echo";
        final URI url = URI.create("ws://" + serverUrl);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("url = " + url.toString());
                System.out.println("url.getScheme = " + url.getScheme());
                System.out.println("url.getHost = " + url.getHost());
                System.out.println("url.getPort = " + url.getPort());
                System.out.println("url.getPort = " + url.getPath());
            }
        }).start();
    }
}
