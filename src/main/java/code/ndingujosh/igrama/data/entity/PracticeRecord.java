package code.ndingujosh.igrama.data.entity;

import code.ndingujosh.igrama.data.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class PracticeRecord extends AbstractEntity {

    @NotNull
    @NotEmpty
    private LocalDateTime dateTimeCreated;

    @OneToOne
    private SentenceType sentenceType;

    @OneToOne
    private GrammarConcept grammarConcept;

    @OneToOne
    private NounClass nounClass;

    private boolean correct;

    public GrammarConcept getGrammarConcept() {
        return grammarConcept;
    }

    public void setGrammarConcept(GrammarConcept grammarConcept) {
        this.grammarConcept = grammarConcept;
    }

    public NounClass getNounClass() {
        return nounClass;
    }

    public void setNounClass(NounClass nounClass) {
        this.nounClass = nounClass;
    }

    public SentenceType getSentenceType() {
        return sentenceType;
    }

    public void setSentenceType(SentenceType sentenceType) {
        this.sentenceType = sentenceType;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
