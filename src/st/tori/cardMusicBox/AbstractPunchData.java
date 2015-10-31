package st.tori.cardMusicBox;

import st.tori.cardMusicBox.exception.NoPunchDataException;

public abstract class AbstractPunchData {

	public abstract String getTitle();
	
	public abstract double[][] getScalePositionArray();
	
	public final double getMinScalePosition() throws NoPunchDataException {
		double min = Double.MAX_VALUE;
		for(double[] array: getScalePositionArray()) {
			if(array==null||array.length<=0)continue;
			for(double val: array) {
				if(min>val)min = val;
			}
		}
		if(min==Double.MAX_VALUE)throw new NoPunchDataException(this);
		return min;
	}
	public final double getMaxScalePosition() throws NoPunchDataException {
		double max = Double.MIN_VALUE;
		for(double[] array: getScalePositionArray()) {
			if(array==null||array.length<=0)continue;
			for(double val: array) {
				if(max<val)max = val;
			}
		}
		if(max==Double.MIN_VALUE)throw new NoPunchDataException(this);
		return max;
	}
}
