package code.ndingujosh.igrama.data.entity;

import code.ndingujosh.igrama.data.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Verb extends AbstractEntity {

    private String activeRoot;

    private String passiveRoot;

    @Column(name = "latent_i")
    private boolean latentI;

    @ElementCollection
    @NotNull
    @NotEmpty
    private List<String> activeEnglishTranslation;

    @ElementCollection
    @NotNull
    @NotEmpty
    private List<String> passiveEnglishTranslation;

    @ManyToMany(mappedBy = "activeVerbs")
    private List<Noun> performers;

    @ManyToMany(mappedBy = "passiveVerbs")
    private List<Noun> recipients;

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

    public List<String> getActiveEnglishTranslation() {
        return activeEnglishTranslation;
    }

    public void setActiveEnglishTranslation(List<String> activeEnglishTranslation) {
        this.activeEnglishTranslation = activeEnglishTranslation;
    }

    public List<String> getPassiveEnglishTranslation() {
        return passiveEnglishTranslation;
    }

    public void setPassiveEnglishTranslation(List<String> passiveEnglishTranslation) {
        this.passiveEnglishTranslation = passiveEnglishTranslation;
    }

    public List<Noun> getPerformers() {
        return performers;
    }

    public void setPerformers(List<Noun> performers) {
        this.performers = performers;
    }

    public List<Noun> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<Noun> recipients) {
        this.recipients = recipients;
    }
}
