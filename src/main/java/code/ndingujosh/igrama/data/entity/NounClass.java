package code.ndingujosh.igrama.data.entity;

import code.ndingujosh.igrama.data.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "noun_class")
public class NounClass extends AbstractEntity {

    @OneToMany(mappedBy = "nounClass")
    private List<Noun> nouns = new LinkedList<>();

    @NotNull
    @NotNull
    private String nounClassName;

    @NotNull
    @NotEmpty
    @OneToMany(mappedBy = "nounClass")
    private List<NounPrefix> prefix;

    //TODO: Add a corresponding plural or singular class field

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
    private String posConcord;

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
    private String locCopDemonstrative1;

    @NotNull
    @NotEmpty
    private String locCopDemonstrative2;

    @NotNull
    @NotEmpty
    private String locCopDemonstrative3;

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

    public List<NounPrefix> getPrefix() {
        return prefix;
    }

    public void setPrefix(List<NounPrefix> prefix) {
        this.prefix = prefix;
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

    public String getPosConcord() {
        return posConcord;
    }

    public void setPosConcord(String posConcord) {
        this.posConcord = posConcord;
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

    public String getLocCopDemonstrative1() {
        return locCopDemonstrative1;
    }

    public void setLocCopDemonstrative1(String locCopDemonstrative1) {
        this.locCopDemonstrative1 = locCopDemonstrative1;
    }

    public String getLocCopDemonstrative2() {
        return locCopDemonstrative2;
    }

    public void setLocCopDemonstrative2(String locCopDemonstrative2) {
        this.locCopDemonstrative2 = locCopDemonstrative2;
    }

    public String getLocCopDemonstrative3() {
        return locCopDemonstrative3;
    }

    public void setLocCopDemonstrative3(String locCopDemonstrative3) {
        this.locCopDemonstrative3 = locCopDemonstrative3;
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
