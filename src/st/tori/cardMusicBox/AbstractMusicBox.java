package st.tori.cardMusicBox;

import st.tori.cardMusicBox.exception.InconsistentCardException;

public abstract class AbstractMusicBox {

	public abstract int getScaleSize();
	
	protected MusicCard card;
	
	public void setMusicCard(MusicCard card) throws InconsistentCardException {
		if(card==null||card.getMusic().getScalePositionArray().length!=getScaleSize())
			throw new InconsistentCardException(this, card);
		this.card = card;
	}
	public MusicCard getMusicCard() {
		return card;
	}

}
