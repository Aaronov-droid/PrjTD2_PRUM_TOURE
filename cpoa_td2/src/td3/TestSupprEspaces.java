package td3;

public class TestSupprEspaces {
	
    @Test
    public void testSupprEspacesDebut() {
    assertEquals("test", Normaliser.supprEspaces("   test"));
    }
    
    @Test
    public void testSupprEspacesFin() {
    assertEquals("test", Normaliser.supprEspaces("test   "));
    }
    
    @Test
    public void testSupprEspacesDebutFin() {
    assertEquals("test", Normaliser.supprEspaces("   test   "));
    }
}
