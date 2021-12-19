package co.za.ndingujosh.igrama.views.lexiconmanager;

import co.za.ndingujosh.igrama.data.entity.Noun;
import co.za.ndingujosh.igrama.data.service.NounService;
import com.vaadin.collaborationengine.CollaborationAvatarGroup;
import com.vaadin.collaborationengine.CollaborationBinder;
import com.vaadin.collaborationengine.UserInfo;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import java.util.Optional;
import java.util.UUID;
import javax.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("Lexicon manager")
@Route(value = "manage/:nounID?/:action?(edit)")
@RouteAlias(value = "")
@RolesAllowed("admin")
@Uses(Icon.class)
public class LexiconmanagerView extends Div implements BeforeEnterObserver {

    private final String NOUN_ID = "nounID";
    private final String NOUN_EDIT_ROUTE_TEMPLATE = "manage/%d/edit";

    private Grid<Noun> grid = new Grid<>(Noun.class, false);

    CollaborationAvatarGroup avatarGroup;

    private TextField nounPrefix;
    private TextField root;
    private TextField nounClass;
    private TextField translations;
    private Checkbox isPlural;

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");

    private CollaborationBinder<Noun> binder;

    private Noun noun;

    private NounService nounService;

    public LexiconmanagerView(@Autowired NounService nounService) {
        this.nounService = nounService;
        addClassNames("lexiconmanager-view", "flex", "flex-col", "h-full");

        // UserInfo is used by Collaboration Engine and is used to share details
        // of users to each other to able collaboration. Replace this with
        // information about the actual user that is logged, providing a user
        // identifier, and the user's real name. You can also provide the users
        // avatar by passing an url to the image as a third parameter, or by
        // configuring an `ImageProvider` to `avatarGroup`.
        UserInfo userInfo = new UserInfo(UUID.randomUUID().toString(), "Steve Lange");

        // Create UI
        SplitLayout splitLayout = new SplitLayout();
        splitLayout.setSizeFull();

        avatarGroup = new CollaborationAvatarGroup(userInfo, null);
        avatarGroup.getStyle().set("visibility", "hidden");

        createGridLayout(splitLayout);
        createEditorLayout(splitLayout);

        add(splitLayout);

        // Configure Grid
        grid.addColumn("nounPrefix").setAutoWidth(true);
        grid.addColumn("root").setAutoWidth(true);
        grid.addColumn("nounClass").setAutoWidth(true);
        grid.addColumn("translations").setAutoWidth(true);
        TemplateRenderer<Noun> isPluralRenderer = TemplateRenderer.<Noun>of(
                "<vaadin-icon hidden='[[!item.isPlural]]' icon='vaadin:check' style='width: var(--lumo-icon-size-s); height: var(--lumo-icon-size-s); color: var(--lumo-primary-text-color);'></vaadin-icon><vaadin-icon hidden='[[item.isPlural]]' icon='vaadin:minus' style='width: var(--lumo-icon-size-s); height: var(--lumo-icon-size-s); color: var(--lumo-disabled-text-color);'></vaadin-icon>")
                .withProperty("isPlural", Noun::isIsPlural);
        grid.addColumn(isPluralRenderer).setHeader("Is Plural").setAutoWidth(true);

        grid.setItems(query -> nounService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        grid.setHeightFull();

        // when a row is selected or deselected, populate form
        grid.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() != null) {
                UI.getCurrent().navigate(String.format(NOUN_EDIT_ROUTE_TEMPLATE, event.getValue().getId()));
            } else {
                clearForm();
                UI.getCurrent().navigate(LexiconmanagerView.class);
            }
        });

        // Configure Form
        binder = new CollaborationBinder<>(Noun.class, userInfo);

        // Bind fields. This where you'd define e.g. validation rules
        binder.forField(nounClass, String.class).withConverter(new StringToIntegerConverter("Only numbers are allowed"))
                .bind("nounClass");

        binder.bindInstanceFields(this);

        cancel.addClickListener(e -> {
            clearForm();
            refreshGrid();
        });

        save.addClickListener(e -> {
            try {
                if (this.noun == null) {
                    this.noun = new Noun();
                }
                binder.writeBean(this.noun);

                nounService.update(this.noun);
                clearForm();
                refreshGrid();
                Notification.show("Noun details stored.");
                UI.getCurrent().navigate(LexiconmanagerView.class);
            } catch (ValidationException validationException) {
                Notification.show("An exception happened while trying to store the noun details.");
            }
        });
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        Optional<Integer> nounId = event.getRouteParameters().getInteger(NOUN_ID);
        if (nounId.isPresent()) {
            Optional<Noun> nounFromBackend = nounService.get(nounId.get());
            if (nounFromBackend.isPresent()) {
                populateForm(nounFromBackend.get());
            } else {
                Notification.show(String.format("The requested noun was not found, ID = %d", nounId.get()), 3000,
                        Notification.Position.BOTTOM_START);
                // when a row is selected but the data is no longer available,
                // refresh grid
                refreshGrid();
                event.forwardTo(LexiconmanagerView.class);
            }
        }
    }

    private void createEditorLayout(SplitLayout splitLayout) {
        Div editorLayoutDiv = new Div();
        editorLayoutDiv.setClassName("flex flex-col");
        editorLayoutDiv.setWidth("400px");

        Div editorDiv = new Div();
        editorDiv.setClassName("p-l flex-grow");
        editorLayoutDiv.add(editorDiv);

        FormLayout formLayout = new FormLayout();
        nounPrefix = new TextField("Noun Prefix");
        root = new TextField("Root");
        nounClass = new TextField("Noun Class");
        translations = new TextField("Translations");
        isPlural = new Checkbox("Is Plural");
        isPlural.getStyle().set("padding-top", "var(--lumo-space-m)");
        Component[] fields = new Component[]{nounPrefix, root, nounClass, translations, isPlural};

        for (Component field : fields) {
            ((HasStyle) field).addClassName("full-width");
        }
        formLayout.add(fields);
        editorDiv.add(avatarGroup, formLayout);
        createButtonLayout(editorLayoutDiv);

        splitLayout.addToSecondary(editorLayoutDiv);
    }

    private void createButtonLayout(Div editorLayoutDiv) {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setClassName("w-full flex-wrap bg-contrast-5 py-s px-l");
        buttonLayout.setSpacing(true);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save, cancel);
        editorLayoutDiv.add(buttonLayout);
    }

    private void createGridLayout(SplitLayout splitLayout) {
        Div wrapper = new Div();
        wrapper.setId("grid-wrapper");
        wrapper.setWidthFull();
        splitLayout.addToPrimary(wrapper);
        wrapper.add(grid);
    }

    private void refreshGrid() {
        grid.select(null);
        grid.getLazyDataView().refreshAll();
    }

    private void clearForm() {
        populateForm(null);
    }

    private void populateForm(Noun value) {
        this.noun = value;
        String topic = null;
        if (this.noun != null && this.noun.getId() != null) {
            topic = "noun/" + this.noun.getId();
            avatarGroup.getStyle().set("visibility", "visible");
        } else {
            avatarGroup.getStyle().set("visibility", "hidden");
        }
        binder.setTopic(topic, () -> this.noun);
        avatarGroup.setTopic(topic);

    }
}