package cz.asenk.vsb.langis.component;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;

import cz.asenk.vsb.langis.jpa.model.User;
import lombok.AccessLevel;
import lombok.Getter;

/**
 * @author Alois Šenkyřík asenkyrik@monetplus.cz
 * @version 1.0
 * Created: 08.12.2022
 */

@Getter
public class UserForm extends FormLayout {
    private User user;
    Binder<User> binder = new BeanValidationBinder<>(User.class);

    TextField name = new TextField("First name");
    EmailField email = new EmailField("Email");
    TextField telephone = new TextField("Telephone");

    Button saveButton = new Button("Save");
    Button deleteButton = new Button("Delete");
    Button closeButton = new Button("Close");


    public UserForm(){
        addClassName("user-form");
        binder.bindInstanceFields(this);

        add(
                name,
                email,
                telephone,
                createButtonsLayout()
        );
    }

    private HorizontalLayout createButtonsLayout(){
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        deleteButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
        closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        saveButton.addClickShortcut(Key.ENTER);
        closeButton.addClickShortcut(Key.ESCAPE);

        saveButton.addClickListener(event -> validateAndSave());
        deleteButton.addClickListener(event -> fireEvent(new DeleteEvent(this, user)));
        closeButton.addClickListener(event -> fireEvent(new CloseEvent(this)));

        binder.addStatusChangeListener(e -> saveButton.setEnabled(binder.isValid()));

        return new HorizontalLayout(saveButton, deleteButton, closeButton);
    }

    private void validateAndSave() {
        try {
            binder.writeBean(user);
            fireEvent(new SaveEvent(this, user));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    public void setUser(User user){
        this.user = user;
        binder.readBean(user);
    }

    // Events
    @Getter(AccessLevel.MODULE)
    public abstract static class UserFormEvent extends ComponentEvent<UserForm> {
        private final User user;

        protected UserFormEvent(UserForm source, User contact) {
            super(source, false);
            this.user = contact;
        }
    }

    public static class SaveEvent extends UserFormEvent {
        SaveEvent(UserForm source, User contact) {
            super(source, contact);
        }
    }

    public static class DeleteEvent extends UserFormEvent {
        DeleteEvent(UserForm source, User contact) {
            super(source, contact);
        }
    }

    public static class CloseEvent extends UserFormEvent {
        CloseEvent(UserForm source) {
            super(source, null);
        }
    }

    @Override
    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType, ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}

