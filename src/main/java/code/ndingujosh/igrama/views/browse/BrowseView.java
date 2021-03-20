package code.ndingujosh.igrama.views.browse;

import code.ndingujosh.igrama.views.main.MainView;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "browse", layout = MainView.class)
@PageTitle("Browse nouns")
@CssImport("./views/browse/browse-view.css")
@Tag("browse-view")
public class BrowseView extends VerticalLayout {

}
