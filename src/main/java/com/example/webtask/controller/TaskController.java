package com.example.webtask.controller;

import com.example.webtask.model.Task;
import com.example.webtask.service.TaskService;
import com.example.webtask.service.impl.TaskServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskServiceImpl taskService;

    @GetMapping("/tasks")
    public String search(Model model, @RequestParam("p") Optional<Integer> p, HttpServletRequest request){
        String status = request.getParameter("status")==null ? "" : request.getParameter("status");
        String statusView = request.getParameter("status")==null ? "All" : request.getParameter("status");
        String search = request.getParameter("search")==null ? "" : request.getParameter("search");

        if(status.equals("All")) {status = "";}
        Pageable pageable = PageRequest.of(p.orElse(0), 2);
        List<Task> tasks = taskService.findAllByPage(search, status, pageable);
        Page<Task> page = new PageImpl<>(tasks,pageable,taskService.countTask());

        model.addAttribute("page", page);
        model.addAttribute("search", search);
        model.addAttribute("status", status);
        model.addAttribute("statusView", statusView);
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
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "editTask";
    }
    @PostMapping("/editTask/{id}")
    public String editTask(@PathVariable("id") Integer id, BindingResult bindingResult,
                           @ModelAttribute("task") Task task, Model model){
        if(bindingResult.hasErrors()) {
            return "editTask";
        }
        taskService.update(task);
        return "redirect:/tasks";
    }
}
