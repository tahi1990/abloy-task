package com.abloy.task.service;

import com.abloy.task.service.IMovieService.ServiceName;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Component;

/**
 * Movie Service Factory based on Strategy pattern
 *
 * @author tahi1990
 */
@Component
public class MovieServiceFactory {

  private Map<ServiceName, IMovieService> services;

  public MovieServiceFactory(Set<IMovieService> serviceSet) {
    createService(serviceSet);
  }

  public IMovieService findService(ServiceName serviceName) {
    return services.get(serviceName);
  }

  private void createService(Set<IMovieService> serviceSet) {
    services = new HashMap<>();
    serviceSet.forEach(
        service -> services.put(service.getServiceName(), service));
  }

}
