package com.multiverse.Snipper.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "snippet")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Snippet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "content")
  private String content;

  @ManyToOne(optional = false)
  @JoinColumn(referencedColumnName = "id", name = "user_id")
  private User user;
}
