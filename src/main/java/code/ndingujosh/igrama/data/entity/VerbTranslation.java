package code.ndingujosh.igrama.data.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class VerbTranslation extends Translation {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "verb_id")
    public Verb verb;

    public Verb getVerb() {
        return verb;
    }

    public void setVerb(Verb verb) {
        this.verb = verb;
    }
}
