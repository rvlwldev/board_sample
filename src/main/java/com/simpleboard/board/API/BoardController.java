package com.simpleboard.board.API;

import com.simpleboard.board.Entity.BoardEntity;
import com.simpleboard.board.Interface.BoardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
public class BoardController {

    @Autowired
    BoardRepo repo;

    public ResponseEntity<?> goMain(){
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/"));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

    @PostMapping(value = "/list")
    @ResponseBody
    public List<BoardEntity> list() {
        List<BoardEntity> list = repo.findAll();
        return list;
    }

    @PostMapping(value = "/registry")
    public ResponseEntity<?> registry(BoardEntity board) {
        board.setDate(new Date());
        repo.save(board);
        return goMain();
    }

}
