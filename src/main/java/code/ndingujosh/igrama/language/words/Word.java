package code.ndingujosh.igrama.language.words;

import com.vaadin.flow.component.html.Div;

public abstract class Word extends Div {
    // Add click listener to display description

    private String description;
    private String contents;

    public Word(String description, String contents) {
        this.description = description;
        this.contents = contents;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
