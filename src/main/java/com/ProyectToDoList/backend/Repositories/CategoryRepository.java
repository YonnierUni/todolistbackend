package com.ProyectToDoList.backend.Repositories;

import com.ProyectToDoList.backend.Models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
    CategoryModel findByName(String name);
    @Query(value = "SELECT DISTINCT c.id, c.name, c.description\n" +
            "FROM public.user u\n" +
            "JOIN public.note n ON u.id = n.user_id\n" +
            "JOIN public.note_category nc ON n.id = nc.note_id\n" +
            "JOIN public.category c ON nc.category_id = c.id\n" +
            "WHERE u.id = :userId\n"+
            "ORDER BY c.id ASC", nativeQuery = true)
    public abstract List<CategoryModel> getAllCategoriesByUser(@Param("userId") Long userId);

    @Query(value = "SELECT c.id, c.name, c.description\n" +
            "FROM public.note n\n" +
            "JOIN public.note_category nc ON n.id = nc.note_id\n" +
            "JOIN public.category c ON nc.category_id = c.id\n" +
            "WHERE n.id = :noteId\n"+
            "ORDER BY c.id ASC", nativeQuery = true)
    public abstract List<CategoryModel> getAllCategoriesByNote(@Param("noteId") Long noteId);
}
