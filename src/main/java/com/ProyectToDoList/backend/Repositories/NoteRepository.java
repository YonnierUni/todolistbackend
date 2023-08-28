package com.ProyectToDoList.backend.Repositories;

import com.ProyectToDoList.backend.Models.NoteModel;
import com.ProyectToDoList.backend.Shared.ResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<NoteModel, Long> {
    @Query(value = "SELECT n.* FROM public.note n WHERE n.user_id = :userId AND n.id = :noteId ORDER BY n.id ASC", nativeQuery = true)
    public abstract NoteModel getNoteByUser(@Param("userId") Long userId, @Param("noteId") Long noteId);
    @Query(value = "SELECT n.* FROM public.note n WHERE n.user_id = :userId AND n.is_archived = :isArchived ORDER BY n.id ASC", nativeQuery = true)
    public abstract List<NoteModel> getAllNotesByUserIdAndIsArchived(@Param("userId") Long userId, @Param("isArchived") boolean isArchived);

    @Query(value = "SELECT n.id, n.title, n.content, n.create_date, n.modify_date, n.is_archived, n.user_id\n" +
            "FROM public.note n\n" +
            "JOIN public.note_category nc ON n.id = nc.note_id\n" +
            "JOIN public.category c ON nc.category_id = c.id\n" +
            "WHERE c.id = :categoryId\n"+
            "AND n.user_id = :userId\n"+
            "AND n.is_archived = :isArchived\n"+
            "ORDER BY n.id ASC", nativeQuery = true)
    public abstract List<NoteModel> getAllNotesByUserAndCategoryAndIsArchived(@Param("userId") Long userId, @Param("categoryId") Long categoryId, @Param("isArchived") boolean isArchived);

}
