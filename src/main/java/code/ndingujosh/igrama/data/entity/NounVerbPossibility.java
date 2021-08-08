package code.ndingujosh.igrama.data.entity;

import code.ndingujosh.igrama.data.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class NounVerbPossibility extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "noun_id")
    private Noun noun;

    @ManyToOne
    @JoinColumn(name = "verb_id")
    private Verb verb;
}
