package com.ulaf.ste.ordering_system.Config;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.*;
import com.ulaf.ste.ordering_system.Repository.OrderItemRepository;
import com.ulaf.ste.ordering_system.Service.CategoryService;
import com.ulaf.ste.ordering_system.Service.IngredientService;
import com.ulaf.ste.ordering_system.Service.OrderService;
import com.ulaf.ste.ordering_system.Service.ProductService;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer {

    private final CategoryService categoryService;
    private final IngredientService ingredientService;
    private final ProductService productService;
    private final OrderService orderService;
    private final OrderItemRepository product_qtyRepository;

    public DataInitializer(CategoryService categoryService, IngredientService ingredientService, ProductService productService, OrderService orderService, OrderItemRepository orderItemRepository) {
        this.categoryService = categoryService;
        this.ingredientService = ingredientService;
        this.productService = productService;
        this.orderService = orderService;
        this.product_qtyRepository = orderItemRepository;
    }

    private byte[] getPizzaImageBytes(String imageName) {
        try {
            ClassPathResource resource = new ClassPathResource("images/" + imageName);
            return StreamUtils.copyToByteArray(resource.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostConstruct
    public void initializeData() throws NotFoundByIdException {
        Category catPizza = categoryService.createCategory(new Category("Пица","Категорија за пица"));
        Category catSok = categoryService.createCategory(new Category("Сокови","Категорија за сокови"));
        Category catPivo = categoryService.createCategory(new Category("Пиво","Категорија за пиво"));
        Category catKafe = categoryService.createCategory(new Category("Кафе","Категорија за кафе"));
        Category catZhestoko = categoryService.createCategory(new Category("Жестоко","Категорија за жестоко"));

        //INGREDIENTS SLIKI
        byte[] imgBalsamicCream = getPizzaImageBytes("icons/balsamic_cream.png");
        byte[] imgBosilek = getPizzaImageBytes("icons/bosilek.png");
        byte[] imgBrokula = getPizzaImageBytes("icons/brokula.png");
        byte[] imgChili = getPizzaImageBytes("icons/chili.png");
        byte[] imgEdamer = getPizzaImageBytes("icons/edamer.png");
        byte[] imgGorgonzola = getPizzaImageBytes("icons/gorgonzola.png");
        byte[] imgInchuni = getPizzaImageBytes("icons/inchuni.png");
        byte[] imgKaperi = getPizzaImageBytes("icons/kaperi.png");
        byte[] imgKromid = getPizzaImageBytes("icons/kromid.png");
        byte[] imgLuk = getPizzaImageBytes("icons/luk.png");
        byte[] imgMaslinke = getPizzaImageBytes("icons/maslinke.png");
        byte[] imgMaslinovoMaslo = getPizzaImageBytes("icons/maslinovo_maslo.png");
        byte[] imgMortadela = getPizzaImageBytes("icons/mortadela.png");
        byte[] imgMozzarella = getPizzaImageBytes("icons/mozzarella.png");
        byte[] imgNdujaSpianataSalami = getPizzaImageBytes("icons/nduja_spianata_salami.png");
        byte[] imgOrevi = getPizzaImageBytes("icons/orevi.png");
        byte[] imgParmezan = getPizzaImageBytes("icons/parmezan.png");
        byte[] imgPatlidzhan = getPizzaImageBytes("icons/patlidzhan.png");
        byte[] imgPechurki = getPizzaImageBytes("icons/pechurki.png");
        byte[] imgPesto = getPizzaImageBytes("icons/pesto.png");
        byte[] imgPiper = getPizzaImageBytes("icons/piper.png");
        byte[] imgProvola = getPizzaImageBytes("icons/provola.png");
        byte[] imgPrshuta = getPizzaImageBytes("icons/prshuta.png");
        byte[] imgRukola = getPizzaImageBytes("icons/rukola.png");
        byte[] imgSlanina = getPizzaImageBytes("icons/slanina.png");
        byte[] imgVentricinaSalami = getPizzaImageBytes("icons/ventricina_salami.png");
        byte[] imgShunka = getPizzaImageBytes("icons/shunka.png");

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
        byte[] imgMargarita = getPizzaImageBytes("Pica/margarita.png");
        byte[] imgKaprichoza = getPizzaImageBytes("Pica/kaprichoza.png");
        byte[] imgFormadzhi = getPizzaImageBytes("Pica/formadzhi.png");
        byte[] imgVekia = getPizzaImageBytes("Pica/vekia.png");
        byte[] imgPulchinela = getPizzaImageBytes("Pica/pulchinela.png");
        byte[] imgAnduja = getPizzaImageBytes("Pica/anduja.png");
        byte[] imgPrshuto = getPizzaImageBytes("Pica/prshuto.png");
        byte[] imgVentrichina = getPizzaImageBytes("Pica/ventrichina.png");
        byte[] imgAlpesto = getPizzaImageBytes("Pica/alpesto.png");
        byte[] imgNapoletana = getPizzaImageBytes("Pica/napoletana.png");

        //SOKOVI SLIKI
        byte[] imgCocacola = getPizzaImageBytes("Pijaloci/Sok/coca_cola.png");
        byte[] imgCedevita = getPizzaImageBytes("Pijaloci/Sok/cedevita.png");
        byte[] imgFanta = getPizzaImageBytes("Pijaloci/Sok/fanta.png");
        byte[] imgSprite = getPizzaImageBytes("Pijaloci/Sok/sprite.png");
        byte[] imgPelisterska = getPizzaImageBytes("Pijaloci/Sok/pelisterska.png");
        byte[] imgBitter = getPizzaImageBytes("Pijaloci/Sok/scchweppes_bitter_lemon.png");
        byte[] imgPink = getPizzaImageBytes("Pijaloci/Sok/schwepees_pink_soda.png");
        byte[] imgMandarina = getPizzaImageBytes("Pijaloci/Sok/schweppes_mandarina.png");
        byte[] imgSchweppes = getPizzaImageBytes("Pijaloci/Sok/schweppes.png");

        //PIVO SLIKI
        byte[] imgAmstel = getPizzaImageBytes("Pijaloci/Pivo/amstel.png");
        byte[] imgHeineken = getPizzaImageBytes("Pijaloci/Pivo/heineken.png");
        byte[] imgSkopsko = getPizzaImageBytes("Pijaloci/Pivo/skopsko.png");
        byte[] imgSmooth = getPizzaImageBytes("Pijaloci/Pivo/skopsko_smooth.png");

        //KAFE SLIKI
        byte[] imgAmericanEspresso = getPizzaImageBytes("Pijaloci/Kafe/american_espresso.png");
        byte[] imgCappucino = getPizzaImageBytes("Pijaloci/Kafe/cappucino.png");
        byte[] imgEspresso = getPizzaImageBytes("Pijaloci/Kafe/espresso.png");
        byte[] imgFreddoEspresso = getPizzaImageBytes("Pijaloci/Kafe/freddo_espresso.png");
        byte[] imgIceCoffee = getPizzaImageBytes("Pijaloci/Kafe/ice_coffee.png");
        byte[] imgLatteMacchiato = getPizzaImageBytes("Pijaloci/Kafe/latte_macchiato.png");
        byte[] imgMacchiato = getPizzaImageBytes("Pijaloci/Kafe/macchiato.png");
        byte[] imgNescafe = getPizzaImageBytes("Pijaloci/Kafe/nescafe.png");
        byte[] imgTursko = getPizzaImageBytes("Pijaloci/Kafe/tursko.png");

        //ZHESTOKO SLIKI
        byte[] imgAperol = getPizzaImageBytes("Pijaloci/Zhestoko/aperol.png");
        byte[] imgBaileys = getPizzaImageBytes("Pijaloci/Zhestoko/baileys.png");
        byte[] imgCampari = getPizzaImageBytes("Pijaloci/Zhestoko/campari.png");
        byte[] imgCaptainMorgan = getPizzaImageBytes("Pijaloci/Zhestoko/captain_morgan.png");
        byte[] imgGordons = getPizzaImageBytes("Pijaloci/Zhestoko/gordons.png");
        byte[] imgJackDaniels = getPizzaImageBytes("Pijaloci/Zhestoko/jack_daniels.png");
        byte[] imgJagermeister = getPizzaImageBytes("Pijaloci/Zhestoko/jagermeister.png");
        byte[] imgJameson = getPizzaImageBytes("Pijaloci/Zhestoko/jameson.png");
        byte[] imgJB = getPizzaImageBytes("Pijaloci/Zhestoko/jb.png");
        byte[] imgJohnnieWalker = getPizzaImageBytes("Pijaloci/Zhestoko/johnnie_walker.png");
        byte[] imgMartini = getPizzaImageBytes("Pijaloci/Zhestoko/martini.png");
        byte[] imgPelinkovac = getPizzaImageBytes("Pijaloci/Zhestoko/pelinkovac.png");
        byte[] imgSmirnoff = getPizzaImageBytes("Pijaloci/Zhestoko/smirnoff.png");

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
