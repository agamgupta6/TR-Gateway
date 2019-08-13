package com.tcs.gateway;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class RedirectionFilter extends ZuulFilter {

@Override
public String filterType() {
   return "pre";
}

@Override
public int filterOrder() {
   return 2;
}

@Override
public boolean shouldFilter() {
  return true;
}

@Override
public Object run() {
  RequestContext ctx = RequestContext.getCurrentContext();
  HttpServletRequest request = ctx.getRequest();
  String header = request.getHeader("YOUR_HEADER_PARAM");

  ctx.addZuulRequestHeader("Authorization",  "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfVVNFUiIsImV4cCI6MTU3NDg3NDk5NX0.2yYV4YWNBngPfRfPqmJec8MR5yRRKoa9rKRsypyv6cjUo5KRlD5TYhiM_R_Sfk_deENaHzsS1dAn2l256hkrYA");

  return null;
 }
}