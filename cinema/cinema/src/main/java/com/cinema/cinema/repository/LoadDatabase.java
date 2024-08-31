package com.cinema.cinema.repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cinema.cinema.model.Acteurs;
import com.cinema.cinema.model.Compagnies;
import com.cinema.cinema.model.Employes;
import com.cinema.cinema.model.Films;
import com.cinema.cinema.model.Realisateurs;
import com.cinema.cinema.model.Recompenses;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Configuration
class LoadDatabase {
  Date date = new Date(0);

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(FilmsRepository filmsRepository, ActeursRepository acteursRepository, RealisateursRepository realisateursRepository, RecompensesRepository recompenseRepository,CompagniesRepository compagniesRepository, EmployesRepository employesRepository ) {

    return args -> {
      log.info("Preloading " + filmsRepository.save(new Films("The Artist", Date.valueOf("2011-10-12"), "Drame", 15000000, List.of(1L, 2L))));
      log.info("Preloading " + filmsRepository.save(new Films("Vicky Cristina Barcelona", Date.valueOf("2008-08-15"), "Romance", 15000000,List.of(1L, 2L))));
      log.info("Preloading " + filmsRepository.save(new Films("Pulp Fiction", Date.valueOf("1994-05-21"), "Crime", 8000000, List.of(1L, 2L))));
      log.info("Preloading " + filmsRepository.save(new Films("Kill Bill: Volume 1", Date.valueOf("2003-10-10"), "Action", 30000000, List.of(1L, 2L))));
      log.info("Preloading " + filmsRepository.save(new Films("Inception", Date.valueOf("2010-07-16"), "Science-Fiction", 160000000, List.of(1L, 2L))));
      log.info("Preloading " + filmsRepository.save(new Films("The Wolf of Wall Street", Date.valueOf("2013-12-25"), "Biopic", 100000000, List.of(1L, 2L))));
      log.info("Preloading " + filmsRepository.save(new Films("La Dolce Vita", Date.valueOf("1960-02-05"), "Drame", 800000, List.of(1L, 2L))));
      log.info("Preloading " + filmsRepository.save(new Films("Rashomon", Date.valueOf("1950-08-26"), "Drame", 200000, List.of(1L, 2L))));
      log.info("Preloading " + filmsRepository.save(new Films("Blade Runner", Date.valueOf("1982-06-25"), "Science-Fiction", 28000000, List.of(1L, 2L))));
      log.info("Preloading " + filmsRepository.save(new Films("Gladiator", Date.valueOf("2000-05-05"), "Action", 103000000, List.of(1L, 2L))));
     //log.info("Preloading " + acteursRepository.save(new Acteurs("Ta mere en slip", date,"horreur",120000000)));
      //log.info("Preloading " + acteursRepository.save(new Acteurs("Luc la folle du bus", date,"horreur",20000 )));

      log.info("Preloading " + realisateursRepository.save(new Realisateurs("Steven", "Spielberg", "USA", "steven.spielberg@example.com")));
      log.info("Preloading " + realisateursRepository.save(new Realisateurs("Quentin", "Tarantino", "USA", "quentin.tarantino@example.com")));
      log.info("Preloading " + realisateursRepository.save(new Realisateurs("Martin", "Scorsese", "USA", "martin.scorsese@example.com")));
      log.info("Preloading " + realisateursRepository.save(new Realisateurs("Pedro", "Almodovar", "Espagne", "pedro.almodovar@example.com")));
      log.info("Preloading " + realisateursRepository.save(new Realisateurs("Jean-Luc", "Godard", "France", "jeanluc.godard@example.com")));
      log.info("Preloading " + realisateursRepository.save(new Realisateurs("Akira", "Kurosawa", "Japon", "akira.kurosawa@example.com")));
      log.info("Preloading " + realisateursRepository.save(new Realisateurs("Federico", "Fellini", "Italie", "federico.fellini@example.com")));
      log.info("Preloading " + realisateursRepository.save(new Realisateurs("Bong", "Joon Ho", "Corée du Sud", "bong.joonho@example.com")));
      log.info("Preloading " + realisateursRepository.save(new Realisateurs("Julia", "Ducournau", "France", "julia.ducournau@example.com")));
      log.info("Preloading " + realisateursRepository.save(new Realisateurs("Ridley", "Scott", "Royaume-Uni", "ridley.scott@example.com")));

      log.info("Preloading " + acteursRepository.save(new Acteurs("Dujardin", "Jean", "France", "jean.dujardin@example.com", List.of(4L, 6L, 7L), new BigDecimal("5000000"))));
      log.info("Preloading " + acteursRepository.save(new Acteurs("Cruz", "Penélope", "Espagne", "penelope.cruz@example.com", List.of(8L), new BigDecimal("10000000"))));
      log.info("Preloading " + acteursRepository.save(new Acteurs("Thurman", "Uma", "USA", "uma.thurman@example.com", List.of(9L, 3L), new BigDecimal("8000000"))));
      log.info("Preloading " + acteursRepository.save(new Acteurs("DiCaprio", "Leonardo", "USA", "leonardo.dicaprio@example.com", List.of(1L), new BigDecimal("20000000"))));
      log.info("Preloading " + acteursRepository.save(new Acteurs("Cotillard", "Marion", "France", "marion.cotillard@example.com", List.of(), new BigDecimal("5000000"))));
      log.info("Preloading " + acteursRepository.save(new Acteurs("Travolta", "John", "USA", "john.travolta@example.com", List.of(), new BigDecimal("15000000"))));
      log.info("Preloading " + acteursRepository.save(new Acteurs("Masina", "Giulietta", "Italie", "giulietta.masina@example.com", List.of(5L), new BigDecimal("3000000"))));
      log.info("Preloading " + acteursRepository.save(new Acteurs("Mifune", "Toshiro", "Japon", "toshiro.mifune@example.com", List.of(), new BigDecimal("7000000"))));
      log.info("Preloading " + acteursRepository.save(new Acteurs("Ford", "Harrison", "USA", "harrison.ford@example.com", List.of(), new BigDecimal("25000000"))));
      log.info("Preloading " + acteursRepository.save(new Acteurs("Crowe", "Russell", "Australie", "russell.crowe@example.com", List.of(), new BigDecimal("12000000"))));
      
   
      log.info("Preloading " + employesRepository.save(new Employes("Thierry", "Luc","France", "Luc@mail.com", "MOA")));
      log.info("Preloading " + employesRepository.save(new Employes("Allegre", "Lola","France", "Lola@mail.com", "MOA" )));
      log.info("Preloading " + employesRepository.save(new Employes("Ratier", "Jean","France", "Jean@mail.com", "Alternant" )));
      log.info("Preloading " + employesRepository.save(new Employes("Pernin", "Augustin","France", "Augustin@mail.com", "MOE" )));
       log.info("Preloading " + employesRepository.save(new Employes("Marissal", "Adélaïde","France", "Adé@mail.com", "MOE")));
       log.info("Preloading " + employesRepository.save(new Employes("Rosay", "Bénédicte","France", "Béné@mail.com", "RH")));
       log.info("Preloading " + employesRepository.save(new Employes("Antignac", "Maxime","France", "Maxime@mail.com", "Chef de projet")));
       log.info("Preloading " + employesRepository.save(new Employes("Raissi", "Laabidi","France", "MonsieurRaissi@mail.com", "PDG")));
      
      log.info("Preloading " + recompenseRepository.save(new Recompenses("Oscars du meilleur film", 1994)));
      log.info("Preloading " + recompenseRepository.save(new Recompenses("Palme d'Or", 2019)));
      log.info("Preloading " + recompenseRepository.save(new Recompenses("Golden Globe du meilleur réalisateur", 2003)));
      log.info("Preloading " + recompenseRepository.save(new Recompenses("César du meilleur acteur", 2012)));
      log.info("Preloading " + recompenseRepository.save(new Recompenses("Lion d'Or", 1963)));
      log.info("Preloading " + recompenseRepository.save(new Recompenses("Oscar du meilleur acteur", 2012)));
      log.info("Preloading " + recompenseRepository.save(new Recompenses("Bafta Award", 2011)));
      log.info("Preloading " + recompenseRepository.save(new Recompenses("Goya Award", 2006)));
      log.info("Preloading " + recompenseRepository.save(new Recompenses("Screen Actors Guild Award", 2010)));

      log.info("Preloading " + compagniesRepository.save(new Compagnies("MIMO", "France", "12 rue de Lourcine", "lolallegre@outlook.com", "Achat de films", List.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L))));
      
    };
  }
}