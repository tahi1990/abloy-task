package com.abloy.task.controller;

import com.abloy.task.model.Movie;
import com.abloy.task.service.IMovieService;
import com.abloy.task.service.IMovieService.ServiceName;
import com.abloy.task.service.MovieServiceFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

  private MovieServiceFactory serviceFactory;

  MovieController(@Autowired MovieServiceFactory serviceFactory) {
    this.serviceFactory = serviceFactory;
  }

  @GetMapping("/suggest")
  public ResponseEntity<List<Movie>> suggest(@RequestParam String genre) {
    IMovieService myService = serviceFactory.findService(ServiceName.MyService);

    return new ResponseEntity<>(myService.suggest(genre), HttpStatus.OK);
  }

}
