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
		assertEquals("Mont-l�s-Metz", Normaliser.normaliserVille("Mont l�s Metz"));
		assertEquals("Ville-sous-Terre", Normaliser.normaliserVille("Ville sous Terre"));
		assertEquals("�clipse-sur-c�t�", Normaliser.normaliserVille("�clipse sur c�t�"));
		assertEquals("Lucas-�-Verdun", Normaliser.normaliserVille("Lucas � Verdun" ));
		assertEquals("Soupe-aux-l�gumes", Normaliser.normaliserVille("Soupe aux l�gumes"));
	}
}
