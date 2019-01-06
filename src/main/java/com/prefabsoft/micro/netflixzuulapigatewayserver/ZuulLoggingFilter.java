package com.prefabsoft.micro.netflixzuulapigatewayserver;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class ZuulLoggingFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre"; //When do we want to filer?
    }

    @Override
    public int filterOrder() {
        return 1; //order when using multiple
    }

    @Override
    public boolean shouldFilter() {
        return true; //to enable/disable at runtime
    }

    @Override
    public Object run()/* throws ZuulException*/ {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();

        /** Try:
         *      http://localhost:8765/currency-exchange-service/currency-exchange/from/USD/to/EUR
         *      http://localhost:8765/currency-conversion-service/currency-converter/from/EUR/to/USD/quantity/100
         */
        log.info("request -> {} request uri -> {}", request, request.getRequestURI());

        return null;
    }

}
