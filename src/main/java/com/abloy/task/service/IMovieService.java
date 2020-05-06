package com.abloy.task.service;

import com.abloy.task.model.Movie;
import java.util.List;

public interface IMovieService {

  enum ServiceName {
    MyService,
    Netflix,
    Imdb
  }

  List<Movie> suggest(String genre);

  ServiceName getServiceName();

}


