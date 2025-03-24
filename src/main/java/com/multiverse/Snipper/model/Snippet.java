package com.multiverse.Snipper.model;

import jakarta.persistence.*;
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

  @NonNull
  @Column(name = "content")
  private String content;

}
