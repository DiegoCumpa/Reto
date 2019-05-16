package com.diego.reto.proyectoreto.controller;

import com.diego.reto.proyectoreto.model.Families;
import com.diego.reto.proyectoreto.model.FamilyMembers;
import com.diego.reto.proyectoreto.model.Parents;
import com.diego.reto.proyectoreto.model.Students;
import com.diego.reto.proyectoreto.repository.FamiliesRepository;
import com.diego.reto.proyectoreto.repository.FamilyMembersRepository;
import com.diego.reto.proyectoreto.repository.ParentsRepository;
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
 * Clase Controlador de la entidad Families para el manejo de solicitudes HTTP
 * Created by jcumpale on 14/05/2019.
 * version 1.0
 */

/**
 * @author jcumpale
 */
@RestController
@RequestMapping(path = "ProyectoReto/api/v1")
@Api(value = "FamilyMembersAPI", produces = MediaType.APPLICATION_JSON_VALUE )
public class FamilyMembersController {

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

    /**
     * Injección de dependencia para instanciar métodos desde StudentsRepository
     */
    @Autowired
    private StudentsRepository studentsRepository;

    /**
     * Injección de dependencia para instanciar métodos desde FamilyMembersRepository
     */
    @Autowired
    private FamilyMembersRepository familyMembersRepository;

    /**
     * POST /familymembers:Crear un nuevo registro de families
     * @param fm Objeto de FamilyMembers para el requestbody
     * @param familyid variable de family
     * @param parentid variable de parent
     * @param studentid variable de student
     * @return Retorna la solicitud con estado 201(Created) y con el body de FamilyMembers o
     * si el idfamilymember ya existe, retorna la solicitud con estado 400(Bad Request)
     */

    @PostMapping("/familymembers/{familyid}/{parentid}/{studentid}")
    @ApiOperation("Inserta Registro")
    @ResponseBody
    public ResponseEntity<Object> Create(@RequestBody FamilyMembers fm, @PathVariable Integer familyid, @PathVariable Integer parentid, @PathVariable Integer studentid)
    {
        Optional<Families> OT = familiesRepository.findById(familyid);
        if (!OT.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Optional<Parents> OTP = parentsRepository.findById(parentid);
        if (!OTP.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Optional<Students> OTS = studentsRepository.findById(studentid);
        if (!OTS.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


        familyMembersRepository.save(fm);
        return new ResponseEntity<>(fm,HttpStatus.CREATED);
    }

    /**
     * GET /familymembers: Obtiene todos los familymembers
     * @return Retorna la solicitud con estado 200 y con la lista de familymembers en cuerpo
     */

    @GetMapping("/familymembers")
    @ApiOperation("Obtiene todo")
    @ResponseBody
    public Iterable<FamilyMembers> FindAll()
    {
        return familyMembersRepository.findAll();
    }

    /**
     * PUT /familymembers: Actualiza un registro de familymembers
     * @param TMO Objeto de familymember para el cuerpo de la solicitud
     * @param idfamily id de family que va ser actualizado
     * @param idparent id de parent que va ser actualizado
     * @param idstudent id de student que va ser actualizado
     * @param idfamilymember id de family member que va ser actualizado
     * @return devuelve la solicitud con estado 200 sin cuerpo o si algunos de los ids no existen, retorna la solicitud con estado 404
     */

    @PutMapping("/familymembers/{idfamily}/{idparent}/{idstudent}/{idfamilymember}")
    @ApiOperation("Actualiza registro")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Object> Update(@RequestBody FamilyMembers TMO,@PathVariable Integer idfamily,@PathVariable Integer idparent,@PathVariable Integer idstudent,@PathVariable Integer idfamilymember)
    {
        Optional<Families> OTF = familiesRepository.findById(idfamily);
        if (!OTF.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Optional<Parents> OT = parentsRepository.findById(idparent);
        if (!OT.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Optional<Students> OTS = studentsRepository.findById(idstudent);
        if (!OTS.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        TMO.setFamilyMemberId(idfamilymember);
        familyMembersRepository.save(TMO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * DELETE /: Elimina un registro de familyMembers
     * @param id id de registro que va ser eliminado
     * @return retorna estado de la solicitud con estado 200 o si no encuentra id retorna solicitud con estado 404
     */

    @DeleteMapping("/familymembers/{id}")
    @ApiOperation("Elimina Registro")
    @ResponseBody
    public ResponseEntity<Object> deleteID(@PathVariable Integer id)
    {
        Optional<FamilyMembers> OT = familyMembersRepository.findById(id);
        if (!OT.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        familyMembersRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
