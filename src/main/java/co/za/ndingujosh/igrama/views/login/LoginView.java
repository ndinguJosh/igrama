package co.za.ndingujosh.igrama.views.login;

import co.za.ndingujosh.igrama.views.signup.SignUpView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Login")
@Route(value = "login")
public class LoginView extends LoginOverlay {
    public LoginView() {
        setAction("login");

        LoginI18n i18n = LoginI18n.createDefault();
        i18n.setHeader(new LoginI18n.Header());
        i18n.getHeader().setTitle("igrama");
        i18n.getHeader().setDescription("Login using user/user or admin/admin");
        i18n.setAdditionalInformation(null);

        // Use forgot password button as sign up instead.
        i18n.getForm().setForgotPassword("Sign up");
        setForgotPasswordButtonVisible(true);
        addForgotPasswordListener(event -> {
            close();
            UI.getCurrent().navigate(SignUpView.class);
        });

        setI18n(i18n);
        setOpened(true);
    }

}
