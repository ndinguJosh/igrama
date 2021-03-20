package code.ndingujosh.igrama.views.enter;

import code.ndingujosh.igrama.views.main.MainView;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "enter", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Igrama | Enter a noun")
@CssImport("./views/enter/enter-view.css")
@Tag("enter-view")
public class EnterView extends VerticalLayout {

}
