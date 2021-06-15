package code.ndingujosh.igrama.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;


/**
 * A custom component for displaying an overview of a SentenceType with a description and example of it and the grammar concepts it contains.
 */
@CssImport("./views/shared-styles.css")
public class SentenceTypeCard extends HorizontalLayout {

    private String[] colours = {"darkolivegreen", "darkblue", "darkcyan", "darkgreen", "darkmagenta", "darkred", "darkslategrey", "deeppink", "dodgerblue"}; // colours to be randomly chosen for tags

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

    private HorizontalLayout createTagsLayout(String tags) {
        HorizontalLayout tagsLayout = new HorizontalLayout();
        tagsLayout.addClassName("tags");
        tagsLayout.setSpacing(true);

        for (String tag : tags.split(",")) {
            Span colourTag = new Span(tag);
            colourTag.addClassName("tag");
            colourTag.getStyle().set("background-color", colours[(int) (Math.random() * colours.length)]);
            tagsLayout.add(colourTag);
        }

        return tagsLayout;
    }
}
