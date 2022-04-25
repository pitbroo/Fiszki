package com.example.fiszkibackend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "words_pl")
@NoArgsConstructor
@Getter
@Setter
public class WordPl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPl;
    private String value;

    @OneToMany(mappedBy = "wordPl", cascade = CascadeType.ALL)
    private Set<WordTranslate> wordTranslates = new HashSet<>();

    @Override
    public String toString() {
        return "WordPl{" +
                "idPl=" + idPl +
                ", value='" + value + '\'' +
                ", wordTranslates=" + wordTranslates +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordPl wordPl = (WordPl) o;
        return Objects.equals(idPl, wordPl.idPl) && Objects.equals(value, wordPl.value) && Objects.equals(wordTranslates, wordPl.wordTranslates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPl, value, wordTranslates);
    }
}
