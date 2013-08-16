package eu.lestard.notes.entity;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.junit.Test;

public class NoteTest {
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetNameFailEmpty(){
		Note note = new Note();
		
		note.setName("");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetNameFailNull(){
		Note note = new Note();
		
		note.setName(null);
	}
	
	
	@Test
	public void testEqualsAndHashcode(){
		EqualsVerifier.forClass(Note.class)
			.suppress(Warning.NONFINAL_FIELDS).usingGetClass().verify();
	}

}
