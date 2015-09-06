package backend.democles.railwayControl;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.moflon.core.utilities.eMoflonEMFUtil;

import RailwayControl.End;
import RailwayControl.Railway;
import RailwayControl.RailwayControlFactory;
import RailwayControl.RailwayControlPackage;
import RailwayControl.Start;
import RailwayControl.Track;

public class TestRailwayControl {
	private Railway uutRailway;
	
	@Before
	public void init(){
		ResourceSet set = eMoflonEMFUtil.createDefaultResourceSet();
		// Initialize package
		set.getPackageRegistry().put(RailwayControlPackage.eNS_URI, RailwayControlPackage.eINSTANCE);
		eMoflonEMFUtil.installCrossReferencers(set);
		Resource r = set.getResource(eMoflonEMFUtil.createFileURI("resources/railwayControl/Railway.xmi", true),
				true);
		uutRailway= (Railway) r.getContents().get(0);
		assertEquals(4, uutRailway.getTracks().size());
	}
		
	//################ Testing NACs ########################
	
	@Test
	public void testOneNacForIsTrackIsolated() {
		for (Track track : uutRailway.getTracks()) {
			if(track.getName().compareTo("Bielefeld")==0)
				assertTrue(track.isTrackIsolated());
			else
				assertFalse(track.isTrackIsolated());
		}
	}	
	
	@Test
	public void testOneNacForGetSomeIsolatedTrack() throws Exception {
		Assert.assertEquals("Bielefeld",uutRailway.getSomeIsolatedTrack().getName());
	}

	//########Testing Injection and Complex NACs ###########
	
	@Test @Ignore("We do not support complex NACs yet!")
	public void testNacsWithIndexAndInjectionForDistancesOfTracks() throws Exception {
		for (Track track : uutRailway.getTracks()) {
			if (track.getName().compareTo("Bielefeld") == 0) {
				//Bielefeld has no Coordinates
				assertTrue(track.coordinatesAreMissing());
				assertFalse(track.hasCorrectCoordnates());
				
				//create and set first Coordinate
				Start bielefeldStart = RailwayControlFactory.eINSTANCE.createStart();
				bielefeldStart.setX(1.0);
				bielefeldStart.setY(1.0);
				track.setStart(bielefeldStart);
				
				assertFalse(track.coordinatesAreMissing());
				assertFalse(track.hasCorrectCoordnates());				
				
				//create and set second Coordinate				
				End bielefeldEnd = RailwayControlFactory.eINSTANCE.createEnd();
				bielefeldEnd.setX(4.0);
				bielefeldEnd.setY(5.0);				
				track.setEnd(bielefeldEnd);
				
				assertFalse(track.coordinatesAreMissing());
				assertTrue(track.hasCorrectCoordnates());	
				
				//test injection
				assertEquals(5.0, track.getDistanceFromTrack(), 0.0);
			} else
				assertTrue(track.getDistanceFromTrack() > 0);
		}
	}
	
	
}
