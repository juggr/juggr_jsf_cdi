package eu.lestard.notes.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import eu.lestard.notes.entity.Note;
import eu.lestard.notes.entity.NullNote;
 
public class NotesServiceTest {

	private static final String NOTE_NAME2 = "myNote2";
	private static final String NOTE_CONTENT = "This is my Content";
	private static final String NOTE_NAME = "myNote1";

	@Test
	public void testAddNoteAndFindByName() {
		NoteService noteService = new NoteServiceImpl();
		
		Note note = new Note();
		
		note.setName(NOTE_NAME);
		note.setContent(NOTE_CONTENT);
		noteService.addNote(note);
		
		Note note2 = noteService.findByName(NOTE_NAME);

		assertEquals(NOTE_NAME, note2.getName());
		assertEquals(NOTE_CONTENT, note2.getContent());
	}
	
	@Test
	public void testFindByNameFailNoEntry(){
		NoteService noteService = new NoteServiceImpl();
		
		Note emptyNote = noteService.findByName(NOTE_NAME);
		
		assertNotNull(emptyNote);
		
		assertTrue(emptyNote instanceof NullNote);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testFindByNameFailNull(){
		NoteService noteService = new NoteServiceImpl();
		
		noteService.findByName(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFindByNameFailEmpty(){
		NoteService noteService = new NoteServiceImpl();
		
		noteService.findByName("");
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddNoteFailNull(){
		NoteService noteService = new NoteServiceImpl();
		noteService.addNote(null);
	}
	
	@Test
	public void testAddNoteNullObject(){
		NoteService noteService = new NoteServiceImpl();
		
		Note note = NullNote.getInstance();
		noteService.addNote(note);
		
		
		List<Note> notes = noteService.findAll();
		
		assertTrue(notes.isEmpty());
	}
	
	
	@Test
	public void testGetAll(){
		NoteService noteService = new NoteServiceImpl();
		
		Note note = new Note();
		note.setName(NOTE_NAME);
		note.setContent(NOTE_CONTENT);
		noteService.addNote(note);
		
		Note note2 = new Note();
		note2.setName(NOTE_NAME2);
		note2.setContent(NOTE_CONTENT);
		noteService.addNote(note2);
		
		List<Note> notes = noteService.findAll();
		assertEquals(2,notes.size());
		assertTrue(notes.contains(note));
		assertTrue(notes.contains(note2));
	}
	
	@Test
	public void testGetAllWithNoNotesSaved(){
		NoteService noteService = new NoteServiceImpl();
		
		List<Note> notes = noteService.findAll();
		
		assertNotNull(notes);
		
		assertTrue(notes.isEmpty());
		
	}
}
