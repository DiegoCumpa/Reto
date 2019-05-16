package com.diego.reto.proyectoreto.controller;

/**
 * Created by jcumpale on 14/05/2019.
 */

import com.diego.reto.proyectoreto.model.Families;
import com.diego.reto.proyectoreto.model.FamilyMembers;
import com.diego.reto.proyectoreto.model.Parents;
import com.diego.reto.proyectoreto.repository.FamiliesRepository;
import com.diego.reto.proyectoreto.repository.FamilyMembersRepository;
import com.diego.reto.proyectoreto.repository.ParentsRepository;
import com.sun.corba.se.spi.ior.Writeable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Clase Controlador de la entidad Families para el manejo de solicitudes HTTP
 * @author jcumpale
 * version 1.0
 */
@RestController
@RequestMapping(path = "ProyectoReto/api/v1")
@Api(value = "FamiliesControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE )
public class FamiliesController {

    /**
     * Injección de dependencia para instanciar métodos desde FamiliesRepository
     */
    @Autowired
    private FamiliesRepository familiesRepository;


    /**
     * Injección de dependencia para instanciar métodos desde ParentsRepository
     */
    @Autowired
    private ParentsRepository parentsRepository;

    @Autowired
    private FamilyMembersRepository familyMembersRepository;

    /**
     * POST /families:Crear un nuevo registro de families
     * @param f : Objeto de Families para el requestbody
     * @id : variable de id de parent
     * @return Retorna la solicitud con estado 201(Created) y con el body de Families o
     * si el id ya existe, retorna la solicitud con estado 400(Bad Request)
     */

    @PostMapping("/families/{id}")
    @ApiOperation("Inserta Registro")
    @ResponseBody
    public ResponseEntity<Object> Create(@RequestBody Families f,@PathVariable Integer id)
    {
        Optional<Parents> OT = parentsRepository.findById(id);
        if (!OT.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        familiesRepository.save(f);
        return new ResponseEntity<>(f,HttpStatus.CREATED);
    }

    /**
     * GET /families: Obtiene todos los families
     * @return Retorna la solicitud con estado 200 y con la lista de families en cuerpo
     */

    @GetMapping("/families")
    @ApiOperation("Obtiene todo")
    @ResponseBody
    public Iterable<Families> FindAll()
    {
        return familiesRepository.findAll();
    }

    /**
     *PUT /families: Actualiza un registro de families
     * @param TMO Objeto de families para el cuerpo de la solicitud
     * @param idparent variable de registro de parent que va ser actualizado
     * @param idfamily variable de registro de familie que va ser actualizado
     * @return devuelve la solicitud con estado 200 sin cuerpo o si id no existe, retorna la solicitud con estado 404
     */

    @PutMapping("/families/{idparent}/{idfamily}")
    @ApiOperation("Actualiza registro")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Object> Update(@RequestBody Families TMO, @PathVariable Integer idparent, @PathVariable Integer idfamily)
    {
        Optional<Parents> OT = parentsRepository.findById(idparent);
        if (!OT.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Optional<Families> OTF = familiesRepository.findById(idfamily);
        if (!OT.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        TMO.setFamilyId(idfamily);
        familiesRepository.save(TMO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * DELETE /: Elimina un registro de families
     * @param id id de registro que va ser eliminado
     * @return retorna estado de la solicitud con estado 200 o si no encuentra id retorna solicitud con estado 404
     */

    @DeleteMapping("/families/{id}")
    @ApiOperation("Elimina registro")
    @ResponseBody
    public ResponseEntity<Object> deleteID(@PathVariable Integer id)
    {
        Optional<Families> OT = familiesRepository.findById(id);
        if (!OT.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        familiesRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    
}
