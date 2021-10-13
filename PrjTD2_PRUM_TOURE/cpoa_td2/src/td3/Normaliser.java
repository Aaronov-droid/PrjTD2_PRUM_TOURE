package td3;

public interface Normaliser {
	
	public static String supprEspaces(String ch) {
        return ch.replaceAll("\s+","");
    }
	
	public static String normaliserPays(String pays) {

		if(pays == "letzebuerg" || pays == "Letzebuerg")
		{
			pays = "Luxembourg";
		}
		else if (pays == "belgium" || pays == "Belgium"){
			pays = "Belgique";
		}
		else if (pays == "switzerland" || pays == "Switzerland" || pays == "schweiz" || pays == "Schweiz")
		{
			pays = "Suisse";
		}
		return pays;
	}
	
	public static String normaliserVille(String ville) {
	
		if(ville.substring(0,1) == ville.substring(0,1).toLowerCase())
		{
			String firstLetter = ville.substring(0,1);
			String AllNextLetter = ville.substring(1,ville.length());
			
			firstLetter = firstLetter.toUpperCase();
			ville = firstLetter + AllNextLetter;
		}
		switch(ville)
			{
				case "St ":
					ville = "Saint-";
					break;
				case "Ste ":
					ville = "Sainte-";
					break;
				case " le ":
					ville = "-le-";
					break;
				case " lès " :
					ville = "-lès-";
					break;
				case " sous " :
					ville = "-sous-";
					break;
				case " sur ":
					ville = "-sur-";
					break;
				case " à ":
					ville = "-à-";
					break;
				case " aux ":
					ville = "-aux-";
					break;
				default;
					break;
			}
		return ville;
	}

	public static String normaliserCodePostale(String code_postal) {
        while(code_postal.length()<=5)
            code_postal="0"+code_postal;
        return code_postal;
}

	public static String normaliserVoie(String voie) {
		switch(voie)
        {
             case "boul", "boul.", "bd" :
                     voie="boulevard";
                         break;
            case "av." :
                    voie="avenue";
                         break;
            case "faub.", "fg" :
                     voie="faubourg";
                         break;
            case "pl." :
                     voie="place";
                         break;               
            default :
                          break;
        }
        return voie;
    }
    
    public static String normaliserNoRue(String no_rue) {
        return no_rue +=",";
    }
}