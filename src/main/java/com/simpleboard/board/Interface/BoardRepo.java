package com.simpleboard.board.Interface;

import com.simpleboard.board.Entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepo extends JpaRepository<BoardEntity, Long> {
}
