package code.ndingujosh.igrama.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
@CssImport("./views/shared-styles.css")
public class Home extends Div {

    private H1 title = new H1("igrama");
    private Button adminButton = new Button("Admin");
    private Button helpButton = new Button("Help");
    private HorizontalLayout navigateLayout = new HorizontalLayout();
    private VerticalLayout sentenceTypeSelectionLayout = new VerticalLayout();
    private VerticalLayout pageLayout = new VerticalLayout();

    public Home() {
        pageLayout.addClassName("home");

        navigateLayout.setWidthFull();
        navigateLayout.addClassName("card");
        navigateLayout.getStyle().set("margin-bottom", "5%");
        navigateLayout.addAndExpand(adminButton, helpButton);

        H3 sentenceTypeSelectionTitle = new H3("Choose a sentence type");
        IconButton sentenceTypeSelectionHelp = new IconButton(VaadinIcon.QUESTION_CIRCLE_O); // TODO Add click-listener for this help icon
        sentenceTypeSelectionHelp.getStyle().set("margin-left", "auto"); // forces icon to right-hand edge
        HorizontalLayout sentenceTypeSelectionHeader = new HorizontalLayout(sentenceTypeSelectionTitle, sentenceTypeSelectionHelp);
        sentenceTypeSelectionHeader.setAlignItems(FlexComponent.Alignment.BASELINE);

        sentenceTypeSelectionLayout.addClassName("card");
        sentenceTypeSelectionLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
        sentenceTypeSelectionLayout.setAlignSelf(FlexComponent.Alignment.CENTER);
        sentenceTypeSelectionLayout.add(sentenceTypeSelectionHeader,
                createExampleSentenceTypes("Example sentence type #1", "Example sentence that shows the user what the grammar structure is", "example, prototype, template, blueprint"),
                createExampleSentenceTypes("Example sentence type #2", "A second example sentence with some text", "tag1, tag2"));

        pageLayout.add(title, navigateLayout, sentenceTypeSelectionLayout);
        add(pageLayout);
    }

    // TODO Replace this method with one that receives a stream of SentenceType objects and converts them to cards.
    // TODO Use CSS z-indices to give the cards a layered effect
    private Component createExampleSentenceTypes(String description, String example, String tags) {
        SentenceTypeCard card = new SentenceTypeCard(description, example, tags);
        card.setWidthFull();
        return card;
    }
}
