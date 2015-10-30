package st.tori.cardMusicBox;

import st.tori.cardMusicBox.goda.card.MusicMaripoFav;

public class MusicCard {

	private static MusicCardLayout DEFAULT_LAYOUT = new MusicCardLayout(Unit.MM, 2.75, 7.91, 2.99, 40, 6, 11, 6);
	
	protected AbstractMusic music;
	protected MusicCardLayout layout;
	
	public MusicCard(AbstractMusic music) {
		this.music = music;
		this.layout = DEFAULT_LAYOUT;
	}
	public MusicCard(AbstractMusic music, Unit unit, double holeDiameter, double xStep, double yStep, double xSpaceLeft, double ySpaceBottom, double xSpaceRight, double ySpaceTop) {
		this.music = music;
		this.layout = new MusicCardLayout(unit, holeDiameter, xStep, yStep, xSpaceLeft, ySpaceBottom, xSpaceRight, ySpaceTop);
	}
	
	public MusicCardLayout getLayout() {
		return layout;
	}

	public static enum Unit {
		MM,
		INCH,
	}
	public static class MusicCardLayout {
		
		Unit unit;
		double holeDiameter;
		double xStep;
		double yStep;
		double xSpaceLeft;
		double ySpaceBottom;
		double xSpaceRight;
		double ySpaceTop;
		
		public MusicCardLayout(Unit unit, double holeDiameter, double xStep, double yStep, double xSpaceLeft, double ySpaceBottom, double xSpaceRight, double ySpaceTop) {
			this.unit = unit;
			this.holeDiameter = holeDiameter;
			this.xStep = xStep;
			this.yStep = yStep;
			this.xSpaceLeft = xSpaceLeft;
			this.ySpaceBottom = ySpaceBottom;
			this.xSpaceRight = xSpaceRight;
			this.ySpaceTop = ySpaceTop;
		}

		public double getHoleDiameter() { return inchToMm(holeDiameter);	}
		public double getXStep() { return inchToMm(xStep); }
		public double getYStep() { return inchToMm(yStep); }
		public double getXSpaceLeft() { return inchToMm(xSpaceLeft); }
		public double getYSpaceBottom() { return inchToMm(ySpaceBottom); }
		public double getXSpaceRight() { return inchToMm(xSpaceRight); }
		public double getYSpaceTop() { return inchToMm(ySpaceTop); }
		private double inchToMm(double val) {
			if(Unit.MM==unit)return val;
			return val * 25.4;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("MusicCardMaripoFav");
		MusicCard card = new MusicCard(new MusicMaripoFav());
		System.out.println(card.toDxf());
	}

	public String toDxf() {
		StringBuffer buf = new StringBuffer();
		buf.append("TEST");
		return buf.toString();
	}
}
