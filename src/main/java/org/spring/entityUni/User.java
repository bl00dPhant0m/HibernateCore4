package org.spring.entityUni;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.spring.entityUni.Diary;

import java.time.LocalDate;

@Data

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique=true ,nullable=false, length = 50,name = "name")
    private String name;

    @Column(nullable=false)
    private LocalDate dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "diary_id")
    private Diary diary;

    public User(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public User(String name, LocalDate dateOfBirth, Diary diary) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.diary = diary;
    }
}
