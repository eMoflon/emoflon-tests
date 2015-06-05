package backend.democles.onlineSocialNetwork;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.moflon.core.utilities.eMoflonEMFUtil;

import OnlineSocialNetwork.ContentContainer;
import OnlineSocialNetwork.DigitalContent;
import OnlineSocialNetwork.Female;
import OnlineSocialNetwork.Group;
import OnlineSocialNetwork.Male;
import OnlineSocialNetwork.Member;
import OnlineSocialNetwork.OnlineSocialNetworkFactory;
import OnlineSocialNetwork.OnlineSocialNetworkPackage;
import OnlineSocialNetwork.Platform;
import OnlineSocialNetwork.Visibility;

public class TestOnlineSocialNetwork {

	private Platform uutPlatform;
	
	@Before
	public void init(){
		setup();
	}
	
	//################ Testing Methods ########################		
	@Test
	public void testOneNACForIsSingle(){
		//predefined singles
		String [] names = {"Dr Rajesh Koothrappali", "Stuart Bloom", "Shelbot"};
		Collection<String> definedSingles = Arrays.asList(names);
		
		for(Member member : uutPlatform.getMember()){
			if(member.isSingle()){
				assertTrue(definedSingles.contains(member.getName()));
			}
			else{
				assertFalse(definedSingles.contains(member.getName()));
			}
		}
		
	}
	
	@Test
	public void testOneNACForInAGroup(){
		//predefined members without a group
		String [] names = {"Stuart Bloom", "Shelbot"};
		Collection<String> nonGroupMembers = Arrays.asList(names);
		
		for(Member member : uutPlatform.getMember()){
			if(member.IsInAGroup()){
				assertFalse(nonGroupMembers.contains(member.getName()));
			}
			else{
				assertTrue(nonGroupMembers.contains(member.getName()));
			}
		}
		
	}
	
	@Test
	public void testHelperMethodAddingFriends(){
		Member leonard = uutPlatform.getMemberForName("Dr Leonard Hofstadter");
		
		//count leonards friends
		int numberOfLeonardsFriends = leonard.getFriends().size();
		assertEquals(7, numberOfLeonardsFriends);
		
		assertTrue(leonard.addFriend(uutPlatform.getMemberForName("Stuart Bloom")));
		assertEquals(numberOfLeonardsFriends + 1, leonard.getFriends().size());
	}
	
	@Test
	public void testHelperMethodAddingFalseFriends(){
		Member leonard = uutPlatform.getMemberForName("Dr Leonard Hofstadter");
		
		//count leonards friends
		int numberOfLeonardsFriends = leonard.getFriends().size();
		assertEquals(7, numberOfLeonardsFriends);
		
		assertTrue(leonard.addFalseFriend(uutPlatform.getMemberForName("Stuart Bloom")));
		assertEquals(numberOfLeonardsFriends + 1, leonard.getFriends().size());
	}
	
	@Test
	public void testHelperMethodSomeLikes(){
		// init
		Map<String, Integer> gettedLikes = getNames2GettedLikesMap();
		Map<String, Integer> likes = getNames2CountedLikesMap();
		
		for(Member member : uutPlatform.getMember()){
			//Test getted Likes
			if(gettedLikes.containsKey(member.getName())){
				int countedLikes=gettedLikes.get(member.getName());
				assertEquals(countedLikes, member.countLikesFromContent());
			}
			else{
				assertEquals(0, member.countLikesFromContent());
			}
			
			//Test likes
			if(likes.containsKey(member.getName())){
				int countedLikes=likes.get(member.getName());
				assertEquals(countedLikes, member.getLikes().size());
			}
			else{
				assertEquals(0, member.getLikes().size());
			}
				
		}
	}
	
	@Test
	public void testHelperMethodsForGroups(){
		//init
		int numberOfGroupsBeforeChange=uutPlatform.getGroups().size();
		Group astronauts=uutPlatform.getGroupForTopic("Astronauts");
		assertNull(astronauts);
		
		//Howard creates a group 
		Member howard = uutPlatform.getMemberForName("Howard Wolowitz");
		howard.createGroup("Astronauts");
		
		//check group properties
		astronauts=uutPlatform.getGroupForTopic("Astronauts");
		assertNotNull(astronauts);
		assertEquals("Astronauts", astronauts.getTopic());
		assertEquals(howard, astronauts.getFounder());
		assertEquals(1, astronauts.getMember().size());
		assertEquals(howard, astronauts.getMember().get(0));
		assertEquals(numberOfGroupsBeforeChange + 1, uutPlatform.getGroups().size());
	}
	
