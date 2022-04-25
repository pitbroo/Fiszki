package com.example.fiszkibackend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "words_translate")
@NoArgsConstructor
@Getter
@Setter
public class WordTranslate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTranslate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_eng")
    private WordEng wordEng;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_pl")
    private WordPl wordPl;

    @Override
    public String toString() {
        return "WordTranslate{" +
                "idTranslate=" + idTranslate +
                ", wordEng=" + wordEng +
                ", wordPl=" + wordPl +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordTranslate that = (WordTranslate) o;
        return Objects.equals(idTranslate, that.idTranslate) && Objects.equals(wordEng, that.wordEng) && Objects.equals(wordPl, that.wordPl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTranslate, wordEng, wordPl);
    }
}
