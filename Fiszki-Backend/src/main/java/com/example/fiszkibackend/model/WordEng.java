package com.example.fiszkibackend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "words_eng")
@NoArgsConstructor
@Getter
@Setter
public class WordEng {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEng;
    private String value;

    @OneToMany(mappedBy = "wordEng")
    private Set<WordTranslate> wordTranslates = new HashSet<>();

    @Override
    public String toString() {
        return "WordEng{" +
                "idEng=" + idEng +
                ", value='" + value + '\'' +
                ", wordTranslates=" + wordTranslates +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordEng wordEng = (WordEng) o;
        return Objects.equals(idEng, wordEng.idEng) && Objects.equals(value, wordEng.value) && Objects.equals(wordTranslates, wordEng.wordTranslates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEng, value, wordTranslates);
    }
}
