package td3;

public class TestNormalisationVoie {
    @Test
    public void testNomDeVoieBoulevard() {
    assertEquals("boulevard Robert", Normaliser.normaliserVoie("boul Robert"));
    assertEquals("boulevard Robert", Normaliser.normaliserVoie("boul. Robert"));
    assertEquals("boulevard Robert", Normaliser.normaliserVoie("bd Robert"));
    }
    
    @Test
    public void testNomDeVoieAvenue() {
    assertEquals("avenue Robert", Normaliser.normaliserVoie("av. Robert"));
    }
    
    @Test
    public void testNomDeVoieFaubourg() {
    assertEquals("faubourg Robert", Normaliser.normaliserVoie("faub. Robert"));
    assertEquals("faubourg Robert", Normaliser.normaliserVoie("fg Robert"));
    }
    
    @Test
    public void testNomDeVoiePlace() {
    assertEquals("place Robert", Normaliser.normaliserVoie("pl. Robert"));
    }
    
    @Test
    public void testVirgule() {
    assertEquals("3, rue Robert", Normaliser.normaliserNoRue("3 rue Robert"));
    }
    
}
