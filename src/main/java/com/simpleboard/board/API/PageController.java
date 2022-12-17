package com.simpleboard.board.API;

import com.simpleboard.board.Interface.BoardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PageController {

    @GetMapping("/write")
    public ModelAndView writePage() {
        ModelAndView view = new ModelAndView();
        view.setViewName("/write.html");
        return view;
    }

    @GetMapping(value = "/view")
    public ModelAndView view() {
        ModelAndView view = new ModelAndView();
        view.setViewName("/view.html");
        return view;
    }

}