	@Test
	public void testHelperStructureContainer(){
		//get Sheldon and his Bot
		Member sheldon=uutPlatform.getMemberForName("Dr Dr Sheldon Cooper");
		assertNotNull(sheldon);
		Member shelbot=uutPlatform.getMemberForName("Shelbot");
		assertNotNull(shelbot);
		
		//get from Sheldon the containers 
		ContentContainer sheldonContainer=sheldon.getVisibleContent(sheldon);
		assertEquals(4, sheldonContainer.getContent().size());
		ContentContainer shelbotContainer=sheldon.getVisibleContent(shelbot);
		assertEquals(2, shelbotContainer.getContent().size());
		
		//is Visibility Correct?
		for(DigitalContent content : sheldonContainer.getContent()){
			if(shelbotContainer.contains(content)){
				assertTrue(content.isVisible(shelbot));
				assertTrue(content.isVisible(sheldon));
			}
			else{
				assertFalse(content.isVisible(shelbot));
				assertTrue(content.isVisible(sheldon));
			}
		}
	}
	
	@Test
	public void testHelperMethodForVisibilty(){
		//get Rajesh and Sheldon
		Member rajesh=uutPlatform.getMemberForName("Dr Rajesh Koothrappali");
		assertNotNull(rajesh);
		Member sheldon=uutPlatform.getMemberForName("Dr Dr Sheldon Cooper");
		assertNotNull(sheldon);
		assertNotNull(rajesh.getContentByTopic("toDo"));
		assertNull(rajesh.getContentByTopic("toDo",sheldon));		
	}
	
	
	//################ Testing MethodCallExpressions ############	
	
	
	@Test
	public void testMethodCallExpressionForLiking(){
		//get Sheldon, Shelbot and Leonard
		Member sheldon = uutPlatform.getMemberForName("Dr Dr Sheldon Cooper");
		assertNotNull(sheldon);
		Member leonard = uutPlatform.getMemberForName("Dr Leonard Hofstadter");
		assertNotNull(leonard);
		Member shelbot=uutPlatform.getMemberForName("Shelbot");
		assertNotNull(shelbot);
		
		//Leonard can see all content from sheldon
		assertEquals(sheldon.getCreatedContent().size(), sheldon.getVisibleContent(leonard).getContent().size());
		
		//leonard has not liked it
		DigitalContent phdComment=sheldon.getContentByTopic("It's good to have a Ph.D", leonard);
		assertNotNull(phdComment);
		assertEquals(Visibility.GROUP, phdComment.getVisibility());
		assertFalse(leonard.getLikes().contains(phdComment));
		int sheldonLikeCounts=sheldon.countLikesFromContent();
		
		//leonard likes the comment
		assertTrue(leonard.likeContent(phdComment));
		assertTrue(leonard.getLikes().contains(phdComment));
		assertEquals(sheldonLikeCounts + 1, sheldon.countLikesFromContent());
		
		//leonard likes it again
		assertFalse(leonard.likeContent(phdComment));
		assertEquals(sheldonLikeCounts + 1, sheldon.countLikesFromContent());
		
		//sheldon tries to like his comment
		assertFalse(sheldon.likeContent(phdComment));
		assertEquals(sheldonLikeCounts + 1, sheldon.countLikesFromContent());
		
		//shelbot is not a part of the group and try to like
		assertFalse(phdComment.getBelongedGroup().getMember().contains(shelbot));
		assertFalse(shelbot.likeContent(phdComment));
		assertEquals(sheldonLikeCounts + 1, sheldon.countLikesFromContent());
		
	}	
	
	
	
