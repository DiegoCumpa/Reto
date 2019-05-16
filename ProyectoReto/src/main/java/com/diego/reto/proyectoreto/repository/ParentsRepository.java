package com.diego.reto.proyectoreto.repository;

import com.diego.reto.proyectoreto.model.Parents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jcumpale on 13/05/2019.
 */

/**
 * Interfaz de la entidad Parents para instanciar métodos CRUD y adicionales
 * @author jcumpale
 * version 1.0
 */
@Repository
public interface ParentsRepository extends JpaRepository<Parents,Integer> {
}
