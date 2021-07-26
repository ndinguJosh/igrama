package code.ndingujosh.igrama.data.entity;

import code.ndingujosh.igrama.data.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class SentenceType extends AbstractEntity {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String structure;

    @NotNull
    @NotEmpty
    private String example;

    @ManyToMany
    @JoinTable(
            name = "sentence_type_grammar_concept",
            joinColumns = @JoinColumn(name = "sentence_type_id"),
            inverseJoinColumns = @JoinColumn(name = "grammar_concept_id"))
    private List<GrammarConcept> grammarConcepts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public List<GrammarConcept> getGrammarConcepts() {
        return grammarConcepts;
    }

    public void setGrammarConcepts(List<GrammarConcept> grammarConcepts) {
        this.grammarConcepts = grammarConcepts;
    }
}
