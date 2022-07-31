package com.example.webtask.controller;

import com.example.webtask.model.Task;
import com.example.webtask.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;


@Controller
public class TaskController {
    @Autowired
    private ITaskService iTaskService;

    @GetMapping("/tasks")
    public String search(Model model, @RequestParam("p") Optional<Integer> p, HttpServletRequest request){
        String action = request.getParameter("action")==null ? "" : request.getParameter("action");
        String actionView = request.getParameter("action")==null ? "All" : request.getParameter("action");
        String search = request.getParameter("search")==null ? "" : request.getParameter("search");
        if(action.equals("All")) {action = "";}
        Pageable pageable = PageRequest.of(p.orElse(0), 2);
        Page<Task> page = iTaskService.getTaskPaginate(search, action, pageable);
        model.addAttribute("page", page);
        model.addAttribute("search", search);
        model.addAttribute("action", action);
        model.addAttribute("actionView", actionView);
        return "index";
    }

    @GetMapping("/addtask")
    public String addTask(){
        return "addtask";
    }
    @PostMapping("/addtask")
    public String checkExistTask(@ModelAttribute Task task, Model model){
        if(iTaskService.checkExistTask(task.getTaskName()) == null){
                task.setTaskStatus("open");
                iTaskService.save(task);
                return "redirect:/tasks";
        }else {
                model.addAttribute("error","Đã tồn tại Task !!!");
        }
        return "addtask";
    }
}
