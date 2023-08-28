package com.ProyectToDoList.backend.Controllers;

import com.ProyectToDoList.backend.DTO.NoteBasicDataDTO;
import com.ProyectToDoList.backend.DTO.NoteWithCategory;
import com.ProyectToDoList.backend.Models.NoteModel;
import com.ProyectToDoList.backend.Services.NoteService;
import com.ProyectToDoList.backend.Shared.ResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/note")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }
    @GetMapping("/get-by-user/{userId}/{noteId}")
    public NoteWithCategory getNoteByUser(@PathVariable Long userId, @PathVariable Long noteId){

        return noteService.getNoteByUser(userId, noteId);
    }
    @GetMapping("/get-all-by-user-isarchived/{userId}/{isArchived}")
    @ResponseBody
    public List<NoteBasicDataDTO> getAllNotesByUserIdAndIsArchived(@PathVariable Long userId,@PathVariable boolean isArchived){

        return noteService.getAllNotesByUserIdAndIsArchived(userId,isArchived);
    }
    @GetMapping("/get-all-by-user-category-isarchived/{userId}/{categoryId}/{isArchived}")
    public List<NoteBasicDataDTO> getAllNotesByUserAndCategoryAndIsArchived(@PathVariable Long userId, @PathVariable Long categoryId, @PathVariable boolean isArchived){

        return noteService.getAllNotesByUserAndCategoryAndIsArchived(userId, categoryId, isArchived);
    }
    @PostMapping("/save-note")
    public NoteWithCategory saveNote(@RequestBody NoteModel noteModel){
        /*insert, update for note and category*/
        return noteService.saveNote(noteModel);
    }
    @DeleteMapping("/delete-note")
    public ResponseDTO deleteNote(@RequestBody NoteModel noteModel){
        /*insert, update for note and category*/
        return noteService.deleteNote(noteModel);
    }
    @DeleteMapping("/delete-note-by-id/{id}")
    public ResponseDTO deleteNote(@PathVariable Long id){
        /*insert, update for note and category*/
        return noteService.deleteNoteById(id);
    }
    @PutMapping("/archive-note-by-id/{noteId}/{isArchived}")
    public ResponseDTO archiveNote(@PathVariable Long noteId, @PathVariable boolean isArchived){
        /*insert, update for note and category*/
        return noteService.archiveNoteById(noteId,isArchived);
    }
}
