/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud_estudiantes01.bean;

import com.mycompany.crud_estudiantes01.entity.Estudiante;
import com.mycompany.crud_estudiantes01.jpa.EstudianteJpaController;
import com.mycompany.crud_estudiantes01.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author www74
 */
public class BeanEstudiante {

    private EntityManagerFactory emf;
    private EstudianteJpaController jpaEstudiante;

    public BeanEstudiante() {
        emf = Persistence.createEntityManagerFactory("UPestudiante");
        System.out.println("el valor de emf" + emf);
        jpaEstudiante = new EstudianteJpaController(emf);
    }

    public List<Estudiante> findAll() {
        return jpaEstudiante.findEstudianteEntities();
    }
    
    public Estudiante findById(Integer id){
        Estudiante estudianteSel = jpaEstudiante.findEstudiante(id);
        if(estudianteSel != null) return estudianteSel;
        
        return null;
    }

    public void create(Estudiante estudiante) {
        jpaEstudiante.create(estudiante);
    }

    public void update(Estudiante estudiante) {
        try {
            jpaEstudiante.edit(estudiante);
        } catch (Exception ex) {
            Logger.getLogger(BeanEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Integer id) {
        try {
            jpaEstudiante.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(BeanEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
