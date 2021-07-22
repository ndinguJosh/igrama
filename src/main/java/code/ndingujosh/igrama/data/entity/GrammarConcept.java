package code.ndingujosh.igrama.data.entity;

import code.ndingujosh.igrama.data.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class GrammarConcept extends AbstractEntity {

    @NotNull
    @NotEmpty
    private String name;

    private String description;

    @ManyToMany(mappedBy = "grammarConcepts")
    private List<SentenceType> sentenceTypes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SentenceType> getSentenceTypes() {
        return sentenceTypes;
    }

    public void setSentenceTypes(List<SentenceType> sentenceTypes) {
        this.sentenceTypes = sentenceTypes;
    }
}
