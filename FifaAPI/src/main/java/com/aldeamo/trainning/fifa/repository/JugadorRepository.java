package com.aldeamo.trainning.fifa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aldeamo.trainning.fifa.entity.Jugador;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long>{

}
