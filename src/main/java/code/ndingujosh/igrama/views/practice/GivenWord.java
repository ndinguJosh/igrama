package code.ndingujosh.igrama.views.practice;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.charts.events.MouseEventDetails;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;

// TODO Make this extend Word instead
public class GivenWord extends Div {

    private Span description;
    private Span contents;

    /*
    Should include spaces
     */
    public GivenWord(Span description, Span contents) {
        this.description = description;
        this.contents = contents;

        // TODO Change this to right click
        addClickListener(event -> {
            Dialog descriptionDialogue = new Dialog(new H2(contents.getText()), description);
            descriptionDialogue.open();
        });

        add(contents);
    }
}
