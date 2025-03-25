package com.multiverse.Snipper.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Table(name = "snippet")
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Snippet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @NotEmpty(message = "Code snippet must have a programming language")
  @NonNull
  @Column(name = "language")
  private String language;

  @NotEmpty(message = "Code snippet cannot be blank")
  @NonNull
  @Column(name = "content", columnDefinition = "TEXT")
  private String content;
}
