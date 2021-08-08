package code.ndingujosh.igrama.data.entity;

import code.ndingujosh.igrama.data.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Verb extends AbstractEntity {

    private String activeRoot;

    private String passiveRoot;

    @Column(name = "latent_i")
    private boolean latentI;

    @NotNull
    @NotEmpty
    @OneToMany(mappedBy = "verb")
    private List<VerbTranslation> activeTranslation;

    @NotNull
    @NotEmpty
    @OneToMany(mappedBy = "verb")
    private List<VerbTranslation> passiveTranslation;

    @OneToMany(mappedBy = "verb")
    private List<ActiveNounVerbPossibility> activeNounVerbPossibility;

    @OneToMany(mappedBy = "verb")
    private List<PassiveNounVerbPossibility> passiveNounVerbPossibility;

    public String getActiveRoot() {
        return activeRoot;
    }

    public void setActiveRoot(String activeRoot) {
        this.activeRoot = activeRoot;
    }

    public String getPassiveRoot() {
        return passiveRoot;
    }

    public void setPassiveRoot(String passiveRoot) {
        this.passiveRoot = passiveRoot;
    }

    public boolean isLatentI() {
        return latentI;
    }

    public void setLatentI(boolean latentI) {
        this.latentI = latentI;
    }

    public List<VerbTranslation> getActiveTranslation() {
        return activeTranslation;
    }

    public void setActiveTranslation(List<VerbTranslation> activeEnglishTranslation) {
        this.activeTranslation = activeEnglishTranslation;
    }

    public List<VerbTranslation> getPassiveTranslation() {
        return passiveTranslation;
    }

    public void setPassiveTranslation(List<VerbTranslation> passiveEnglishTranslation) {
        this.passiveTranslation = passiveEnglishTranslation;
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
