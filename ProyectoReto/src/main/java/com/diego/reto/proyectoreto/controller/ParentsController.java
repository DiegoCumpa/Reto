package com.diego.reto.proyectoreto.controller;

import com.diego.reto.proyectoreto.model.Parents;
import com.diego.reto.proyectoreto.repository.ParentsRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

/**
 * Created by jcumpale on 13/05/2019.
 */

/**
 * Clase Controlador de la entidad Parents para el manejo de solicitudes HTTP
 * @author jcumpale
 * version 1.0
 */

@RestController
@RequestMapping(path = "ProyectoReto/api/v1")
@Api(value = "ParentsControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE )
public class ParentsController {

    /**
     * Injección de dependencia para instanciar métodos desde ParentsRepository
     */
    @Autowired
    private ParentsRepository parentsRepository;


    /**
     * POST /parents:Crear un nuevo registro de parent
     * @param p : Objeto de parents para el requestbody     *
     * @return Retorna la solicitud con estado 201(Created) y con el body de parents o
     * si el id ya existe, retorna la solicitud con estado 400(Bad Request)
     */

    @PostMapping("/parents")
    @ApiOperation("Inserta Registro")
    @ResponseBody
    public ResponseEntity<Object> Create(@RequestBody Parents p)
    {
        Optional<Parents> OT = parentsRepository.findById(p.getParentId());
        if (OT.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        parentsRepository.save(p);
        return new ResponseEntity<>(p,HttpStatus.CREATED);
    }

    /**
     * GET /parents: Obtiene todos los parents
      * @return Retorna la solicitud con estado 200 y con la lista de parents en cuerpo
     */

    @GetMapping("/parents")
    @ApiOperation("Obtiene todo")
    @ResponseBody
    public Iterable<Parents> FindAll()
    {
        return parentsRepository.findAll();
    }

    /**
     *PUT /parents: Actualiza un registro de parents
     * @param TMO Objeto de parents para el cuerpo de la solicitud
     * @param id variable de registro de parent que va ser actualizado
     * @return devuelve la solicitud con estado 200 sin cuerpo o si id no existe, retorna la solicitud con estado 404
     */

    @PutMapping("/parents/{id}")
    @ApiOperation("Actualiza registro")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Object> Update(@RequestBody Parents TMO, @PathVariable Integer id)
    {
        Optional<Parents> OT = parentsRepository.findById(id);
        if (!OT.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        TMO.setParentId(id);
        parentsRepository.save(TMO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * DELETE /: Elimina un registro de parents
     * @param id id de registro que va ser eliminado
     * @return retorna estado de la solicitud con estado 200
     */

    @DeleteMapping("/parents/{id}")
    @ApiOperation("Elimina registro")
    @ResponseBody
    public ResponseEntity<Object> deleteID(@PathVariable Integer id)
    {
        Optional<Parents> OT = parentsRepository.findById(id);
        if (!OT.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        parentsRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
