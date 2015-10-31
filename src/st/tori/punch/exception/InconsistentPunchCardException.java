package st.tori.punch.exception;

import st.tori.punch.AbstractPunchReader;
import st.tori.punch.PunchCard;

@SuppressWarnings("serial")
public class InconsistentPunchCardException extends Exception {

	AbstractPunchReader reader;
	PunchCard card;
	
	public InconsistentPunchCardException(AbstractPunchReader reader, PunchCard card) {
		this.reader = reader;
		this.card = card;
	}
	
	public AbstractPunchReader getReader() {	return reader;	}
	public PunchCard getPunchCard() { return card; }

}
