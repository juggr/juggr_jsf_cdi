package eu.lestard.notes.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import eu.lestard.notes.entity.Note;
import eu.lestard.notes.service.NoteService;

public class NotesControllerTest {
	
	
	private static final String MY_NOTE_NAME = "My Note 1";

	private static final String MY_NOTE_CONTENT = "My note content....";

	private NoteService noteService;
	
	private NotesBackingBean backingBean;
	
	
	@Test
	public void testAddNote(){
		
		this.backingBean = new NotesBackingBean();
		
		
		this.noteService = Mockito.mock(NoteService.class);
		NotesController controller = new NotesController(this.backingBean,this.noteService);
		
		this.backingBean.setName(MY_NOTE_NAME);
		this.backingBean.setContent(MY_NOTE_CONTENT);
		
		List<Note> notes = this.backingBean.getNotes();
		assertTrue(notes.isEmpty());
		
		// We need to setup the NoteService
		List<Note> notesInService = new ArrayList<Note>();
		Note tempNote = new Note();
		tempNote.setName(MY_NOTE_NAME);
		tempNote.setContent(MY_NOTE_CONTENT);
		notesInService.add(tempNote);
		Mockito.when(this.noteService.findAll()).thenReturn(notesInService);
		
		controller.addNote();
		
		Mockito.verify(this.noteService, Mockito.times(1)).addNote(Mockito.any(Note.class));
		
		notes = this.backingBean.getNotes();
		assertEquals(1, notes.size());
		
		Note note = notes.get(0);
		assertEquals(MY_NOTE_NAME,note.getName());
		assertEquals(MY_NOTE_CONTENT, note.getContent());
		
	}
	
}
