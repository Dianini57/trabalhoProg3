/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import dao.Dao;
import java.io.Serializable;
import java.lang.invoke.VarHandle;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Animal;
import modelo.ConsultaAnimal;
/**
 *
 * @author temporario
 */
@Named
@ViewScoped
public class ConsultaControle implements Serializable{
    
    private Dao<Animal> daoAnimal;
    private Dao<ConsultaAnimal> daoConsulta;
    private List<Animal> animais;
    private ConsultaAnimal consulta;
    
     @PostConstruct
    public void iniciar() {
        daoAnimal = new Dao(Animal.class);
        daoConsulta = new Dao(ConsultaAnimal.class);      
        setConsulta(new ConsultaAnimal());
        setAnimais(daoAnimal.listarTodos());
    }
    
    public void inserir() {
        daoConsulta.inserir(getConsulta());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Consulta inserida", null));
        setConsulta(new ConsultaAnimal());
        
        
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public ConsultaAnimal getConsulta() {
        return consulta;
    }

    public void setConsulta(ConsultaAnimal consulta) {
        this.consulta = consulta;
    }

    
    
}