package eu.lestard.notes.service;

import java.util.List;

import eu.lestard.notes.entity.Note;

/**
 * Service class for all actions on notes.
 * 
 * @author manuel
 * 
 */
public interface NoteService {

	/**
	 * Adds a note to the system. If the given note is an instance of NullNote,
	 * the note is not saved.
	 * 
	 * If there is already a note with the given name (<code>Note.name</code>)
	 * the note old note is replaced with the new one.
	 * 
	 * @param note
	 *            the instance that should be added.
	 * 
	 * @throws IllegalArgumentException
	 *             if the note is <code>null</code>
	 */
	void addNote(final Note note);

	/**
	 * 
	 * @param name
	 *            the name of the note that should be found.
	 * @return the note instance with the given name or an instance of
	 *         <code>NullNote</code> if there is no note saved with the given
	 *         name.
	 * 
	 * @throws IllegalArgumentException
	 *             if the given name is null or empty (
	 *             <code>name.length() == 0</code>)
	 */
	Note findByName(final String name);

	/**
	 * 
	 * @return an unmodifiable List of all saved notes.
	 */
	List<Note> findAll();

}
