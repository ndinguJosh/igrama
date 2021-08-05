package code.ndingujosh.igrama.language.words;

public class GivenWord extends Word {

    private boolean leadingSpace = false;
    private boolean trailingSpace = false;

    /*
    Should include spaces
     */
    public GivenWord(String description, String contents) {
        super(description, contents);
        findAndStripSpaces();
    }

    private void findAndStripSpaces() {
        // Find and strip leading whitespace
        if (Character.isWhitespace(getContents().charAt(0))) {
            leadingSpace = true;
            setContents(getContents().stripLeading());
        }

        // Find and strip trailing whitespace
        if (Character.isWhitespace(getContents().charAt(getContents().length() - 1))) {
            trailingSpace = true;
            setContents(getContents().stripTrailing());
        }
    }

    public boolean hasLeadingSpace() {
        return leadingSpace;
    }

    public boolean hasTrailingSpace() {
        return trailingSpace;
    }
}
