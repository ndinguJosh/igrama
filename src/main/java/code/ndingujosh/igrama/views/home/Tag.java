package code.ndingujosh.igrama.views.home;

import com.vaadin.flow.component.html.Span;

public class Tag extends Span {

    public Tag(String content, String color) {
        addClassName("tag");
        setText(content);
        getStyle().set("background-color", color);
    }
}
