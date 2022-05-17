package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ChocolateRepository chocolateRepository;

    @Autowired
    EstateRepository estateRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Estate estate1 = new Estate("HoneyMoon", "UK");
        Estate estate2 = new Estate("Sunny", "Belgium");
        Estate estate3 = new Estate("The Wave", "Germany");
        List<Estate> list1 = new ArrayList<Estate>(List.of(estate1, estate2, estate3));
        estateRepository.saveAll(list1);

        Chocolate chocolate1 = new Chocolate("KitKat", 48, estate1);
        Chocolate chocolate2 = new Chocolate("Duncan", 65, estate1);
        Chocolate chocolate3 = new Chocolate("Godiva", 50, estate2);
        Chocolate chocolate4 = new Chocolate("Milka", 70, estate3);
        Chocolate chocolate5 = new Chocolate("Moser Roth", 40, estate3);
        Chocolate chocolate6 = new Chocolate("Merci", 55, estate3);
        Chocolate chocolate7 = new Chocolate("Cadbury", 30, estate1);
        Chocolate chocolate8 = new Chocolate("Galaxy", 20, estate1);
        Chocolate chocolate9 = new Chocolate("Kinder", 32, estate1);
        Chocolate chocolate10 = new Chocolate("Leonidas", 72, estate2);

        List<Chocolate> list2 = new ArrayList<>(List.of(chocolate1, chocolate2, chocolate3, chocolate4,
                chocolate5, chocolate6, chocolate7, chocolate8, chocolate9, chocolate10));
        chocolateRepository.saveAll(list2);

    }
}
