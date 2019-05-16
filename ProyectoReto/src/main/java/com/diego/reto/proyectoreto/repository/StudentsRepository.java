package com.diego.reto.proyectoreto.repository;

import com.diego.reto.proyectoreto.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jcumpale on 14/05/2019.
 */

/**
 * Interfaz de la entidad Families para instanciar métodos CRUD y adicionales
 * @author jcumpale
 * version 1.0
 */
@Repository
public interface StudentsRepository extends JpaRepository<Students,Integer> {
}
