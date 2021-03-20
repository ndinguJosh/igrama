package code.ndingujosh.igrama.views.admin;

import code.ndingujosh.igrama.views.main.MainView;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "admin", layout = MainView.class)
@PageTitle("Admin")
@CssImport("./views/admin/admin-view.css")
@Tag("admin-view")
@JsModule("./views/admin/admin-view.js")
public class AdminView extends VerticalLayout {

}
