package code.ndingujosh.igrama.data.entity;

import code.ndingujosh.igrama.data.AbstractEntity;

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

    private boolean latentI;

    @ElementCollection
    @NotNull
    @NotEmpty
    private List<String> activeEnglishTranslations;

    @ElementCollection
    @NotNull
    @NotEmpty
    private List<String> passiveEnglishTranslations;

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

    public List<String> getActiveEnglishTranslations() {
        return activeEnglishTranslations;
    }

    public void setActiveEnglishTranslations(List<String> activeEnglishTranslations) {
        this.activeEnglishTranslations = activeEnglishTranslations;
    }

    public List<String> getPassiveEnglishTranslations() {
        return passiveEnglishTranslations;
    }

    public void setPassiveEnglishTranslations(List<String> passiveEnglishTranslations) {
        this.passiveEnglishTranslations = passiveEnglishTranslations;
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
