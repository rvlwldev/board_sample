package com.simpleboard.board.API;

import com.simpleboard.board.Entity.BoardEntity;
import com.simpleboard.board.Interface.BoardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ViewController {

    @Autowired
    BoardRepo repo;

    @GetMapping("/write")
    public ModelAndView writePage() {
        ModelAndView view = new ModelAndView();
        view.setViewName("/write.html");
        return view;
    }

    @GetMapping(value = "view/{seq}")
    public BoardEntity view(@PathVariable String seq) {
        return repo.findById(Long.getLong(seq)).get();
    }

}
