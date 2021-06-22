package code.ndingujosh.igrama.views.home;

import code.ndingujosh.igrama.views.Header;
import code.ndingujosh.igrama.views.IconButton;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
@CssImport("./views/shared-styles.css")
public class Home extends Div {

    private Header title = new Header();
    private Button adminButton = new Button("Admin");
    private Button helpButton = new Button("Help");
    private HorizontalLayout navigateLayout = new HorizontalLayout();
    private VerticalLayout sentenceTypeSelectionLayout = new VerticalLayout();
    private VerticalLayout pageLayout = new VerticalLayout();

    public Home() {
        pageLayout.addClassName("page");

        navigateLayout.addClassName("card");
        navigateLayout.addAndExpand(adminButton, helpButton);

        H3 sentenceTypeSelectionTitle = new H3("Choose a sentence type");
        IconButton sentenceTypeSelectionHelp = new IconButton(VaadinIcon.QUESTION_CIRCLE_O); // TODO Add click-listener for this help icon
        sentenceTypeSelectionHelp.getStyle().set("margin-left", "auto"); // forces icon to right-hand edge
        HorizontalLayout sentenceTypeSelectionHeader = new HorizontalLayout(sentenceTypeSelectionTitle, sentenceTypeSelectionHelp);
        sentenceTypeSelectionHeader.setWidthFull();
        sentenceTypeSelectionHeader.setAlignItems(FlexComponent.Alignment.BASELINE);

        sentenceTypeSelectionLayout.setPadding(false);
        sentenceTypeSelectionLayout.add(
                createExampleSentenceTypes("Example sentence type #1", "Example sentence that shows the user what the grammar structure is", "example, prototype, template, blueprint, whiteboard, idea, innovation"),
                createExampleSentenceTypes("Example sentence type #2", "A second example sentence with some text", "tag1, tag2"),
                createExampleSentenceTypes("Example sentence type #3", "A third example sentence with some text that is so long it starts to loop around onto a new line and demonstrates the text-wrap effect.", "tag1, tag2")
        );

        pageLayout.add(title, navigateLayout, sentenceTypeSelectionHeader, sentenceTypeSelectionLayout);
        add(pageLayout);
    }

    // TODO Replace this method with one that receives a stream of SentenceType objects and converts them to cards.
    // TODO Use CSS z-indices to give the cards a layered effect
    private Component createExampleSentenceTypes(String description, String example, String tags) {
        return new SentenceTypeCard(description, example, tags);
    }
}
