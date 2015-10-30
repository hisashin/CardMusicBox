package st.tori.cardMusicBox;

public abstract class AbstractMusicCard {

	public abstract String getTitle();
	
	public abstract double[][] getPositionArray();
	
	private static Layout DEFAULT_LAYOUT = new Layout(Layout.Unit.MM, 2.75, 7.91, 2.99, 40, 6, 11, 6);
	public Layout getLayout() {	return DEFAULT_LAYOUT; }

	public static class Layout {
		
		Unit unit;
		double holeDiameter;
		double xStep;
		double yStep;
		double xSpaceLeft;
		double ySpaceBottom;
		double xSpaceRight;
		double ySpaceTop;
		
		public Layout(Unit unit, double holeDiameter, double xStep, double yStep, double xSpaceLeft, double ySpaceBottom, double xSpaceRight, double ySpaceTop) {
			this.unit = unit;
			this.holeDiameter = holeDiameter;
			this.xStep = xStep;
			this.yStep = yStep;
			this.xSpaceLeft = xSpaceLeft;
			this.ySpaceBottom = ySpaceBottom;
			this.xSpaceRight = xSpaceRight;
			this.ySpaceTop = ySpaceTop;
		}
		public static enum Unit {
			MM,
			INCH,
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
	
}
