package code.ndingujosh.igrama.views.enter;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import code.ndingujosh.igrama.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@Route(value = "enter", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Enter an noun")
@CssImport("./views/enterannoun/enterannoun-view.css")
@Tag("enterannoun-view")
@JsModule("./views/enterannoun/enterannoun-view.js")
public class EnterView extends PolymerTemplate<TemplateModel> {

    @Id
    private TextField name;

    @Id
    private Button sayHello;

    public EnterView() {
        sayHello.addClickListener(e -> {
            Notification.show("Hello " + name.getValue());
        });
    }
}
