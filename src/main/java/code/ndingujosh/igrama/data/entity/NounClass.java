package code.ndingujosh.igrama.data.entity;

import code.ndingujosh.igrama.data.AbstractEntity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
public class NounClass extends AbstractEntity {

    @OneToMany(mappedBy = "nounClass")
    private List<Noun> nouns = new LinkedList<>();

    @NotNull
    @NotEmpty
    private String nounClassName;

    @ElementCollection
    @NotEmpty
    private Set<String> prefixes;

    @NotNull
    @NotEmpty
    private String subConcord;

    @NotNull
    @NotEmpty
    private String copConcord;

    @NotNull
    @NotEmpty
    private String objConcord;

    @NotNull
    @NotEmpty
    private String absPronoun;

    @NotNull
    @NotEmpty
    private String incPronoun;

    @NotNull
    @NotEmpty
    private String excPronoun;

    @NotNull
    @NotEmpty
    private String possessiveHead;

    @NotNull
    @NotEmpty
    private String possessiveTail;

    @NotNull
    @NotEmpty
    private String demonstrative1;

    @NotNull
    @NotEmpty
    private String demonstrative2;

    @NotNull
    @NotEmpty
    private String demonstrative3;

    @NotNull
    @NotEmpty
    private String copLocDemonstrative1;

    @NotNull
    @NotEmpty
    private String copLocDemonstrative2;

    @NotNull
    @NotEmpty
    private String copLocDemonstrative3;

    @NotNull
    @NotEmpty
    private String enumerative;

    private boolean isPlural;

    public String getNounClassName() {
        return nounClassName;
    }

    public void setNounClassName(String nounClassName) {
        this.nounClassName = nounClassName;
    }

    public Set<String> getPrefixes() {
        return prefixes;
    }

    public void setPrefixes(Set<String> prefixes) {
        this.prefixes = prefixes;
    }

    public String getSubConcord() {
        return subConcord;
    }

    public void setSubConcord(String subConcord) {
        this.subConcord = subConcord;
    }

    public String getCopConcord() {
        return copConcord;
    }

    public void setCopConcord(String copConcord) {
        this.copConcord = copConcord;
    }

    public String getObjConcord() {
        return objConcord;
    }

    public void setObjConcord(String objConcord) {
        this.objConcord = objConcord;
    }

    public String getAbsPronoun() {
        return absPronoun;
    }

    public void setAbsPronoun(String absPronoun) {
        this.absPronoun = absPronoun;
    }

    public String getIncPronoun() {
        return incPronoun;
    }

    public void setIncPronoun(String incPronoun) {
        this.incPronoun = incPronoun;
    }

    public String getExcPronoun() {
        return excPronoun;
    }

    public void setExcPronoun(String excPronoun) {
        this.excPronoun = excPronoun;
    }

    public String getPossessiveHead() {
        return possessiveHead;
    }

    public void setPossessiveHead(String possessiveHead) {
        this.possessiveHead = possessiveHead;
    }

    public String getPossessiveTail() {
        return possessiveTail;
    }

    public void setPossessiveTail(String possessiveTail) {
        this.possessiveTail = possessiveTail;
    }

    public String getDemonstrative1() {
        return demonstrative1;
    }

    public void setDemonstrative1(String demonstrative1) {
        this.demonstrative1 = demonstrative1;
    }

    public String getDemonstrative2() {
        return demonstrative2;
    }

    public void setDemonstrative2(String demonstrative2) {
        this.demonstrative2 = demonstrative2;
    }

    public String getDemonstrative3() {
        return demonstrative3;
    }

    public void setDemonstrative3(String demonstrative3) {
        this.demonstrative3 = demonstrative3;
    }

    public String getCopLocDemonstrative1() {
        return copLocDemonstrative1;
    }

    public void setCopLocDemonstrative1(String copLocDemonstrative1) {
        this.copLocDemonstrative1 = copLocDemonstrative1;
    }

    public String getCopLocDemonstrative2() {
        return copLocDemonstrative2;
    }

    public void setCopLocDemonstrative2(String copLocDemonstrative2) {
        this.copLocDemonstrative2 = copLocDemonstrative2;
    }

    public String getCopLocDemonstrative3() {
        return copLocDemonstrative3;
    }

    public void setCopLocDemonstrative3(String copLocDemonstrative3) {
        this.copLocDemonstrative3 = copLocDemonstrative3;
    }

    public String getEnumerative() {
        return enumerative;
    }

    public void setEnumerative(String enumerative) {
        this.enumerative = enumerative;
    }

    public boolean isPlural() {
        return isPlural;
    }

    public void setPlural(boolean plural) {
        isPlural = plural;
    }


    public List<Noun> getNouns() {
        return nouns;
    }

    public void setNouns(List<Noun> nouns) {
        this.nouns = nouns;
    }
}
