package st.tori.punch;

import st.tori.punch.exception.InconsistentPunchCardException;

public abstract class AbstractPunchReader {

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
