/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author temporario
 */

@Entity
public class Animal implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    Integer Id;

    public Animal() {
    }
    
    @Column (length = 30)
    private String especie;
    
    @Column (length = 30)
    private String raca;
    
    @Column (length = 30)
    private String nome;
    
    @Column
    private Integer idade;
    
    @ManyToOne
    @JoinColumn( name = "tutor", 
            referencedColumnName = "Id")
    private Tutor tutor;

    public Integer getId() {
        return Id;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaca() {
        return raca;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
    
    
  
    
}
