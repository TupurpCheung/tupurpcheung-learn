package org.tupurpcheung.learn.jdk.gof.chain;

public interface Filter {
    void doFilter(Request request, Response response, FilterChain chain);
}
