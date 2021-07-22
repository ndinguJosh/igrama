package code.ndingujosh.igrama.views.practice;

import com.vaadin.flow.component.KeyEventListener;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.textfield.TextField;

// TODO Make this extend Word instead
public class HiddenWord extends Div {

    private Span description;
    private Span contents;
    private TextField userAnswer = new TextField();

    /**
     * @param contents Mustn't include spaces
     */
    public HiddenWord(Span description, Span contents) {
        this.description = description;
        this.contents = contents;

        addClickListener(event -> {
            Dialog descriptionDialogue = new Dialog(new H2("What should I type here?"), description);
            descriptionDialogue.open();
        });

        add(userAnswer);
    }
}
