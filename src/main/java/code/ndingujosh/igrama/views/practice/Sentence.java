package code.ndingujosh.igrama.views.practice;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class Sentence extends FlexLayout {

    public Sentence(Component... words) {
        addClassName("card");
        setFlexWrap(FlexWrap.WRAP);
        setAlignItems(Alignment.BASELINE);
        add(words);
    }
}
