package com.github.nicholas1991.onlineshop.storefront.webapi.configurations;

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Scope
import org.springframework.beans.factory.InjectionPoint
import org.slf4j.LoggerFactory
import org.slf4j.Logger

@Configuration
class LoggerConfiguration {
  
  @Bean
  @Scope("prototype")
  fun logger(injectionPoint: InjectionPoint): Logger {
    if (injectionPoint.getMethodParameter() != null) {
      return LoggerFactory.getLogger(injectionPoint.getMethodParameter()!!.getContainingClass());
    }
    else if (injectionPoint.getField() != null) {
      return LoggerFactory.getLogger(injectionPoint.getField()!!.getDeclaringClass());
    }
    throw IllegalArgumentException();
  }

}