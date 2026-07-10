\# Renard\_vs\_Lapins
Il progetto "Renard vs Lapins" è un videogioco sviluppato in Java basato su una simulazione su griglia, in cui una volpe (Fox) interagisce con più conigli (Rabbits). Il gioco evolve automaticamente nel tempo attraverso step discreti, fino al raggiungimento di una condizione di terminazione.
* La condizione di terminazione può avere due finali:
*  La volpe vince se e solo se elimina tutti i conigli
*  La volpe perde se e solo se non elimina tutti i conigli 
  

\### Prerequisiti

\- Java 25 (LTS) -- LTS richiesta dalle specifiche

\- Gradle -- Gradle della versione specificata

\- gradle init -- comando necessario per l'inizializzazione di un progetto Gradle

\- gradle build -- comando necessario per la build del progetto Gradle

\- gradle tasks -- comando necessario per capire se tra le operazioni disponibili vi sia la run
\---

\## Come eseguire il progetto
Il progetto può essere eseguito attraverso i comandi:

```bash

git clone "https://github.com/micheleAssandro/Renard_vs_Lapins.git";

cd Renard_vs_Lapins

gradle run

```

Oppure attraverso i comandi analoghi per mezzo del wrapper
```bash

git clone "https://github.com/micheleAssandro/Renard_vs_Lapins.git";

cd Renard_vs_Lapins

gradle .\gradlew run

```

\### Controlli
\- OK -- Richiede Remach

\- Rematch -- Nuova Partita

\- Exit, ESC -- Fine Partita

\---

\### Uso di AI
In questo progetto è stato utilizzato il supporto di una AI (Chatgpt) per i seguenti motivi:
* Qualità del codice
*  Ottimizzazione del codice
*  Visibilità del codice  

* Progettazione della GUI
*  Documentazione JavaSwing implementata assieme al Javadoc (https://docs.oracle.com/javase/8/docs/api/)