	@Test
	public void testMethodeCallExpressionForInactiveMembers(){
		//get current situation
		int membersCountBeforeCleaning=uutPlatform.getMember().size();
		
		//Test if inactives are deleted
		uutPlatform.deleteInactives(); //Stuart is inactive and should be deleted
		Assert.assertEquals(membersCountBeforeCleaning - 1, uutPlatform.getMember().size()); //is Stuart deleted?
		Member stuart=uutPlatform.getMemberForName("Stuart Bloom"); //try to get Stuart
		Assert.assertNull(stuart); //Stuart not get?
		
		//reboot
		setup();
		
		//Test if Stuart adds a friend that he won't be deleted
		stuart=uutPlatform.getMemberForName("Stuart Bloom"); //try to get Stuart
		Assert.assertNotNull(stuart); //Stuart get?
		stuart.addFriend(uutPlatform.getMemberForName("Howard Wolowitz")); //Stuart is adding a new Friend
		assertFalse(stuart.isInactive());
		uutPlatform.deleteInactives(); //Stuart should not be deleted
		Assert.assertEquals(membersCountBeforeCleaning, uutPlatform.getMember().size());
		
		//reboot
		setup();
		
		//Test if Stuart is part of a Group
		stuart=uutPlatform.getMemberForName("Stuart Bloom"); //try to get Stuart
		Assert.assertNotNull(stuart); //Stuart get?
		Group starTrek = uutPlatform.getGroupForTopic("StarTrek Fan Club");
		starTrek.getMember().add(stuart);
		stuart.getGroups().add(starTrek);
		assertFalse(stuart.isInactive());
		uutPlatform.deleteInactives(); //Stuart should not be deleted
		Assert.assertEquals(membersCountBeforeCleaning, uutPlatform.getMember().size());
		
		//reboot
		setup();
		
		//Test if Stuart likes something
		stuart=uutPlatform.getMemberForName("Stuart Bloom"); //try to get Stuart
		Assert.assertNotNull(stuart); //Stuart get?
		ContentContainer container = uutPlatform.getMemberForName("Dr Dr Sheldon Cooper").getVisibleContent(stuart);
		assertEquals(2, container.getContent().size());
		for(DigitalContent content : container.getContent()){
			assertTrue(stuart.likeContent(content));
		}
		assertFalse(stuart.isInactive());
		uutPlatform.deleteInactives(); //Stuart should not be deleted
		Assert.assertEquals(membersCountBeforeCleaning, uutPlatform.getMember().size());
		
		//add ambot
		Female ambot = OnlineSocialNetworkFactory.eINSTANCE.createFemale();
		ambot.setName("ambot");
		ambot.setAge(0);
		ambot.setPlatform(uutPlatform);
		uutPlatform.getMember().add(ambot);
		Assert.assertEquals(membersCountBeforeCleaning + 1, uutPlatform.getMember().size());
		assertTrue(ambot.isInactive());
		uutPlatform.deleteInactives(); //Stuart should not be deleted
		Assert.assertEquals(membersCountBeforeCleaning, uutPlatform.getMember().size());
		
		//reboot
		setup();
		
		//test one Friend but not inviter
		stuart=uutPlatform.getMemberForName("Stuart Bloom"); //try to get Stuart
		Assert.assertNotNull(stuart); //Stuart get?
		stuart.setHasBeInvited(null);
		uutPlatform.getMemberForName("Dr Rajesh Koothrappali").getInvited().remove(stuart);
		assertFalse(stuart.isInactive());
		uutPlatform.deleteInactives(); //Stuart should not be deleted
		Assert.assertEquals(membersCountBeforeCleaning, uutPlatform.getMember().size());		
	}
	
