package td3;

public class TestNormalisationPays {

	@test
	public void testNomPaysLuxembourg{
	    assertEquals("Luxembourg", Normaliser.normaliserPays("letzebuerg"));
	    assertEquals("Luxembourg", Normaliser.normaliserPays("Letzebuerg"));
	}
	
	@test
	public void testNomPaysBelgique{
	    assertEquals("Belgique", Normaliser.normaliserPays("belgium"));
	    assertEquals("Belgique", Normaliser.normaliserPays("Belgium"));
	}
	
	@test
	public void testNomPaysSuisse{
	    assertEquals("Suisse", Normaliser.normaliserPays("switzerland"));
	    assertEquals("Suisse", Normaliser.normaliserPays("Switzerland"));
	    assertEquals("Suisse", Normaliser.normaliserPays("schweiz"));
	    assertEquals("Suisse", Normaliser.normaliserPays("Schweiz"));
	}
}