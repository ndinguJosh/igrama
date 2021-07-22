package code.ndingujosh.igrama.views.practice;

import code.ndingujosh.igrama.views.Header;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("practice")
@CssImport("./views/shared-styles.css")
public class Practice extends Div {

    private Header header = new Header();
    private Sentence sentence = new Sentence();
    private VerticalLayout pageLayout = new VerticalLayout();

    public Practice() {
        pageLayout.addClassName("page");

        sentence.add(
                new GivenWord(new Span("A noun in class 5 meaning 'horse'"), new Span("Ihashe ")),
                new HiddenWord(new Span("The object concord for ihashe"), new Span("li")),
                new GivenWord(new Span("A verb meaining 'run' (in past tense)"), new Span("balekile")));

        Button checkButton = new Button("Check answer");
        checkButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        pageLayout.add(header, sentence, checkButton);
        add(pageLayout);
    }
}
