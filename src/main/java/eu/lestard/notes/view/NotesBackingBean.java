package eu.lestard.notes.view;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import eu.lestard.notes.entity.Note;

/**
 * Backing bean that holds the data needed by the view.
 * 
 * @author manuel
 * 
 */
@Named
@SessionScoped
public class NotesBackingBean implements Serializable {

	private static final long serialVersionUID = -7065449337339482947L;

	private List<Note> notes;

	private String name;
	private String content;

	public NotesBackingBean() {
		notes = Collections.emptyList();
	}

	public List<Note> getNotes() {
		return Collections.unmodifiableList(notes);
	}

	public void setNotes(final List<Note> notes) {
		this.notes = notes;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(final String content) {
		this.content = content;
	}

}
