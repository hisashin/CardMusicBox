package st.tori.cardMusicBox.exception;

import st.tori.cardMusicBox.AbstractPunchData;

@SuppressWarnings("serial")
public class NoPunchDataException extends Exception {

	AbstractPunchData data;
	
	public NoPunchDataException(AbstractPunchData data) {
		this.data = data;
	}

}
