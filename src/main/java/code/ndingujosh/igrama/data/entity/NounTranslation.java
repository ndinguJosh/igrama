package code.ndingujosh.igrama.data.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class NounTranslation extends Translation {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "noun_id")
    private Noun noun;

    public Noun getNoun() {
        return noun;
    }

    public void setNoun(Noun noun) {
        this.noun = noun;
    }
}
