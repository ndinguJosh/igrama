package co.za.ndingujosh.igrama.data.entity;

import co.za.ndingujosh.igrama.data.AbstractEntity;
import javax.persistence.Entity;

@Entity
public class Noun extends AbstractEntity {

    private String nounPrefix;
    private String root;
    private Integer nounClass;
    private String translations;
    private boolean isPlural;

    public String getNounPrefix() {
        return nounPrefix;
    }
    public void setNounPrefix(String nounPrefix) {
        this.nounPrefix = nounPrefix;
    }
    public String getRoot() {
        return root;
    }
    public void setRoot(String root) {
        this.root = root;
    }
    public Integer getNounClass() {
        return nounClass;
    }
    public void setNounClass(Integer nounClass) {
        this.nounClass = nounClass;
    }
    public String getTranslations() {
        return translations;
    }
    public void setTranslations(String translations) {
        this.translations = translations;
    }
    public boolean isIsPlural() {
        return isPlural;
    }
    public void setIsPlural(boolean isPlural) {
        this.isPlural = isPlural;
    }

}
