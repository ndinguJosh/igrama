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

    @ManyToOne
    @JoinColumn(name = "prefix_id")
    private NounPrefix prefix;

    @NotNull
    @NotEmpty
    private String root;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "noun_class_id")
    private NounClass nounClass;

    @NotNull
    @NotEmpty
    @OneToMany(mappedBy = "noun")
    private List<NounTranslation> translation;

    @NotNull
    @NotEmpty
    private LocalDateTime dateTimeCreated;

    @ManyToMany
    private List<Noun> possessors;

    @ManyToMany(mappedBy = "possessors")
    private List<Noun> possessions;

    @OneToMany(mappedBy = "noun")
    private List<ActiveNounVerbPossibility> activeNounVerbPossibility;

    @OneToMany(mappedBy = "noun")
    private List<PassiveNounVerbPossibility> passiveNounVerbPossibility;

    public NounPrefix getPrefix() {
        return prefix;
    }

    public void setPrefix(NounPrefix prefix) {
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

    public List<NounTranslation> getTranslation() {
        return translation;
    }

    public void setTranslation(List<NounTranslation> englishTranslation) {
        this.translation = englishTranslation;
    }

    public LocalDateTime getDateTimeCreated() {
        return dateTimeCreated;
    }

    public void setDateTimeCreated(LocalDateTime dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }

    public List<Noun> getPossessors() {
        return possessors;
    }

    public void setPossessors(List<Noun> possessors) {
        this.possessors = possessors;
    }

    public List<Noun> getPossessions() {
        return possessions;
    }

    public void setPossessions(List<Noun> possessions) {
        this.possessions = possessions;
    }

    public void addPossessor(Noun possessor) {
        this.possessors.add(possessor);
        possessor.possessions.add(this);
    }

    public void addPossession(Noun possession) {
        this.possessions.add(possession);
        possession.possessors.add(this);
    }

    public List<ActiveNounVerbPossibility> getActiveNounVerbPossibility() {
        return activeNounVerbPossibility;
    }

    public void setActiveNounVerbPossibility(List<ActiveNounVerbPossibility> activeNounVerbPossibility) {
        this.activeNounVerbPossibility = activeNounVerbPossibility;
    }

    public List<PassiveNounVerbPossibility> getPassiveNounVerbPossibility() {
        return passiveNounVerbPossibility;
    }

    public void setPassiveNounVerbPossibility(List<PassiveNounVerbPossibility> passiveNounVerbPossibility) {
        this.passiveNounVerbPossibility = passiveNounVerbPossibility;
    }
}
