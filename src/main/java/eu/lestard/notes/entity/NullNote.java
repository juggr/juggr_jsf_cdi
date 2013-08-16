package eu.lestard.notes.entity;

/**
 * Null-Object class for the note entity.
 * 
 * @author manuel
 * 
 */
public class NullNote extends Note {

	private static Note instance;

	private NullNote() {
	}

	/**
	 * Singleton factory method.
	 * 
	 * @return
	 */
	public static Note getInstance() {
		if (instance == null) {
			instance = new NullNote();
		}

		return instance;
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public void setName(final String name) {
	};

	@Override
	public String getContent() {
		return "";
	}

	@Override
	public void setContent(final String content) {
	};

}
