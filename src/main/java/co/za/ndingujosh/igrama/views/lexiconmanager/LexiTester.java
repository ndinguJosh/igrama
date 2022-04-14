package co.za.ndingujosh.igrama.views.lexiconmanager;

import co.za.ndingujosh.igrama.data.entity.Noun;
import co.za.ndingujosh.igrama.data.service.NounService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.springframework.beans.factory.annotation.Autowired;

@Route("test")
@AnonymousAllowed
public class LexiTester extends VerticalLayout {
    public LexiTester(@Autowired NounService nounService){
        LexiForm<Noun> lexiForm = new LexiForm<Noun>(Noun.class);
        lexiForm.bindFields();
        lexiForm.setBean(nounService.get(12).orElse(new Noun()));
        add(lexiForm);
    }
}
