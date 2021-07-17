package com.tupurpcheung.java.gof.chain;

public interface Filter {
    void doFilter(Request request, Response response, FilterChain chain);
}
