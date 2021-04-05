package scientia.periodic_table_editor;

public class MathSystem1 implements Math {
	@Override
	public String getHex(int i) {
		final Constant a =new Constant();
		int r=a.constanta[i-1][1];
		int g=a.constanta[i-1][2]*10;
		int b=a.constanta[i-1][0]*10;
		String hex;
		String red=Integer.toHexString(r);
		String green=Integer.toHexString(g);
		String blue=Integer.toHexString(b);
		if(r<=15) red="0"+red;
		if(g<=15) green="0"+green;
		if(b<=15) blue="0"+blue;
		hex="#"+ red +green + blue;
		return hex.toUpperCase();
	}

}
