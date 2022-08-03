package com.example.webtask.controller;

import com.example.webtask.model.entity.Task;
import com.example.webtask.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/tasks")
    public String search(Model model, @RequestParam("p") Optional<Integer> p, HttpServletRequest request){
        String action = request.getParameter("action")==null ? "" : request.getParameter("action");
        String actionView = request.getParameter("action")==null ? "All" : request.getParameter("action");
        String search = request.getParameter("search")==null ? "" : request.getParameter("search");
        if(action.equals("All")) {action = "";}
        Pageable pageable = PageRequest.of(p.orElse(0), 2);
        Page<Task> page = taskService.getTaskPaginate(search, action, pageable);
        model.addAttribute("page", page);
        model.addAttribute("search", search);
        model.addAttribute("action", action);
        model.addAttribute("actionView", actionView);
        return "index";
    }

    @GetMapping("/addTask")
    public String addTask(Model model){
        model.addAttribute("task", new Task());
        return "addTask";
    }

    @PostMapping("/addTask")
    public String checkExistTask(@Valid Task task, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "addTask";
        }
        else if(taskService.checkExistTask(task.getTaskName()) == null){
                taskService.insertTask(task);
                return "redirect:/tasks";
        }else {
                model.addAttribute("error","Đã tồn tại Task !!!");
        }
        model.addAttribute("task", new Task());
        return "addTask";
    }


    @GetMapping("/editTask/{id}")
    public String showEditTask(Model model, @PathVariable("id") Integer id) {
        Task task = taskService.get(id);
        model.addAttribute("task", task);
        return "editTask";
    }
    @PostMapping("/editTask/{id}")
    public String editTask(@PathVariable("id") Integer id, BindingResult bindingResult,
                           @ModelAttribute("task") Task task){
        if(bindingResult.hasErrors()) {
            return "editTask";
        }
        taskService.update(task);
        return "redirect:/tasks";
    }
}