	@Test
	public void testMethodCallExpressionForBots(){
		//Test current situation
		int membersCountBeforeCleaning=uutPlatform.getMember().size();		
		Member sheldon = uutPlatform.getMemberForName("Dr Dr Sheldon Cooper");// get Sheldon
		int likesForSheldon = sheldon.countLikesFromContent(); //How many likes has Sheldon?
		assertEquals(2, likesForSheldon);
		
		//Test if all bots and there actions are deleted
		uutPlatform.deleteBots(); //Shelbot is a Bot and should be deleted
		Assert.assertEquals(membersCountBeforeCleaning - 1, uutPlatform.getMember().size()); //is Shelbot deleted
		Member shelbot = uutPlatform.getMemberForName("Shelbot"); // should not exist
		assertNull(shelbot);
		likesForSheldon = sheldon.countLikesFromContent(); //How many likes has Sheldon?
		assertEquals(0, likesForSheldon); //Has Sheldon use a Bot to like his stuff?
		
		//retesting Bots and try to configure shelbot, that he doesn't be found by heuristics
		
		//first way: shelbot and sheldon are friends
		setup();
		shelbot = uutPlatform.getMemberForName("Shelbot");
		assertNotNull(shelbot);
		shelbot.addFriend(sheldon);
		assertFalse(shelbot.isBot());
		uutPlatform.deleteBots();
		assertEquals(likesForSheldon, sheldon.countLikesFromContent());
		
		//second way: shelbot is in a group
		setup();
		shelbot = uutPlatform.getMemberForName("Shelbot");
		assertNotNull(shelbot);
		Group phds=uutPlatform.getGroupForTopic("Ph.Ds");
		assertNotNull(phds);
		phds.getMember().add(shelbot);
		shelbot.getGroups().add(phds);
		assertFalse(shelbot.isBot());
		uutPlatform.deleteBots();
		assertEquals(likesForSheldon, sheldon.countLikesFromContent());
		
		//third way: shelbot is a relationship
		setup();
		shelbot = uutPlatform.getMemberForName("Shelbot");
		assertNotNull(shelbot);
		Female ambot = OnlineSocialNetworkFactory.eINSTANCE.createFemale();
		ambot.setName("ambot");
		ambot.setAge(0);
		ambot.setPlatform(uutPlatform);
		uutPlatform.getMember().add(ambot);
		ambot.setMalePartner(Male.class.cast(shelbot));
		Male.class.cast(shelbot).setFemalePartner(ambot);
		assertFalse(shelbot.isBot());
		uutPlatform.deleteBots();
		assertEquals(likesForSheldon, sheldon.countLikesFromContent());
		
		//Fourth way: like nothing:
		setup();
		ambot = OnlineSocialNetworkFactory.eINSTANCE.createFemale();
		ambot.setName("ambot");
		ambot.setAge(0);
		assertFalse(ambot.isBot());
		
		//Test if all bots and there actions are deleted
		uutPlatform.deleteBots(); //Shelbot is a Bot and should be deleted
		Assert.assertEquals(membersCountBeforeCleaning - 1, uutPlatform.getMember().size()); //is Shelbot deleted
		shelbot = uutPlatform.getMemberForName("Shelbot"); // should not exist
		assertNull(shelbot);
		likesForSheldon = sheldon.countLikesFromContent(); //How many likes has Sheldon?
		assertEquals(0, likesForSheldon); //Has Sheldon use a Bot to like his stuff?
		
	}
	
	
	//##### Negative Navigable ###########################
	@Test
	public void testNegativeNavigableForSearchContentTopicInGroup(){
		Group phds=uutPlatform.getGroupForTopic("Ph.Ds");
		assertNotNull(phds);
		
		ContentContainer container = phds.searchContentTopicInGroup("It's good to have a Ph.D");
		assertNotNull(container);
		assertEquals(1, container.getContent().size());		
	}
	
	
	//------------ helper methods -------------		
	
	private void setup(){
		uutPlatform = Platform.class.cast(eMoflonEMFUtil.loadAndInitModel(OnlineSocialNetworkPackage.eINSTANCE, "resources/onlineSocialNetwork/tbbtTest.xmi"));
		assertEquals(9,uutPlatform.getMember().size());
		assertEquals(3,uutPlatform.getGroups().size());
	}

	private Map<String, Integer> getNames2GettedLikesMap(){
		Map<String, Integer> tbbt = new HashMap<>();
		tbbt.put("Dr Dr Sheldon Cooper", 2);
		tbbt.put("Dr Leonard Hofstadter", 3);		
		return tbbt;
	}
	
	private Map<String, Integer> getNames2CountedLikesMap(){
		Map<String, Integer> tbbt = new HashMap<>();
		tbbt.put("Dr Dr Sheldon Cooper", 1);
		tbbt.put("Howard Wolowitz", 1);
		tbbt.put("Dr Rajesh Koothrappali", 1);
		tbbt.put("Shelbot", 2);
		return tbbt;
	}
	
}
