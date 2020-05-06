package com.abloy.task.service.impl;

import com.abloy.task.model.Movie;
import com.abloy.task.service.IMovieService;
import java.util.List;

public class NetflixService implements IMovieService {

  @Override
  public List<Movie> suggest(String genre) {
    // TODO: Implement service API here
    return null;
  }

  @Override
  public ServiceName getServiceName() {
    return ServiceName.Netflix;
  }
}
