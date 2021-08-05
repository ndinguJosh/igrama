package code.ndingujosh.igrama.language.words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sentence {

    private List<Word> words = new ArrayList<>();

    public Sentence(Word... words) {
        this.words.addAll(Arrays.asList(words));
    }

    public List<Word> getWords() {
        return words;
    }
}
