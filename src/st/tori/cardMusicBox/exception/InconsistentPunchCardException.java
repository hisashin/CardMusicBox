package st.tori.cardMusicBox.exception;

import st.tori.cardMusicBox.AbstractBox;
import st.tori.cardMusicBox.PunchCard;

@SuppressWarnings("serial")
public class InconsistentPunchCardException extends Exception {

	AbstractBox box;
	PunchCard card;
	
	public InconsistentPunchCardException(AbstractBox box, PunchCard card) {
		this.box = box;
		this.card = card;
	}
	
	public AbstractBox getBox() {	return box;	}
	public PunchCard getPunchCard() { return card; }

}
