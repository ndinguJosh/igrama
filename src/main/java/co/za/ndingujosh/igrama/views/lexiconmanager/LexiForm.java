package co.za.ndingujosh.igrama.views.lexiconmanager;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanPropertySet;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.PropertyDefinition;
import com.vaadin.flow.shared.Registration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public class LexiForm<T> extends FormLayout {

    private Class<T> beanType;

    // Stores component property names along with the corresponding component.
    // E.g. "nounClass" and TextField component for editing the noun class.
    private HashMap<String, HasValue<?, ?>> fieldComponentMap = new HashMap<>();

    private Binder<T> binder;

    private Button saveButton = new Button("Save");
    private Button deleteButton = new Button("Delete");
    private Button closeButton = new Button("Close");

    public LexiForm(Class<T> beanType) {
        this.beanType = beanType;

        // Get all the fields of the bean's class. Generate components with them.
        BeanPropertySet.get(beanType)
                .getProperties().forEach(field -> add(createFormComponent(field)));

        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        deleteButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
        closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        saveButton.addClickListener(e -> {
            if (binder.isValid()) fireEvent(new LexiFormEvent.SaveEvent(this, binder.getBean()));
        });
        deleteButton.addClickListener(e ->
                fireEvent(new LexiFormEvent.DeleteEvent(this, binder.getBean())));
        closeButton.addClickListener(e -> fireEvent(new LexiFormEvent.CloseEvent(this)));

        add(new HorizontalLayout(saveButton, deleteButton, closeButton));
    }

    public void bindFields() {
        // Bind each form field with the bean's corresponding property, stored in the map.
        binder = new BeanValidationBinder<>(beanType);
        fieldComponentMap.forEach((fieldName, component) ->
                binder.forField(component).bind(fieldName));
    }

    public void setBean(T bean) {
        binder.setBean(bean);
    }

    private Component createFormComponent(PropertyDefinition<T, ?> field) {
        Class<?> fieldType = field.getType();
        String fieldCaption = field.getCaption();
        String fieldName = field.getName();

        // Determine property's data type, create component for it, and store it for later binding
        if (fieldType.equals(Integer.class)) {
            IntegerField integerField = new IntegerField(fieldCaption);
            fieldComponentMap.put(fieldName, integerField);
            return integerField;

        } else if (fieldType.equals(Double.class)) {
            NumberField numberField = new NumberField(fieldCaption);
            fieldComponentMap.put(fieldName, numberField);
            return numberField;

        } else if (fieldType.equals(String.class)) {
            TextField textField = new TextField(fieldCaption);
            fieldComponentMap.put(fieldName, textField);
            return textField;

        } else if (fieldType.equals(Boolean.class)) {
            Checkbox checkbox = new Checkbox(fieldCaption);
            fieldComponentMap.put(fieldName, checkbox);
            return checkbox;

        } else if (fieldType.equals(LocalDate.class)) {
            DatePicker datePicker = new DatePicker(fieldCaption);
            fieldComponentMap.put(fieldName, datePicker);
            return datePicker;

        } else if (fieldType.equals(LocalDateTime.class)) {
            DateTimePicker dateTimePicker = new DateTimePicker(fieldCaption);
            fieldComponentMap.put(fieldName, dateTimePicker);
            return dateTimePicker;

        } else {
            return new Label("Couldn't generate input field for " + field.getCaption() + " property");
        }
    }

    public static abstract class LexiFormEvent extends ComponentEvent<LexiForm<?>> {
        private Object bean;

        protected LexiFormEvent(LexiForm<?> source, Object bean) {
            super(source, false);
            this.bean = bean;
        }

        public Object getBean() {
            return bean;
        }

        public static class SaveEvent extends LexiFormEvent {
            SaveEvent(LexiForm<?> source, Object bean) {
                super(source, bean);
            }
        }

        public static class DeleteEvent extends LexiFormEvent {
            DeleteEvent(LexiForm<?> source, Object bean) {
                super(source, bean);
            }
        }

        public static class CloseEvent extends LexiFormEvent {
            CloseEvent(LexiForm<?> source) {
                super(source, null);
            }
        }

        public <U extends ComponentEvent<?>> Registration addListener(
                Class<U> eventType, ComponentEventListener<U> listener) {
            return getSource().getEventBus().addListener(eventType, listener);
        }
    }
}
