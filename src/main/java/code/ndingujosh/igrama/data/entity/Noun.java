package code.ndingujosh.igrama.data.entity;

import code.ndingujosh.igrama.data.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "nouns")
public class Noun extends AbstractEntity {
    @NotNull
    @NotEmpty
    private String prefix;

    @NotNull
    @NotEmpty
    private String root;

    @ManyToOne
    @JoinColumn(name = "noun_class_id", nullable = false)
    private NounClass nounClass;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public NounClass getNounClass() {
        return nounClass;
    }

    public void setNounClass(NounClass nounClass) {
        this.nounClass = nounClass;
    }
}
