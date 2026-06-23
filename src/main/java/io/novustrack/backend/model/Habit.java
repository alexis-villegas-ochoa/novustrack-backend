package io.novustrack.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "habits")
@NoArgsConstructor
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @OneToMany (mappedBy = "habit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HabitRecord> records = new ArrayList<>();

    public Habit (String name, String description){
        this.name = name;
        this.description = description;
    }
}