package eu.lestard.notes.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;

import eu.lestard.notes.entity.Note;
import eu.lestard.notes.entity.NullNote;

@SessionScoped
public class NoteServiceImpl implements NoteService, Serializable {

	private static final long serialVersionUID = 3122100380644982038L;

	private final Map<String, Note> notes = new HashMap<String, Note>();

	@Override
	public void addNote(final Note note) {
		if (note == null) {
			throw new IllegalArgumentException("Argument note must not be null");
		}

		if (!(note instanceof NullNote)) {
			notes.put(note.getName(), note);
		}

	}

	@Override
	public Note findByName(final String name) {
		if (name == null) {
			throw new IllegalArgumentException("Argument name must not be null");
		}

		if (name.length() == 0) {
			throw new IllegalArgumentException(
					"Argument name must not be empty");
		}

		Note note = notes.get(name);

		if (note == null) {
			note = NullNote.getInstance();
		}

		return note;
	}

	@Override
	public List<Note> findAll() {

		List<Note> noteList = new ArrayList<Note>(notes.values());

		return Collections.unmodifiableList(noteList);
	}

}
