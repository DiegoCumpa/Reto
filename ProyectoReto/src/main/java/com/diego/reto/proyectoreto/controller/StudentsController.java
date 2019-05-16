package com.diego.reto.proyectoreto.controller;

import com.diego.reto.proyectoreto.model.Students;
import com.diego.reto.proyectoreto.repository.StudentsRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by jcumpale on 14/05/2019.
 */

/**
 * Clase Controlador de la entidad Students para el manejo de solicitudes HTTP
 * @author jcumpale
 * version 1.0
 */
@RestController
@RequestMapping(path = "ProyectoReto/api/v1")
@Api(value = "StudentsControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE )
public class StudentsController {

    /**
     * Injección de dependencia para instanciar métodos desde StudentsRepository
     */

    @Autowired
    private StudentsRepository studentsRepository;

    /**
     * POST /students:Crear un nuevo registro de student
     * @param p : Objeto de students para el requestbody     *
     * @return Retorna la solicitud con estado 201(Created) y con el body de students o
     * si el id ya existe, retorna la solicitud con estado 400(Bad Request)
     */

    @PostMapping("/students")
    @ResponseBody
    @ApiOperation("Inserta Registro")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Object> Create(@RequestBody Students s)
    {
        Optional<Students> OT = studentsRepository.findById(s.getStudentId());
        if (OT.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        studentsRepository.save(s);
        return new ResponseEntity<>(s,HttpStatus.CREATED);
    }

    /**
     * GET /students: Obtiene todos los students
     * @return Retorna la solicitud con estado 200 y con la lista de students en cuerpo
     */

    @GetMapping("/students")
    @ApiOperation("Obtiene todo")
    @ResponseBody
    public Iterable<Students> FindAll()
    {
        return studentsRepository.findAll();
    }

    /**
     *PUT /students: Actualiza un registro de students
     * @param TMO Objeto de students para el cuerpo de la solicitud
     * @param id variable de registro de student que va ser actualizado
     * @return devuelve la solicitud con estado 200 sin cuerpo o si id no existe, retorna la solicitud con estado 404
     */

    @PutMapping("/students/{id}")
    @ApiOperation("Actualiza registro")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Object> Update(@RequestBody Students TMO, @PathVariable Integer id)
    {
        Optional<Students> OT = studentsRepository.findById(id);
        if (!OT.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        TMO.setStudentId(id);
        studentsRepository.save(TMO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * DELETE /: Elimina un registro de students
     * @param id id de registro que va ser eliminado
     * @return retorna estado de la solicitud con estado 200
     */

    @ApiOperation("Elimina registro")
    @DeleteMapping("/students/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteID(@PathVariable Integer id)
    {
        Optional<Students> OT = studentsRepository.findById(id);
        if (!OT.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        studentsRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    

}
