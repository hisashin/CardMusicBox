package st.tori.cardMusicBox.exception;

import st.tori.cardMusicBox.AbstractMusicBox;
import st.tori.cardMusicBox.MusicCard;

@SuppressWarnings("serial")
public class InconsistentCardException extends Exception {

	AbstractMusicBox box;
	MusicCard card;
	
	public InconsistentCardException(AbstractMusicBox box, MusicCard card) {
		this.box = box;
		this.card = card;
	}
	
	public AbstractMusicBox getMusicBox() {	return box;	}
	public MusicCard getMusicCard() { return card; }

}
