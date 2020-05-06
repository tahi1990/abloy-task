package com.abloy.task.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue
  private Long id;

  @Column
  private String email;

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
      cascade = CascadeType.ALL)
  private Set<Movie> moviePreferences;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Set<Movie> getMoviePreferences() {
    return moviePreferences;
  }

  public void setMoviePreferences(Set<Movie> moviePreferences) {
    this.moviePreferences = moviePreferences;
  }
}
