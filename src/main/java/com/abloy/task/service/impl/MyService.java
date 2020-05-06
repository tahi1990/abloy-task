package com.abloy.task.service.impl;

import com.abloy.task.model.Movie;
import com.abloy.task.service.IMovieService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service
public class MyService implements IMovieService {

  public static final Logger LOGGER = LogManager.getLogger(MyService.class);

  @Override
  public List<Movie> suggest(long userId) {
    List<Movie> movies = new ArrayList<>();
    try {
      File file = ResourceUtils.getFile("classpath:movies.json");
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode rootNode = objectMapper.readTree(file);
      if(rootNode.isArray()) {
        for(JsonNode node: rootNode) {
          Movie movie = new Movie();
          movie.setId(node.get("id").asLong());
          movie.setName(node.get("title").asText());
          movie.setImg(node.get("posterurl").asText());

          movies.add(movie);
        }
      }
    } catch (IOException e) {
      LOGGER.error(e);
    }

    return movies;
  }

  @Override
  public ServiceName getServiceName() {
    return ServiceName.MyService;
  }
}
