package st.tori.cardMusicBox;

import st.tori.cardMusicBox.exception.InconsistentPunchCardException;

public abstract class AbstractBox {

	public abstract int getScaleSize();
	
	protected PunchCard card;
	
	public void setPunchCard(PunchCard card) throws InconsistentPunchCardException {
		if(card==null||card.getPunchData().getScalePositionArray().length!=getScaleSize())
			throw new InconsistentPunchCardException(this, card);
		this.card = card;
	}
	public PunchCard getPunchCard() {
		return card;
	}

}
