package com.tummala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tummala.entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
