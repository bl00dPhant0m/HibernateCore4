package org.spring.entityUni;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.spring.entityUni.User;

@Entity
@AllArgsConstructor
@Table(name = "diarys")
@Data
@NoArgsConstructor
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nameOfSchool;
    @Column(nullable = false)
    private String nameOfClas;

    public Diary(String nameOfSchool, String nameOfClas) {
        this.nameOfSchool = nameOfSchool;
        this.nameOfClas = nameOfClas;
    }

}
