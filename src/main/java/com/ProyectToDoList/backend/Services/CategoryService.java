package com.ProyectToDoList.backend.Services;

import com.ProyectToDoList.backend.DTO.CategoryBasicDataDTO;
import com.ProyectToDoList.backend.Models.CategoryModel;
import com.ProyectToDoList.backend.Repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryBasicDataDTO> getCategories(){
        try {
            List<CategoryModel>  categories = categoryRepository.findAll();
            List<CategoryBasicDataDTO> categoriesDTO=new ArrayList<>();

            for(CategoryModel category: categories){
            categoriesDTO.add(new CategoryBasicDataDTO(category.getId(),category.getName(),category.getDescription()));
            }
            return categoriesDTO;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<CategoryBasicDataDTO> getAllCategoriesByUser(Long userId){
        try {
            List<CategoryModel>  categories = categoryRepository.getAllCategoriesByUser(userId);
            List<CategoryBasicDataDTO> categoriesDTO=new ArrayList<>();

            for(CategoryModel category: categories){
                categoriesDTO.add(new CategoryBasicDataDTO(category.getId(),category.getName(),category.getDescription()));
            }
            return categoriesDTO;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<CategoryBasicDataDTO> getAllCategoriesByNote(Long noteId){
        try {
            List<CategoryModel>  categories = categoryRepository.getAllCategoriesByNote(noteId);
            List<CategoryBasicDataDTO> categoriesDTO=new ArrayList<>();

            for(CategoryModel category: categories){
                categoriesDTO.add(new CategoryBasicDataDTO(category.getId(),category.getName(),category.getDescription()));
            }
            return categoriesDTO;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
