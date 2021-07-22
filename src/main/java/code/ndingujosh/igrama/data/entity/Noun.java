package code.ndingujosh.igrama.data.entity;

import code.ndingujosh.igrama.data.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "noun")
public class Noun extends AbstractEntity implements Cloneable {

    @NotNull
    @NotEmpty
    private String prefix;

    @NotNull
    @NotEmpty
    private String root;

    @ManyToOne
    @JoinColumn(name = "noun_class_id", nullable = false)
    private NounClass nounClass;

    private String englishTranslation;

    @NotNull
    @NotEmpty
    private LocalDateTime dateTimeCreated;

    @ManyToMany
    @JoinTable(
            name = "active_noun_verb_possibilities",
            joinColumns = @JoinColumn(name = "noun"),
            inverseJoinColumns = @JoinColumn(name = "verb"))
    private List<Verb> activeVerbs;

    @ManyToMany
    @JoinTable(
            name = "passive_noun_verb_possibilities",
            joinColumns = @JoinColumn(name = "noun"),
            inverseJoinColumns = @JoinColumn(name = "verb"))
    private List<Verb> passiveVerbs;

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

    public String getEnglishTranslation() {
        return englishTranslation;
    }

    public void setEnglishTranslation(String englishTranslation) {
        this.englishTranslation = englishTranslation;
    }

    public LocalDateTime getDateTimeCreated() {
        return dateTimeCreated;
    }

    public void setDateTimeCreated(LocalDateTime dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }

    public List<Verb> getActiveVerbs() {
        return activeVerbs;
    }

    public void setActiveVerbs(List<Verb> activeVerbs) {
        this.activeVerbs = activeVerbs;
    }

    public List<Verb> getPassiveVerbs() {
        return passiveVerbs;
    }

    public void setPassiveVerbs(List<Verb> passiveVerbs) {
        this.passiveVerbs = passiveVerbs;
    }
}
