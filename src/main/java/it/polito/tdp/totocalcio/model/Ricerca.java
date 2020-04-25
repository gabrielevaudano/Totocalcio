package it.polito.tdp.totocalcio.model;

import java.util.ArrayList;
import java.util.List;

public class Ricerca {
	private Pronostico pronostico;
	private Integer N;
	private List<Risultato> soluzione;
	
	public List<Risultato> cerca(Pronostico pronostico) {
		this.pronostico = pronostico;
		this.N = pronostico.size();
		
		List<RisultatoPartita> parziale = new ArrayList<>();
		int livello = 0;
		
		this.soluzione = new ArrayList<Risultato>();
		
		ricorsiva(parziale, livello);
		
		return soluzione;
	}
	
	private void ricorsiva(List<RisultatoPartita> parziale, Integer livello) {
		// Caso terminale?
		if (livello==N) {
			this.soluzione.add(new Risultato(parziale));
		} else {
			// caso generale
			// [ parziale da 0 a livello -1 ] [livello] [livello + 1 in poi ]
			PronosticoPartita pp = this.pronostico.get(livello);
			// pp sono i sotto problemi da provare
			
			for (RisultatoPartita ris : pp.getRisultati()) {
				// provo a mettere 'ris' nella posizione 'livello' della soluzione parziale
				
				// costuzione soluzione parziale
				parziale.add(ris);
				// chiamata ricorsiva
				ricorsiva(parziale, livello+1); 
				// back tracking
				parziale.remove(parziale.size()-1);
			}
		}
	}

}

/*
 * Livello di ricorsione = INDICA IL numero di partite che sto considerando
 * se le partire da zero a livello-1 sono già state decise, la partita di indice
 * livello la devo decidere io, le partire da livello + 1 in poi, le decideranno
 * le procedure ricorsive sottostanti
 */

/* La soluzione parziale: è un elenco di RisultatoPartita di lunghezza pari al livello.
 */

/*
 * Soluzione totale: ho N risultati
 */

/*
 * Condizione di terminazione: livello == N
 */

/* GENERAZIONE NUOVE SOLUZIONI DEL LIVELLO: provando tutti i pronostici definiti per 
 * quel livello
 */

