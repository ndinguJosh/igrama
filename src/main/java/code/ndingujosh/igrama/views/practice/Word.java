package code.ndingujosh.igrama.views.practice;

import com.vaadin.flow.component.html.Div;

public abstract class Word extends Div {
    // Add click listener to display description

    private String description;
    private String contents;
    private boolean leadingSpace = false;
    private boolean trailingSpace = false;
    private boolean hidden = false; // Is this necessary?

    public Word(String description, String contents) {
        this.description = description;
        this.contents = contents;
        findSpaces();
    }

    private void findSpaces() {
        // Find and strip leading whitespace
        if (Character.isWhitespace(contents.charAt(0))) {
            leadingSpace = true;
            contents = contents.stripLeading();
        }

        // Find and strip trailing whitespace
        if (Character.isWhitespace(contents.charAt(contents.length() - 1))) {
            trailingSpace = true;
            contents = contents.stripTrailing();
        }
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

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean hasLeadingSpace() {
        return leadingSpace;
    }

    public boolean hasTrailingSpace() {
        return trailingSpace;
    }
}
