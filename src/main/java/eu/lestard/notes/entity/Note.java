package eu.lestard.notes.entity;

/**
 * Entity class for notes.
 * 
 * @author manuel
 *
 */
public class Note {
	
	private String name;
	private String content;
	
	public String getName() {
		return this.name;
	}
	
	/**
	 * Sets the name for this note instance. The name must not be empty or null.
	 * @param name the name of the note.
	 * 
	 * @throws IllegalArgumentException if the name is <code>null</code> or empty.
	 */
	public void setName(String name) {
		if(name == null){
			throw new IllegalArgumentException("Argument name must not be null");
		}
		
		if(name.length() == 0){
			throw new IllegalArgumentException("Argument name must not be empty");
		}
		
		this.name = name;
	}
	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public boolean equals(Object other){
		if(other == null){
			return false;
		}
		
		if(this == other){
			return true;
		}
		
		if(!(other instanceof Note)){
			return false;
		}
		
		if(!this.getClass().equals(other.getClass())){
			return false;
		}
		
		Note that = (Note)other;
		
		if(this.getName() != that.getName()){
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode(){
		if(this.getName() != null){
			return this.getName().hashCode();
		}
		return 1;
	}
}
