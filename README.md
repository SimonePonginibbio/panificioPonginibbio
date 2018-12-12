# Panificio
Realizzare un’applicazione JavaFX che acceda a dei dati presenti su di un database (creato con il file Panetterie.sql), che contiene la lista di tutte le panetterie presenti sul territorio italiano suddivise per regione, provincia e citta.
Dalle combo in alto nella GUI deve essere possibile:
1.	Selezionata una provincia (tra quelle contenute nel database) verrà compilata la combo Città con tutte le citta censite nel database che appartengono a quella provincia (e in cui ci sono panetterie).
2.	Una volta compilate le due combo con il pulsante Cerca, nella listbox sottostante comparirà tutta la lista delle panetterie presenti in quella Città/Provincia con tutti i dettagli (Città, Provincia, Regione e Nome Panetteria).
Note:
•	Se non si è selezionato nulla nelle combobox il Bottone cerca deve essere disabilitato.
•	Se non si è selezionata la provincia la combobox conterrà la lista di tutte le città contenute nel DB.
•	Selezionata la provincia la combobox si aggiorna con le sole città che competono a quella provincia.
Utilizzare JDBC e DAO per la realizzazione del progetto.
