package st.tori.punch;

import java.io.File;
import java.io.IOException;

import org.jfree.graphics2d.svg.SVGGraphics2D;
import org.jfree.graphics2d.svg.SVGUtils;

import st.tori.punch.exception.NoPunchDataException;
import st.tori.punch.goda.music.PunchDataMaripoFav;
import st.tori.punch.goda.music.PunchDataShortSample;

public class PunchCard {

	private static PunchCardLayout DEFAULT_LAYOUT = new PunchCardLayout(Unit.MM, 7.91, 2.99, 40, 6, 11, 6, 2.75, 2.75);
	
	protected AbstractPunchData music;
	protected PunchCardLayout layout;
	
	public PunchCard(AbstractPunchData music) throws NoPunchDataException {
		init(music, DEFAULT_LAYOUT);
	}
	public PunchCard(AbstractPunchData music, Unit unit, double xStep, double yStep, double xSpaceLeft, double ySpaceBottom, double xSpaceRight, double ySpaceTop, double xHoleDiameter, double yHoleDiameter) throws NoPunchDataException {
		init(music, new PunchCardLayout(unit, xStep, yStep, xSpaceLeft, ySpaceBottom, xSpaceRight, ySpaceTop, xHoleDiameter, yHoleDiameter));
	}
	private void init(AbstractPunchData music, PunchCardLayout layout) throws NoPunchDataException {
		this.music = music;
		this.layout = layout;
		music.getMaxScalePosition();
	}
	
	public String getTitle() {
		return music.getTitle();
	}
	public AbstractPunchData getPunchData() {
		return music;
	}
	public PunchCardLayout getLayout() {
		return layout;
	}

	public static enum Unit {
		MM,
		INCH,
	}
	public static class PunchCardLayout {
		
		Unit unit;
		double xStep;
		double yStep;
		double xSpaceLeft;
		double ySpaceBottom;
		double xSpaceRight;
		double ySpaceTop;
		double xHoleDiameter;
		double yHoleDiameter;
		
		public PunchCardLayout(Unit unit, double xStep, double yStep, double xSpaceLeft, double ySpaceBottom, double xSpaceRight, double ySpaceTop, double xHoleDiameter, double yHoleDiameter) {
			this.unit = unit;
			this.xStep = xStep;
			this.yStep = yStep;
			this.xSpaceLeft = xSpaceLeft;
			this.ySpaceBottom = ySpaceBottom;
			this.xSpaceRight = xSpaceRight;
			this.ySpaceTop = ySpaceTop;
			this.xHoleDiameter = xHoleDiameter;
			this.yHoleDiameter = yHoleDiameter;
		}

		public double getXStep() { return inchToMm(xStep); }
		public double getYStep() { return inchToMm(yStep); }
		public double getXSpaceLeft() { return inchToMm(xSpaceLeft); }
		public double getYSpaceBottom() { return inchToMm(ySpaceBottom); }
		public double getXSpaceRight() { return inchToMm(xSpaceRight); }
		public double getYSpaceTop() { return inchToMm(ySpaceTop); }
		public double getXHoleDiameter() { return inchToMm(xHoleDiameter);	}
		public double getYHoleDiameter() { return inchToMm(yHoleDiameter);	}
		private double inchToMm(double val) {
			if(Unit.MM==unit)return val;
			return val * 25.4;
		}
		
		@Override
		public String toString() {
			return "PunchCardLayout[xStep="+getXStep()+",yStep()="+getYStep()+",xSpaceLeft()="+getXSpaceLeft()+",ySpaceBottom()="+getYSpaceBottom()+",xSpaceRight()="+getXSpaceRight()+",ySpaceTop()="+getYSpaceTop()+",xHoleDiameter()="+getXHoleDiameter()+",yHoleDiameter()="+getYHoleDiameter()+"]";

		}
	}
	
	private double getWidth() {
		try {
			return (music.getMaxScalePosition() - music.getMinScalePosition()) * layout.xStep + layout.xSpaceLeft + layout.xSpaceRight;
		} catch (NoPunchDataException e) {
			e.printStackTrace();
			return 0;
		}
	}
	private double getHeight() {
		return (music.getScalePositionArray().length - 1) * layout.yStep + layout.ySpaceBottom + layout.ySpaceTop;
	}
	
	
	public static void main(String[] args) throws Exception {
		System.out.println("PunchCardMaripoFav");
		{
			PunchCard card = new PunchCard(new PunchDataMaripoFav(), Unit.MM, 7.91, 2.99, 40, 6, 11, 6, 2.75, 2.75);
			card.writeToSVG(new File("/Users/shingo/github/punch/svg/"+card.getPunchData().getClass().getSimpleName()+".svg"));
		}
		{
			PunchCard card = new PunchCard(new PunchDataShortSample(), Unit.MM, 7.91, 2.99, 40, 6, 5, 6, 2.75, 2.3);
			card.writeToSVG(new File("/Users/shingo/github/punch/svg/"+card.getPunchData().getClass().getSimpleName()+".svg"));
		}
	}

	public void writeToSVG(File file) throws IOException {
		int width = scaleX(getWidth());
		int height = scaleY(getHeight());
		System.out.println("writeToSVG:width="+width+",height="+height);
		double minX;
		try {
			minX = music.getMinScalePosition();
		} catch (NoPunchDataException e) {
			e.printStackTrace();
			minX = 0;
		}
        SVGGraphics2D g2 = new SVGGraphics2D(width, height);
        g2.drawRect(0, 0, width, height);
        double[][] scalePositionArray = music.getScalePositionArray();
        for(int i=0;i<scalePositionArray.length;i++) {
        	for(int j=0;j<scalePositionArray[i].length;j++) {
            	g2.drawOval(scaleX(layout.xSpaceLeft+(scalePositionArray[i][j]-minX)*layout.xStep-layout.xHoleDiameter/2),
            		scaleY(layout.ySpaceTop+i*layout.yStep-layout.yHoleDiameter/2),
            		scaleX(layout.xHoleDiameter), scaleY(layout.yHoleDiameter));
        	}
        }
        SVGUtils.writeToSVG(file, g2.getSVGElement());
        System.out.println("writeToSVG:"+file.getAbsolutePath());
	}
	private int scaleX(double val) {
		return (int)(val*25.4);
	}
	private int scaleY(double val) {
		return (int)(val*25.4);
	}
}
