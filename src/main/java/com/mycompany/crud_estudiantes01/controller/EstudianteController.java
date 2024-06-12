/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.crud_estudiantes01.controller;

import com.mycompany.crud_estudiantes01.bean.BeanEstudiante;
import com.mycompany.crud_estudiantes01.entity.Estudiante;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EstudianteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String option = (request.getParameter("option") != null) ? request.getParameter("option") : "view";
        Estudiante e1 = new Estudiante();
        List<Estudiante> estudiantes = new ArrayList<>();
        int id;
        switch (option) {
            case "view":
                estudiantes = findAll();
                request.setAttribute("estudiantes", estudiantes);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "create":
                request.setAttribute("estudiante", e1);
                request.getRequestDispatcher("formulario.jsp").forward(request, response);
                break;
            case "update":
                id = Integer.parseInt(request.getParameter("id"));
                e1 = findById(id);
                request.setAttribute("estudiante", e1);
                request.getRequestDispatcher("formulario.jsp").forward(request, response);
                break;
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                delete(id);
                estudiantes = findAll();
                request.setAttribute("estudiantes", estudiantes);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
        }

        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.toString());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String fNacimiento = request.getParameter("fNacimiento");
        int id = Integer.parseInt(request.getParameter("id"));
        List<Estudiante> estudiantes = new ArrayList<>();

        Estudiante e1;

        if (id == -1) {
            e1 = new Estudiante();
            e1.setNombre(nombre);
            e1.setApellido(apellido);
            e1.setEmail(email);
            e1.setFNacimiento(fNacimiento);
            create(e1);
        } else {
            e1 = findById(id);
            e1.setNombre(nombre);
            e1.setApellido(apellido);
            e1.setEmail(email);
            e1.setFNacimiento(fNacimiento);
            update(e1);
        }
        response.sendRedirect(request.getContextPath() + "/EstudianteController");
    }

    public List<Estudiante> findAll() {
        BeanEstudiante service = new BeanEstudiante();
        return service.findAll();
    }

    public Estudiante findById(int id) {
        BeanEstudiante service = new BeanEstudiante();
        return service.findById(id);
    }

    public void create(Estudiante estudiante) {
        BeanEstudiante service = new BeanEstudiante();
        service.create(estudiante);
    }

    public void update(Estudiante estudiante) {
        BeanEstudiante service = new BeanEstudiante();
        service.update(estudiante);
    }

    public void delete(Integer id) {
        BeanEstudiante service = new BeanEstudiante();
        service.delete(id);
    }

}
