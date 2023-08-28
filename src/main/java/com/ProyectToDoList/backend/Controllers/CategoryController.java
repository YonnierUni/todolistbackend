package com.ProyectToDoList.backend.Controllers;

import com.ProyectToDoList.backend.DTO.CategoryBasicDataDTO;
import com.ProyectToDoList.backend.Services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @GetMapping("/get-all")
    public List<CategoryBasicDataDTO> getAllCategories(){
        return categoryService.getCategories();
    }
    @GetMapping("/get-all-by-user/{userId}")
    public List<CategoryBasicDataDTO> getAllCategoriesByUser(@PathVariable Long userId){
        return categoryService.getAllCategoriesByUser(userId);
    }
    @GetMapping("/get-all-by-note/{noteId}")
    public List<CategoryBasicDataDTO> getAllCategoriesByNote(@PathVariable Long noteId){
        return categoryService.getAllCategoriesByNote(noteId);
    }
}
