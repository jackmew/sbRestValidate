package org.jackho.sbRestValidate.controller;

import org.jackho.sbRestValidate.domain.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Petri Kainulainen
 */
@Controller
@RequestMapping("/restValidation")
public class CommentController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String start() {
		return "redirect:/views/comment.html";
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    @ResponseBody
    public Comment add(@Valid @RequestBody Comment comment) {
        System.out.println("Received comment: {} "+comment);
        return comment;
    }
}
