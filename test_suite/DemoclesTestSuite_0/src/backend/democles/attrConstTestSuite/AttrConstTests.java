package backend.democles.attrConstTestSuite;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import OnlineShopLang.Article;
import OnlineShopLang.Shop;
import OnlineShopLang.User;
import OnlineShopLangTestGen.OnlineShopLangInstGen;
import OnlineShopLangTestGen.OnlineShopLangTestGenFactory;


public class AttrConstTests {
	
	@Before
	public void setUp() throws Exception {
		
	
	}

	@Test
	public void testCalcAverageCred() {
		OnlineShopLangInstGen instGen=OnlineShopLangTestGenFactory.eINSTANCE.createOnlineShopLangInstGen();
		Shop shop=instGen.createOnlineShopInstance();
		shop.calcAverageCred();
		
		float credSum=0;
		for (User user : shop.getUsers()) {
			credSum=credSum+user.getCredibility();
		}
		Assert.assertTrue((credSum/shop.getUsers().size())==shop.getAverageCred());
	}
	
	@Test
	public void testCreateArticleList() {
		OnlineShopLangInstGen instGen=OnlineShopLangTestGenFactory.eINSTANCE.createOnlineShopLangInstGen();
		Shop shop=instGen.createOnlineShopInstance();
		shop.createArticleList();
		String list=",";
		for (Article article : shop.getArticles()) {
			list=list+article.getName()+",";
		}
		list=list.substring(0, list.length()-1);
		Assert.assertTrue(list.equals(shop.getArticleListCsv()));
	}
	
	@Test
	public void testDuplicatArticles() {
		OnlineShopLangInstGen instGen=OnlineShopLangTestGenFactory.eINSTANCE.createOnlineShopLangInstGen();
		Shop shop=instGen.createOnlineShopInstance();
		assertFalse(shop.areDuplicateArticleNames());
		
		Shop shop2=instGen.createOnlineShopIntanceDuplicateArticles();
		assertTrue(shop2.areDuplicateArticleNames());
	}
	
	
	@Test
	public void testAddArticle() {
		OnlineShopLangInstGen instGen=OnlineShopLangTestGenFactory.eINSTANCE.createOnlineShopLangInstGen();
		Shop shop=instGen.createOnlineShopInstance();
		User guybrush =shop.getUsers().stream().filter(x->x.getCredibility()==0.5).findFirst().get();
		Article tv=shop.getArticles().stream().filter(x->x.getName()=="tv").findAny().get();
		int oldTotalPrice=guybrush.getCart().getTotalPrice();
		guybrush.addArticle(tv);
		assertTrue(oldTotalPrice+tv.getPrice()==guybrush.getCart().getTotalPrice());
	}
	public void testCalcTotalPriceWithTax() {
		OnlineShopLangInstGen instGen=OnlineShopLangTestGenFactory.eINSTANCE.createOnlineShopLangInstGen();
		Shop shop=instGen.createOnlineShopInstance();
		User guybrush =shop.getUsers().stream().filter(x->x.getCredibility()==0.5).findFirst().get();
		Article tv=shop.getArticles().stream().filter(x->x.getName()=="tv").findAny().get();
		guybrush.addArticle(tv);
		guybrush.calcTotalPriceWithTax();
		assertTrue(guybrush.getCart().getTotalPrice()*(shop.getTax()+1)==guybrush.getCart().getTotalPriceWithTax());
		
	}
	
	public void testCalcTotalTax() {
		OnlineShopLangInstGen instGen=OnlineShopLangTestGenFactory.eINSTANCE.createOnlineShopLangInstGen();
		Shop shop=instGen.createOnlineShopInstance();
		User guybrush =shop.getUsers().stream().filter(x->x.getCredibility()==0.5).findFirst().get();
		Article tv=shop.getArticles().stream().filter(x->x.getName()=="tv").findAny().get();
		guybrush.addArticle(tv);
		guybrush.calcTotalPriceWithTax();
		guybrush.getCart().calcTotalTax();
		assertTrue(guybrush.getCart().getTotalPriceWithTax()-guybrush.getCart().getTotalPrice()==guybrush.getCart().getTotalTax());
		
	}
	
}
