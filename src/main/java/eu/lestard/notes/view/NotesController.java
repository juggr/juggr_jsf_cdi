package eu.lestard.notes.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import eu.lestard.notes.entity.Note;
import eu.lestard.notes.service.NoteService;

/**
 * Controller class to save new notes and synchronize the view with the values
 * of the NoteService
 * 
 * @author manuel
 * 
 */
@Named
public class NotesController {

	private final NotesBackingBean backingBean;

	private final NoteService noteService;

	@Inject
	public NotesController(final NotesBackingBean backingBean,
			final NoteService noteService) {
		if (backingBean == null) {
			throw new IllegalArgumentException(
					"Argument NotesBackingBean was null");
		}

		if (noteService == null) {
			throw new IllegalArgumentException("Argument NoteService was null");
		}
		this.backingBean = backingBean;
		this.noteService = noteService;
	}

	@PostConstruct
	@SuppressWarnings("unused")
	private void postConstruct() {
		synchronizeNotes();
	}

	public void addNote() {
		String name = backingBean.getName();
		String content = backingBean.getContent();

		Note note = new Note();
		note.setName(name);
		note.setContent(content);

		noteService.addNote(note);

		synchronizeNotes();
	}

	private void synchronizeNotes() {
		List<Note> notes = noteService.findAll();

		backingBean.setNotes(notes);
	}

}
