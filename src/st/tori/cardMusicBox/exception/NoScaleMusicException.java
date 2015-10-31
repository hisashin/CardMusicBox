package st.tori.cardMusicBox.exception;

import st.tori.cardMusicBox.AbstractMusic;

@SuppressWarnings("serial")
public class NoScaleMusicException extends Exception {

	AbstractMusic music;
	
	public NoScaleMusicException(AbstractMusic music) {
		this.music = music;
	}

}
