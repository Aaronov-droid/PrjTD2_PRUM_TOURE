package td3;

public class TestNormalisationCodePostale {
	
    @Test
    public void testNormalisationCodePostalChiffre() {
    assertEquals("00500", Normaliser.normaliserCodePostale("500"));
    }
    
    @Test
    public void testSupprEspacesIndPays() {
    assertEquals("5500", Normaliser.supprEspaces("L-5500"));
    }
    
}
