package code.ndingujosh.igrama.views.home;

import code.ndingujosh.igrama.views.IconButton;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;


/**
 * A custom component for displaying an overview of a SentenceType with a description and example of it and the grammar concepts it contains.
 */
@CssImport("./views/shared-styles.css")
public class SentenceTypeCard extends HorizontalLayout {

    private String[] colors = {"darkolivegreen", "darkblue", "darkcyan", "darkgreen", "darkmagenta", "darkred", "darkslategrey", "deeppink", "dodgerblue"}; // colors to be randomly chosen for tags

    // TODO: Change this to accept SentenceType object from db as parameter
    // TODO: Give the same tags the same colours
    public SentenceTypeCard(String description, String example, String tags) {
        addClassName("card");
        setAlignItems(Alignment.CENTER);
        VerticalLayout summaryLayout = new VerticalLayout();
        summaryLayout.add(new H4(description), new Span(example), createTagsLayout(tags));

        IconButton startPracticeButton = new IconButton(VaadinIcon.CHEVRON_RIGHT_SMALL); // TODO Add a click listener for this arrow

        add(summaryLayout, startPracticeButton);
        expand(summaryLayout);
    }

    // TODO Change this method to receive a List instead of comma-separated String
    private FlexLayout createTagsLayout(String tags) {
        FlexLayout tagsLayout = new FlexLayout();
        tagsLayout.setFlexWrap(FlexLayout.FlexWrap.WRAP);

        for (String tag : tags.split(",")) {
            tagsLayout.add(new Tag(tag, colors[(int) (Math.random() * colors.length)]));
        }

        return tagsLayout;
    }
}
