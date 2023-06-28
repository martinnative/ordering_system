package com.ulaf.ste.ordering_system.Config;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.*;
import com.ulaf.ste.ordering_system.Repository.OrderItemRepository;
import com.ulaf.ste.ordering_system.Service.*;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.beans.Transient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final CategoryService categoryService;
    private final IngredientService ingredientService;
    private final ProductService productService;
    private final OrderService orderService;
    private final ImageService imageService;
    private final OrderItemRepository product_qtyRepository;

    private Image getImage(String imageName,String type) {
        try {
            ClassPathResource resource = new ClassPathResource("images/" + imageName);
            return new Image(imageName,StreamUtils.copyToByteArray(resource.getInputStream()),type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostConstruct
    public void initializeData() throws NotFoundByIdException {
        Category catPizza = categoryService.createCategory(new Category("Пица","Категорија за пица"));
        Category catSok = categoryService.createCategory(new Category("Ладни пијалоци","Категорија за сокови"));
        Category catPivo = categoryService.createCategory(new Category("Пиво","Категорија за пиво"));
        Category catKafe = categoryService.createCategory(new Category("Кафе","Категорија за кафе"));
        Category catZhestoko = categoryService.createCategory(new Category("Жестоко","Категорија за жестоко"));


        //INGREDIENTS SLIKI

        Image imgBalsamicCream = getImage("icons/balsamic_cream.png","ingredient");
        Image imgBosilek = getImage("icons/bosilek.png","ingredient");
        Image imgBrokula = getImage("icons/brokula.png","ingredient");
        Image imgChili = getImage("icons/chili.png","ingredient");
        Image imgEdamer = getImage("icons/edamer.png","ingredient");
        Image imgGorgonzola = getImage("icons/gorgonzola.png","ingredient");
        Image imgInchuni = getImage("icons/inchuni.png","ingredient");
        Image imgKaperi = getImage("icons/kaperi.png","ingredient");
        Image imgKromid = getImage("icons/kromid.png","ingredient");
        Image imgLuk = getImage("icons/luk.png","ingredient");
        Image imgMaslinke = getImage("icons/maslinke.png","ingredient");
        Image imgMaslinovoMaslo = getImage("icons/maslinovo_maslo.png","ingredient");
        Image imgMortadela = getImage("icons/mortadela.png","ingredient");
        Image imgMozzarella = getImage("icons/mozzarella.png","ingredient");
        Image imgNdujaSpianataSalami = getImage("icons/nduja_spianata_salami.png","ingredient");
        Image imgOrevi = getImage("icons/orevi.png","ingredient");
        Image imgParmezan = getImage("icons/parmezan.png","ingredient");
        Image imgPatlidzhan = getImage("icons/patlidzhan.png","ingredient");
        Image imgPechurki = getImage("icons/pechurki.png","ingredient");
        Image imgPesto = getImage("icons/pesto.png","ingredient");
        Image imgPiper = getImage("icons/piper.png","ingredient");
        Image imgProvola = getImage("icons/provola.png","ingredient");
        Image imgPrshuta = getImage("icons/prshuta.png","ingredient");
        Image imgRukola = getImage("icons/rukola.png","ingredient");
        Image imgSlanina = getImage("icons/slanina.png","ingredient");
        Image imgVentricinaSalami = getImage("icons/ventricina_salami.png","ingredient");
        Image imgShunka = getImage("icons/shunka.png","ingredient");
        imageService.saveImage(imgBalsamicCream);
        imageService.saveImage(imgBosilek);
        imageService.saveImage(imgBrokula);
        imageService.saveImage(imgChili);
        imageService.saveImage(imgEdamer);
        imageService.saveImage(imgGorgonzola);
        imageService.saveImage(imgInchuni);
        imageService.saveImage(imgKaperi);
        imageService.saveImage(imgKromid);
        imageService.saveImage(imgLuk);
        imageService.saveImage(imgMaslinke);
        imageService.saveImage(imgMaslinovoMaslo);
        imageService.saveImage(imgMortadela);
        imageService.saveImage(imgMozzarella);
        imageService.saveImage(imgNdujaSpianataSalami);
        imageService.saveImage(imgOrevi);
        imageService.saveImage(imgParmezan);
        imageService.saveImage(imgPatlidzhan);
        imageService.saveImage(imgPechurki);
        imageService.saveImage(imgPesto);
        imageService.saveImage(imgPiper);
        imageService.saveImage(imgProvola);
        imageService.saveImage(imgPrshuta);
        imageService.saveImage(imgRukola);
        imageService.saveImage(imgSlanina);
        imageService.saveImage(imgVentricinaSalami);
        imageService.saveImage(imgShunka);

        //INGREDIENTS
        Ingredient slanina = ingredientService.createIngredient(new Ingredient("Сланина",imgSlanina));
        Ingredient balsamicCream = ingredientService.createIngredient(new Ingredient("Балсамик крем", imgBalsamicCream));
        Ingredient bosilek = ingredientService.createIngredient(new Ingredient("Босилек", imgBosilek));
        Ingredient brokula = ingredientService.createIngredient(new Ingredient("Брокула", imgBrokula));
        Ingredient chili = ingredientService.createIngredient(new Ingredient("Чили", imgChili));
        Ingredient edamer = ingredientService.createIngredient(new Ingredient("Едамер", imgEdamer));
        Ingredient gorgonzola = ingredientService.createIngredient(new Ingredient("Горгонзола", imgGorgonzola));
        Ingredient inchuni = ingredientService.createIngredient(new Ingredient("Инчуни", imgInchuni));
        Ingredient kaperi = ingredientService.createIngredient(new Ingredient("Капери", imgKaperi));
        Ingredient kromid = ingredientService.createIngredient(new Ingredient("Кромид", imgKromid));
        Ingredient luk = ingredientService.createIngredient(new Ingredient("Лук", imgLuk));
        Ingredient maslinke = ingredientService.createIngredient(new Ingredient("Маслинки", imgMaslinke));
        Ingredient maslinovoMaslo = ingredientService.createIngredient(new Ingredient("Маслиново масло", imgMaslinovoMaslo));
        Ingredient mortadela = ingredientService.createIngredient(new Ingredient("Мортадела", imgMortadela));
        Ingredient mozzarella = ingredientService.createIngredient(new Ingredient("Моцарела", imgMozzarella));
        Ingredient ndujaSpianataSalami = ingredientService.createIngredient(new Ingredient("н'дуја спианата салами", imgNdujaSpianataSalami));
        Ingredient orevi = ingredientService.createIngredient(new Ingredient("Ореви", imgOrevi));
        Ingredient parmezan = ingredientService.createIngredient(new Ingredient("Пармезан", imgParmezan));
        Ingredient domatenSos = ingredientService.createIngredient(new Ingredient("Доматен сос", imgPatlidzhan));
        Ingredient pechurki = ingredientService.createIngredient(new Ingredient("Печурки", imgPechurki));
        Ingredient pesto = ingredientService.createIngredient(new Ingredient("Песто", imgPesto));
        Ingredient piper = ingredientService.createIngredient(new Ingredient("Пиперка", imgPiper));
        Ingredient provola = ingredientService.createIngredient(new Ingredient("Провола", imgProvola));
        Ingredient prshuta = ingredientService.createIngredient(new Ingredient("Пршута", imgPrshuta));
        Ingredient rukola = ingredientService.createIngredient(new Ingredient("Рукола", imgRukola));
        Ingredient shunka = ingredientService.createIngredient(new Ingredient("Шунка", imgShunka));
        Ingredient ventricinaSalami = ingredientService.createIngredient(new Ingredient("Вентричина салами", imgVentricinaSalami));

        List<Ingredient> kaprichozaIngredients = new ArrayList<>();
        kaprichozaIngredients.add(domatenSos);
        kaprichozaIngredients.add(edamer);
        kaprichozaIngredients.add(shunka);
        kaprichozaIngredients.add(pechurki);

        List<Ingredient> margaritaIngredients = new ArrayList<>();
        margaritaIngredients.add(domatenSos);
        margaritaIngredients.add(mozzarella);
        margaritaIngredients.add(maslinovoMaslo);
        margaritaIngredients.add(bosilek);

        List<Ingredient> formadzhiIngredients = new ArrayList<>();
        formadzhiIngredients.add(domatenSos);
        formadzhiIngredients.add(edamer);
        formadzhiIngredients.add(mozzarella);
        formadzhiIngredients.add(provola);
        formadzhiIngredients.add(gorgonzola);
        formadzhiIngredients.add(parmezan);

        List<Ingredient> vekiaIngredients = new ArrayList<>();
        vekiaIngredients.add(mozzarella);
        vekiaIngredients.add(maslinke);
        vekiaIngredients.add(piper);
        vekiaIngredients.add(pesto);
        vekiaIngredients.add(rukola);

        List<Ingredient> pulchinelaIngredients = new ArrayList<>();
        pulchinelaIngredients.add(domatenSos);
        pulchinelaIngredients.add(mozzarella);
        pulchinelaIngredients.add(slanina);
        pulchinelaIngredients.add(pechurki);
        pulchinelaIngredients.add(piper);
        pulchinelaIngredients.add(kromid);

        List<Ingredient> andujaIngredients = new ArrayList<>();
        andujaIngredients.add(domatenSos);
        andujaIngredients.add(mozzarella);
        andujaIngredients.add(ndujaSpianataSalami);

        List<Ingredient> prshutoIngredients = new ArrayList<>();
        prshutoIngredients.add(domatenSos);
        prshutoIngredients.add(mozzarella);
        prshutoIngredients.add(prshuta);
        prshutoIngredients.add(rukola);
        prshutoIngredients.add(parmezan);
        prshutoIngredients.add(balsamicCream);
        prshutoIngredients.add(orevi);

        List<Ingredient> ventrichinaIngredients = new ArrayList<>();
        ventrichinaIngredients.add(domatenSos);
        ventrichinaIngredients.add(mozzarella);
        ventrichinaIngredients.add(ventricinaSalami);
        ventrichinaIngredients.add(chili);
        ventrichinaIngredients.add(pechurki);

        List<Ingredient> napoletanaIngredients = new ArrayList<>();
        napoletanaIngredients.add(domatenSos);
        napoletanaIngredients.add(luk);
        napoletanaIngredients.add(mozzarella);
        napoletanaIngredients.add(maslinke);
        napoletanaIngredients.add(inchuni);
        napoletanaIngredients.add(kaperi);

        List<Ingredient> alpestoIngredients = new ArrayList<>();
        alpestoIngredients.add(mozzarella);
        alpestoIngredients.add(pesto);
        alpestoIngredients.add(mortadela);
        alpestoIngredients.add(orevi);

        //PIZZA SLIKI

        Image imgMargarita = getImage("Pica/margarita.png","Pizza");
        Image imgKaprichoza = getImage("Pica/kaprichoza.png","Pizza");
        Image imgFormadzhi = getImage("Pica/formadzhi.png","Pizza");
        Image imgVekia = getImage("Pica/vekia.png","Pizza");
        Image imgPulchinela = getImage("Pica/pulchinela.png","Pizza");
        Image imgAnduja = getImage("Pica/anduja.png","Pizza");
        Image imgPrshuto = getImage("Pica/prshuto.png","Pizza");
        Image imgVentrichina = getImage("Pica/ventrichina.png","Pizza");
        Image imgAlpesto = getImage("Pica/alpesto.png","Pizza");
        Image imgNapoletana = getImage("Pica/napoletana.png","Pizza");

        //SOKOVI SLIKI
        Image imgCocacola = getImage("Pijaloci/Sok/coca_cola.png","Sokovi");
        Image imgCedevita = getImage("Pijaloci/Sok/cedevita.png","Sokovi");
        Image imgFanta = getImage("Pijaloci/Sok/fanta.png","Sokovi");
        Image imgSprite = getImage("Pijaloci/Sok/sprite.png","Sokovi");
        Image imgPelisterska = getImage("Pijaloci/Sok/pelisterska.png","Sokovi");
        Image imgBitter = getImage("Pijaloci/Sok/scchweppes_bitter_lemon.png","Sokovi");
        Image imgPink = getImage("Pijaloci/Sok/schwepees_pink_soda.png","Sokovi");
        Image imgMandarina = getImage("Pijaloci/Sok/schweppes_mandarina.png","Sokovi");
        Image imgSchweppes = getImage("Pijaloci/Sok/schweppes.png","Sokovi");

        //PIVO SLIKI
        Image imgAmstel = getImage("Pijaloci/Pivo/amstel.png","Sokovi");
        Image imgHeineken = getImage("Pijaloci/Pivo/heineken.png","Sokovi");
        Image imgSkopsko = getImage("Pijaloci/Pivo/skopsko.png","Sokovi");
        Image imgSmooth = getImage("Pijaloci/Pivo/skopsko_smooth.png","Sokovi");

        //KAFE SLIKI
        Image imgAmericanEspresso = getImage("Pijaloci/Kafe/american_espresso.png","Sokovi");
        Image imgCappucino = getImage("Pijaloci/Kafe/cappucino.png","Sokovi");
        Image imgEspresso = getImage("Pijaloci/Kafe/espresso.png","Sokovi");
        Image imgFreddoEspresso = getImage("Pijaloci/Kafe/freddo_espresso.png","Sokovi");
        Image imgIceCoffee = getImage("Pijaloci/Kafe/ice_coffee.png","Sokovi");
        Image imgLatteMacchiato = getImage("Pijaloci/Kafe/latte_macchiato.png","Sokovi");
        Image imgMacchiato = getImage("Pijaloci/Kafe/macchiato.png","Sokovi");
        Image imgNescafe = getImage("Pijaloci/Kafe/nescafe.png","Sokovi");
        Image imgTursko = getImage("Pijaloci/Kafe/tursko.png","Sokovi");

        //ZHESTOKO SLIKI
        Image imgAperol = getImage("Pijaloci/Zhestoko/aperol.png","Sokovi");
        Image imgBaileys = getImage("Pijaloci/Zhestoko/baileys.png","Sokovi");
        Image imgCampari = getImage("Pijaloci/Zhestoko/campari.png","Sokovi");
        Image imgCaptainMorgan = getImage("Pijaloci/Zhestoko/captain_morgan.png","Sokovi");
        Image imgGordons = getImage("Pijaloci/Zhestoko/gordons.png","Sokovi");
        Image imgJackDaniels = getImage("Pijaloci/Zhestoko/jack_daniels.png","Sokovi");
        Image imgJagermeister = getImage("Pijaloci/Zhestoko/jagermeister.png","Sokovi");
        Image imgJameson = getImage("Pijaloci/Zhestoko/jameson.png","Sokovi");
        Image imgJB = getImage("Pijaloci/Zhestoko/jb.png","Sokovi");
        Image imgJohnnieWalker = getImage("Pijaloci/Zhestoko/johnnie_walker.png","Sokovi");
        Image imgMartini = getImage("Pijaloci/Zhestoko/martini.png","Sokovi");
        Image imgPelinkovac = getImage("Pijaloci/Zhestoko/pelinkovac.png","Sokovi");
        Image imgSmirnoff = getImage("Pijaloci/Zhestoko/smirnoff.png","Sokovi");
        imageService.saveImage(imgMargarita);
        imageService.saveImage(imgKaprichoza);
        imageService.saveImage(imgFormadzhi);
        imageService.saveImage(imgVekia);
        imageService.saveImage(imgPulchinela);
        imageService.saveImage(imgAnduja);
        imageService.saveImage(imgPrshuto);
        imageService.saveImage(imgVentrichina);
        imageService.saveImage(imgAlpesto);
        imageService.saveImage(imgNapoletana);

        imageService.saveImage(imgCocacola);
        imageService.saveImage(imgCedevita);
        imageService.saveImage(imgFanta);
        imageService.saveImage(imgSprite);
        imageService.saveImage(imgPelisterska);
        imageService.saveImage(imgBitter);
        imageService.saveImage(imgPink);
        imageService.saveImage(imgMandarina);
        imageService.saveImage(imgSchweppes);

        imageService.saveImage(imgAmstel);
        imageService.saveImage(imgHeineken);
        imageService.saveImage(imgSkopsko);
        imageService.saveImage(imgSmooth);

        imageService.saveImage(imgAmericanEspresso);
        imageService.saveImage(imgCappucino);
        imageService.saveImage(imgEspresso);
        imageService.saveImage(imgFreddoEspresso);
        imageService.saveImage(imgIceCoffee);
        imageService.saveImage(imgLatteMacchiato);
        imageService.saveImage(imgMacchiato);
        imageService.saveImage(imgNescafe);
        imageService.saveImage(imgTursko);

        imageService.saveImage(imgAperol);
        imageService.saveImage(imgBaileys);
        imageService.saveImage(imgCampari);
        imageService.saveImage(imgCaptainMorgan);
        imageService.saveImage(imgGordons);
        imageService.saveImage(imgJackDaniels);
        imageService.saveImage(imgJagermeister);
        imageService.saveImage(imgJameson);
        imageService.saveImage(imgJB);
        imageService.saveImage(imgJohnnieWalker);
        imageService.saveImage(imgMartini);
        imageService.saveImage(imgPelinkovac);
        imageService.saveImage(imgSmirnoff);

        //PIZZA PRODUCTS
        Product margarita = new Product("Маргарита", 280.0, "Пица со кашкавал и кечап", true, true, kaprichozaIngredients, imgMargarita, catPizza);
        productService.createProduct(margarita);

        Product kaprichoza = new Product("Капричиоза", 320.0, "Пица со кашкавал, печурски и салама", true, true, margaritaIngredients, imgKaprichoza, catPizza);
        productService.createProduct(kaprichoza);

        Product formadzhi = new Product("Чинкве Фромаџи", 350.0, "Пица со кашкавал, формаџи и маслиново масло", true, true, formadzhiIngredients, imgFormadzhi, catPizza);
        productService.createProduct(formadzhi);

        Product vekia = new Product("Векиа Наполи", 320.0, "Пица со кашкавал, горгонзола и маслиново масло", true, true, vekiaIngredients, imgVekia, catPizza);
        productService.createProduct(vekia);

        Product pulchinela = new Product("Пулчинела", 360.0, "Пица со кашкавал, мортадела и маслиново масло", true, true, pulchinelaIngredients, imgPulchinela, catPizza);
        productService.createProduct(pulchinela);

        Product anduja = new Product("Андуја Калабрезе", 340.0, "Пица со кашкавал, печурки и андуја", true, true, andujaIngredients, imgAnduja, catPizza);
        productService.createProduct(anduja);

        Product prshuto = new Product("Пршуто крудо и рукола", 380.0, "Пица со кашкавал и пршуто", true, true, prshutoIngredients, imgPrshuto, catPizza);
        productService.createProduct(prshuto);

        Product ventrichina = new Product("Вентричина Диавола", 360.0, "Пица со кашкавал и вентричина", true, true, ventrichinaIngredients, imgVentrichina, catPizza);
        productService.createProduct(ventrichina);

        Product napoletana = new Product("Наполетана", 350.0, "Пица со кашкавал и наполетана салама", true, true, napoletanaIngredients, imgNapoletana, catPizza);
        productService.createProduct(napoletana);

        Product alpesto = new Product("Ал Песто и Мортадела", 370.0, "Пица со кашкавал и алпесто соус", true, true, alpestoIngredients, imgAlpesto, catPizza);
        productService.createProduct(alpesto);

        //SOKOVI PRODUCTS
        productService.createProduct(new Product("Coca Cola",120.0,"Сок",false,true, new ArrayList<>(),imgCocacola,catSok));
        productService.createProduct(new Product("Cedevita", 100.0, "Сок", false, true, new ArrayList<>(), imgCedevita, catSok));
        productService.createProduct(new Product("Fanta", 110.0, "Сок", false, true, new ArrayList<>(), imgFanta, catSok));
        productService.createProduct(new Product("Sprite", 90.0, "Сок", false, true, new ArrayList<>(), imgSprite, catSok));
        productService.createProduct(new Product("Pelisterska", 80.0, "Сок", false, true, new ArrayList<>(), imgPelisterska, catSok));
        productService.createProduct(new Product("Schweppes Bitter Lemon", 130.0, "Сок", false, true, new ArrayList<>(), imgBitter, catSok));
        productService.createProduct(new Product("Schweppes Pink Soda", 115.0, "Сок", false, true, new ArrayList<>(), imgPink, catSok));
        productService.createProduct(new Product("Schweppes Mandarina", 105.0, "Сок", false, true, new ArrayList<>(), imgMandarina, catSok));
        productService.createProduct(new Product("Schweppes", 95.0, "Сок", false, true, new ArrayList<>(), imgSchweppes, catSok));

        //PIVO PRODUCTS
        productService.createProduct(new Product("Amstel", 200.0, "Пиво", false, true, new ArrayList<>(), imgAmstel, catPivo));
        productService.createProduct(new Product("Heineken", 180.0, "Пиво", false, true, new ArrayList<>(), imgHeineken, catPivo));
        productService.createProduct(new Product("Скопско", 150.0, "Пиво", false, true, new ArrayList<>(), imgSkopsko, catPivo));
        productService.createProduct(new Product("Скопско Smooth", 160.0, "Пиво", false, true, new ArrayList<>(), imgSmooth, catPivo));

        //KAFE PRODUCTS
        productService.createProduct(new Product("American Espresso", 90.0, "Кафе", false, true, new ArrayList<>(), imgAmericanEspresso, catKafe));
        productService.createProduct(new Product("Cappucino", 100.0, "Кафе", false, true, new ArrayList<>(), imgCappucino, catKafe));
        productService.createProduct(new Product("Espresso", 80.0, "Кафе", false, true, new ArrayList<>(), imgEspresso, catKafe));
        productService.createProduct(new Product("Freddo Espresso", 110.0, "Кафе", false, true, new ArrayList<>(), imgFreddoEspresso, catKafe));
        productService.createProduct(new Product("Ice Coffee", 120.0, "Кафе", false, true, new ArrayList<>(), imgIceCoffee, catKafe));
        productService.createProduct(new Product("Latte Macchiato", 95.0, "Кафе", false, true, new ArrayList<>(), imgLatteMacchiato, catKafe));
        productService.createProduct(new Product("Macchiato", 85.0, "Кафе", false, true, new ArrayList<>(), imgMacchiato, catKafe));
        productService.createProduct(new Product("Nescafe", 80.0, "Кафе", false, true, new ArrayList<>(), imgNescafe, catKafe));
        productService.createProduct(new Product("Tursko", 75.0, "Кафе", false, true, new ArrayList<>(), imgTursko, catKafe));

        //ZHESTOKO PRODUCTS
        productService.createProduct(new Product("Aperol", 250.0, "Алкохолен пијалок", false, true, new ArrayList<>(), imgAperol, catZhestoko));
        productService.createProduct(new Product("Baileys", 280.0, "Алкохолен пијалок", false, true, new ArrayList<>(), imgBaileys, catZhestoko));
        productService.createProduct(new Product("Campari", 270.0, "Алкохолен пијалок", false, true, new ArrayList<>(), imgCampari, catZhestoko));
        productService.createProduct(new Product("Captain Morgan", 300.0, "Алкохолен пијалок", false, true, new ArrayList<>(), imgCaptainMorgan, catZhestoko));
        productService.createProduct(new Product("Gordons", 220.0, "Алкохолен пијалок", false, true, new ArrayList<>(), imgGordons, catZhestoko));
        productService.createProduct(new Product("Jack Daniels", 320.0, "Алкохолен пијалок", false, true, new ArrayList<>(), imgJackDaniels, catZhestoko));
        productService.createProduct(new Product("Jagermeister", 230.0, "Алкохолен пијалок", false, true, new ArrayList<>(), imgJagermeister, catZhestoko));
        productService.createProduct(new Product("Jameson", 290.0, "Алкохолен пијалок", false, true, new ArrayList<>(), imgJameson, catZhestoko));
        productService.createProduct(new Product("JB", 210.0, "Алкохолен пијалок", false, true, new ArrayList<>(), imgJB, catZhestoko));
        productService.createProduct(new Product("Johnnie Walker", 270.0, "Алкохолен пијалок", false, true, new ArrayList<>(), imgJohnnieWalker, catZhestoko));
        productService.createProduct(new Product("Martini", 240.0, "Алкохолен пијалок", false, true, new ArrayList<>(), imgMartini, catZhestoko));
        productService.createProduct(new Product("Pelinkovac", 200.0, "Алкохолен пијалок", false, true, new ArrayList<>(), imgPelinkovac, catZhestoko));
        productService.createProduct(new Product("Smirnoff", 190.0, "Алкохолен пијалок", false, true, new ArrayList<>(), imgSmirnoff, catZhestoko));

        List<OrderItem> listItems = new ArrayList<>();
        product_qtyRepository.save(new OrderItem(1L,productService.getProductById(1L), 2));
        product_qtyRepository.save(new OrderItem(2L,productService.getProductById(2L), 3));
        listItems.add(product_qtyRepository.findById(1L).orElseThrow());
        listItems.add(product_qtyRepository.findById(2L).orElseThrow());
        Order order1 = new Order(listItems,"Gorjan","Spirovski","gorjanspiroski@gmail.com","075222358");
        orderService.createOrder(order1);
        categoryService.getCategoryById(1L).setProducts(productService.getAllProducts());

    }
}
