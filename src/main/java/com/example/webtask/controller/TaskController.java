package com.example.webtask.controller;

import com.example.webtask.model.Task;
import com.example.webtask.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
//@RequestMapping("/")
public class TaskController {
    @Autowired
    private ITaskService iTaskService;

//    @ResponseBody
    @GetMapping("/tasks")
    public String showTaskList(Model model){
        return findPaginated(0,model);
    }

    @GetMapping("/tasks/page/{pageno}")
    public String findPaginated(@PathVariable int pageno, Model model){
        Page<Task>  page = iTaskService.getTaskPaginate(pageno, 2);

        model.addAttribute("listTasks", page);
        model.addAttribute("currentPage", pageno);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItem", page.getTotalElements());
        return "index";
    }
}
