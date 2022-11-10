package com.ansh.todo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ansh.todo.model.TodoItem;

@Controller
public class TodoController {
    List<TodoItem> todoItems = new ArrayList<>();

    @GetMapping("")
    public String homePage(Model model) {
        model.addAttribute("items", todoItems);
        System.out.println(todoItems);

        return "index";
    }

    @GetMapping("/add")
    public String addPage(Model model) {
        TodoItem blankItem = new TodoItem();
        model.addAttribute("blankItem", blankItem);
        return "add";
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute("blankItem") TodoItem item) {
        todoItems.add(item);
        return "redirect:/";
    }

}
