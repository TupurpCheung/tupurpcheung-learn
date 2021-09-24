package org.tupurpcheung.learn.jdk.gof.chain;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter{

    List<Filter> filterList = new ArrayList<>();
    int pos  = 0;

    public FilterChain doAdd(Filter filter){
        filterList.add(filter);
        return this;
    }

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        if(pos == filterList.size()){
            return;
        }
        Filter filter = filterList.get(pos++);
        filter.doFilter(request,response,chain);
    }
}
