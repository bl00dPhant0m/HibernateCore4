package org.spring.entityBi;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Table(name = "diaries")
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


    @ToString.Exclude
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "marks_of_russia", joinColumns = @JoinColumn(name = "diary_id"))
    @Column(name = "grade")
    List<Integer> marksOfRussia = new ArrayList<Integer>();

    @ToString.Exclude
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "marks_of_math", joinColumns = @JoinColumn(name = "diary_id"))
    @Column(name = "grade")
    List<Integer> marksOfMath = new ArrayList<>();

    @ToString.Exclude
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "marks_of_literature", joinColumns = @JoinColumn(name = "diary_id"))
    @Column(name = "grade")
    List<Integer> marksOfLiterature = new ArrayList<>();

    public Diary(String nameOfSchool, String nameOfClas) {
        this.nameOfSchool = nameOfSchool;
        this.nameOfClas = nameOfClas;
    }

    @OneToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;
}
