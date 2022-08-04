package controle;

import dao.Dao;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Tutor;
import modelo.Usuario;

@Named
@ViewScoped
public class NovoTutorControle implements Serializable {
    private Tutor tutor;
    private Dao dao;
    
    @PostConstruct
    public void iniciar(){
        tutor = new Tutor(); 
        dao = new Dao(Tutor.class); 
    }
    
    public String inserir(){
        dao.inserir(tutor);
        tutor = new Tutor();
        FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage
            (FacesMessage.SEVERITY_INFO, "Tutor cadastrado", null)
            );
            return null;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
    
}



