package com.diego.reto.proyectoreto.controller;

import com.diego.reto.proyectoreto.model.Parents;
import com.diego.reto.proyectoreto.repository.ParentsRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

/**
 * Created by jcumpale on 13/05/2019.
 */
@RestController
@RequestMapping(path = "ProyectoReto/api/v1")
public class ParentsController {

    @Autowired
    private ParentsRepository parentsRepository;

    @PostMapping("/parents")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.CREATED)
    public Parents Create(@RequestBody Parents p)
    {
        parentsRepository.save(p);
        return p;
    }

    @GetMapping("/parents")
    @ResponseBody
    public Iterable<Parents> FindAll()
    {
        return parentsRepository.findAll();
    }

    @PutMapping("/parents/{id}")
    @ResponseBody
    public String Update(@RequestBody Parents TMO, @PathVariable Integer id)
    {
        Optional<Parents> OT = parentsRepository.findById(id);
        if (!OT.isPresent())
            return "No se Encontró Padre con id Especificado";
        TMO.setParentId(id);
        parentsRepository.save(TMO);
        return "Actualizado Satisfactoriamente";
    }

    @DeleteMapping("/parents/{id}")
    @ResponseBody
    public String deleteID(@PathVariable Integer id)
    {
        parentsRepository.deleteById(id);
        return "Registro Borrado Correctamente";
    }

}
