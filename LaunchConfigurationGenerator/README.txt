
Runtime Measurements with a new VM for each measurement:

THE IDEA:

We generate launch configs, which invoke TGGMain each time with a different parameter (args[0]).
The parameter states the model size with which TGGMain is invoked.

The workflow in TGGMain with this parameter is as follows:

class TGGMain{
	
	public static void main(String[] args){
		
		//extract modelsize from the parameter
		int modelSize = Integer.valueOf(args[0]); 
		
		//generate a model of given size
		EObject model = YourModelGenerator.generate(modelsize);
		
		//Do your actions such as TGG_FWD, TGG_BWD, parse, unparse or whatever with your model
		//save your measurement result to some file for each case
		//do not forget to save your runtime with model size
		//e.g. saveToFile(modelSize + ";" measuredTime)
}

HOW TO GENERATE AND IMPORT YOUR LAUNCH CONFIGS:

1) Install Eclipse CDT plugin. http://www.eclipse.org/cdt/downloads.php
The current update site for Kepler is: http://download.eclipse.org/tools/cdt/releases/kepler

2) Adjust the final Strings in launchConfig/LaunchConfigGenerator.java
These final strings state your desired model sizes, repeat times, TGG project name, VM arguments etc.

3) run LaunchConfigGenerator.main

4) the generated launch files will be in the folder "launchconfig". One of them is called GROUP.launch

5) import the generated launch files in Eclipse
( File->Import->Run/Debug->Launch Configuration)

6) Run GROUP.launch for your runtime measurements.

For Questions, please contact erhan.leblebici@es.tu-darmstadt.de