package co.za.ndingujosh.igrama.views.signup;

import co.za.ndingujosh.igrama.data.Role;
import co.za.ndingujosh.igrama.data.entity.User;
import co.za.ndingujosh.igrama.data.service.UserService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@PageTitle("Sign Up")
@Route("signup")
@AnonymousAllowed
public class SignUpView extends Div {
    public SignUpView(PasswordEncoder passwordEncoder, UserService userService) {
        FormLayout formLayout = new FormLayout();
        User user = new User();
        Binder<User> userBinder = new Binder<>(User.class);
        userBinder.setBean(user);

        TextField name = new TextField("Name");
        TextField username = new TextField("Username");
        PasswordField password = new PasswordField("Password");
        Checkbox adminCheckbox = new Checkbox("Enable admin rights"); // TODO Use more secure solution
        Button signUp = new Button("Sign Up");
        formLayout.add(name, username, password, adminCheckbox, signUp);

        userBinder.forField(name).bind(User::getName, User::setName);
        userBinder.forField(username).bind(User::getUsername, User::setUsername);
        userBinder.forField(password).bind(
                user1 -> "",
                (user1, pass) -> user1.setHashedPassword(passwordEncoder.encode(pass)));
        userBinder.forField(adminCheckbox).bind(
                user1 -> false,
                (user1, admin) -> user1.setRoles(admin
                        ? Stream.of(Role.USER, Role.ADMIN).collect(Collectors.toSet())
                        : Collections.singleton(Role.USER)));

        signUp.addClickListener(e -> {
            userBinder.writeBeanIfValid(user);
            userService.save(user);
        }); // TODO Implement validation
        add(formLayout);
    }
}
