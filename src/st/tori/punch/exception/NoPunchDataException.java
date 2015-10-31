package st.tori.punch.exception;

import st.tori.punch.AbstractPunchData;

@SuppressWarnings("serial")
public class NoPunchDataException extends Exception {

	AbstractPunchData data;
	
	public NoPunchDataException(AbstractPunchData data) {
		this.data = data;
	}

}
