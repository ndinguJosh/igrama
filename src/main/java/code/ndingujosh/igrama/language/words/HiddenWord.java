package code.ndingujosh.igrama.language.words;

import code.ndingujosh.igrama.data.entity.GrammarConcept;

import java.util.List;

public class HiddenWord extends Word {

    private String response;
    private boolean correct;
    private List<GrammarConcept> grammarConcepts;

    /**
     * @param contents mustn't include spaces
     */
    public HiddenWord(String description, String contents, List<GrammarConcept> grammarConcepts) {
        super(description, contents);
        this.grammarConcepts = grammarConcepts;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public List<GrammarConcept> getGrammarConcepts() {
        return grammarConcepts;
    }

    public void setGrammarConcepts(List<GrammarConcept> grammarConcepts) {
        this.grammarConcepts = grammarConcepts;
    }
}
