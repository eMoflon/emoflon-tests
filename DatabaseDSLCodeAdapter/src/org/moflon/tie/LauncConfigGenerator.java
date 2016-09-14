package org.moflon.tie;

public class LauncConfigGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int modelSizes10[] = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000, 20000, 30000, 40000};
		
		int modelSizes5[] = {50000, 100000, 150000, 200000};
		
		int global = 0;
		
		for(int i = 0; i < modelSizes10.length; i++){
			for(int j = 0; j < 10; j++){
				System.out.println("<stringAttribute key=\"org.eclipse.cdt.launch.launchGroup."+ global + ".action\" value=\"WAIT_FOR_TERMINATION\"/>");
				System.out.println("<stringAttribute key=\"org.eclipse.cdt.launch.launchGroup."+global+".enabled\" value=\"true\"/>");
				System.out.println("<stringAttribute key=\"org.eclipse.cdt.launch.launchGroup."+global+".mode\" value=\"run\"/>");
				System.out.println("<stringAttribute key=\"org.eclipse.cdt.launch.launchGroup."+global+".name\" value=\"MeasureAllMain " + modelSizes10[i] + "\"/>");
				global++;
			}
		}
		
		for(int i = 0; i < modelSizes5.length; i++){
			for(int j = 0; j < 5; j++){
				System.out.println("<stringAttribute key=\"org.eclipse.cdt.launch.launchGroup."+ global + ".action\" value=\"WAIT_FOR_TERMINATION\"/>");
				System.out.println("<stringAttribute key=\"org.eclipse.cdt.launch.launchGroup."+global+".enabled\" value=\"true\"/>");
				System.out.println("<stringAttribute key=\"org.eclipse.cdt.launch.launchGroup."+global+".mode\" value=\"run\"/>");
				System.out.println("<stringAttribute key=\"org.eclipse.cdt.launch.launchGroup."+global+".name\" value=\"MeasureAllMain " + modelSizes5[i] + "\"/>");
				global++;
			}
		}

	}

}
