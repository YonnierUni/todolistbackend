package com.ProyectToDoList.backend.Services;

import com.ProyectToDoList.backend.DTO.NoteBasicDataDTO;
import com.ProyectToDoList.backend.DTO.NoteWithCategory;
import com.ProyectToDoList.backend.Models.NoteModel;
import com.ProyectToDoList.backend.Repositories.CategoryRepository;
import com.ProyectToDoList.backend.Repositories.NoteRepository;
import com.ProyectToDoList.backend.Shared.*;
import com.ProyectToDoList.backend.Shared.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.ProyectToDoList.backend.Shared.TransformModelToDTO.*;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final CategoryRepository categoryRepository;

    public NoteService(NoteRepository noteRepository, CategoryRepository categoryRepository){
        this.noteRepository = noteRepository;
        this.categoryRepository = categoryRepository;
    }

    public NoteWithCategory getNoteByUser(Long userId, Long noteId ){
        try {
            NoteModel note = noteRepository.getNoteByUser(userId, noteId);
            NoteWithCategory noteWithCategory = new NoteWithCategory(
                    note.getId(),
                    note.getTitle(),
                    note.getContent(),
                    note.getCreateDate(),
                    note.getModifyDate(),
                    note.isArchived(),
                    getTransformCategoryModelToCategoryBasicDataDTO(categoryRepository.getAllCategoriesByNote(noteId))
            );

            return noteWithCategory;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public List<NoteBasicDataDTO> getAllNotesByUserIdAndIsArchived(Long userId,boolean isArchived){
        try {
            List<NoteModel> notes = noteRepository.getAllNotesByUserIdAndIsArchived(userId, isArchived);
            List<NoteBasicDataDTO> noteBasicDataDTO=new ArrayList<>();

            for(NoteModel note: notes){
                noteBasicDataDTO.add(new NoteBasicDataDTO(
                        note.getId(),
                        note.getTitle(),
                        note.getContent(),
                        note.getCreateDate(),
                        note.getModifyDate(),
                        note.isArchived()
                ));
            }
            return noteBasicDataDTO;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<NoteBasicDataDTO> getAllNotesByUserAndCategoryAndIsArchived(Long userId, Long categoryId, boolean isArchived ){
        try {
            List<NoteModel> notes = noteRepository.getAllNotesByUserAndCategoryAndIsArchived(userId, categoryId, isArchived);
            List<NoteBasicDataDTO> noteBasicDataDTO=new ArrayList<>();

            for(NoteModel note: notes){
                noteBasicDataDTO.add(new NoteBasicDataDTO(
                        note.getId(),
                        note.getTitle(),
                        note.getContent(),
                        note.getCreateDate(),
                        note.getModifyDate(),
                        note.isArchived()
                ));
            }
            return noteBasicDataDTO;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public NoteWithCategory saveNote(NoteModel noteModel){
        try {
            noteModel.setModifyDate(new Date());
            noteModel.setCreateDate(new Date());
            NoteModel note = noteRepository.save(noteModel);

            NoteWithCategory noteWithCategory = new NoteWithCategory(
                    note.getId(),
                    note.getTitle(),
                    note.getContent(),
                    note.isArchived(),
                    getTransformCategoryModelToCategoryBasicDataDTO(categoryRepository.getAllCategoriesByNote(note.getId())),
                    getTransformUserModelToDTO(note.getUser())
            );

            return noteWithCategory;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public ResponseDTO deleteNote(NoteModel noteModel){
        try {
            Long noteId = noteModel.getId();
            noteRepository.delete(noteModel);

            if(!noteRepository.existsById(noteId)){
                return new ResponseDTO(true, "Note deleted successfully.");
            }else{
                return new ResponseDTO(false, "Failed to delete note: " + noteModel.getTitle());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public ResponseDTO deleteNoteById(Long noteId){
        try {
            noteRepository.deleteById(noteId);

            if(!noteRepository.existsById(noteId)){
                return new ResponseDTO(true, "Note deleted successfully.");
            }else{
                return new ResponseDTO(false, "Failed to delete note");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public ResponseDTO archiveNoteById(Long noteId, boolean isArchived){
        try {
            Optional<NoteModel> noteModel = noteRepository.findById(noteId);
            NoteModel note=noteModel.get();

            note.setArchived(isArchived);

            System.out.println(note.isArchived());

            noteRepository.save(note);
            return new ResponseDTO(true, "Note deleted successfully.");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
