package com.multiverse.Snipper.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @NotEmpty(message = "User name cannot be empty")
  @NonNull
  @Column(name = "name")
  private String name;

  @NotEmpty(message = "User password cannot be empty")
  @NonNull
  @Column(name = "password")
  private String password;
}
