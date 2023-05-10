package com.study.board01.controller.repository;

import com.study.board01.controller.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository <Board,Integer>{

}
