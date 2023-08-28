package com.ProyectToDoList.backend.Shared;

import com.ProyectToDoList.backend.DTO.CategoryBasicDataDTO;
import com.ProyectToDoList.backend.DTO.NoteWithCategory;
import com.ProyectToDoList.backend.DTO.UserDTO;
import com.ProyectToDoList.backend.Models.CategoryModel;
import com.ProyectToDoList.backend.Models.NoteModel;
import com.ProyectToDoList.backend.Models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class TransformModelToDTO {
    public static List<CategoryBasicDataDTO> getTransformCategoryModelToCategoryBasicDataDTO(List<CategoryModel> categoryModel){
        List<CategoryBasicDataDTO> categoryBasicDataDTO=new ArrayList<>();

        for(CategoryModel category: categoryModel){
            categoryBasicDataDTO.add(new CategoryBasicDataDTO(
                    category.getId(),
                    category.getName(),
                    category.getDescription()
            ));
        }
        return categoryBasicDataDTO;
    }
    public static UserDTO getTransformUserModelToDTO(UserModel userModel){
        UserDTO categoryBasicDataDTO=new UserDTO(userModel.getId());


        return categoryBasicDataDTO;
    }
    public static NoteWithCategory getTransformNoteModelToNoteWithCategory(NoteModel noteModel){

        NoteWithCategory noteWithCategory=new NoteWithCategory(
                noteModel.getId(),
                noteModel.getTitle(),
                noteModel.getContent(),
                noteModel.getCreateDate(),
                noteModel.getModifyDate(),
                noteModel.isArchived(),
                getTransformCategoryModelToCategoryBasicDataDTO(noteModel.getCategories()));

        return noteWithCategory;
    }
}
