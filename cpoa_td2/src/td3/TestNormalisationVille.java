package td3;

public class TestNormalisationVille {
	@test
	public void testVilleMajuscule{
	    assertEquals("Metz", Normaliser.normaliserVille("metz"));
	}
	
	@test
	public void testVillePrefixe{
		assertEquals("Saint-Julien", Normaliser.normaliserVille("St Julien"));
		assertEquals("Sainte-Marie", Normaliser.normaliserVille("Ste Marie"));
	}
	
	@test
	public void testVillePreposition {
		assertEquals("Mathis-le-pieux", Normaliser.normaliserVille("Mathis le pieux"));
		assertEquals("Mont-lès-Metz", Normaliser.normaliserVille("Mont lès Metz"));
		assertEquals("Ville-sous-Terre", Normaliser.normaliserVille("Ville sous Terre"));
		assertEquals("Éclipse-sur-côté", Normaliser.normaliserVille("Éclipse sur côté"));
		assertEquals("Lucas-à-Verdun", Normaliser.normaliserVille("Lucas à Verdun" ));
		assertEquals("Soupe-aux-légumes", Normaliser.normaliserVille("Soupe aux légumes"));
	}
}
