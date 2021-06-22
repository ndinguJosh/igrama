package code.ndingujosh.igrama.views;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;

@CssImport("./views/shared-styles.css")
public class Header extends Div {
    // TODO Add arty pictures to this header to make a nice logo
    // TODO Make this act as a link to direct users to the home page

    public Header() {
        addClassName("header");
        H1 igramaTitle = new H1("igrama");
        igramaTitle.addClickListener(h1ClickEvent -> this.getUI().ifPresent(ui -> ui.navigate("")));
        add(igramaTitle);
    }
}
