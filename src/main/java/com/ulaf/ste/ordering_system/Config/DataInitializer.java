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

import java.io.IOException;
import java.time.LocalDateTime;
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
    private final UserService userService;

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

        Image imgCatPizza = getImage("Kategorii/pizzaBackground.png","category");
        Image imgCatSok = getImage("Kategorii/ladniBackground.png","category");
        Image imgCatPivo = getImage("Kategorii/pivoBackground.png","category");
        Image imgCatKafe = getImage("Kategorii/kafeBackground.png","category");
        Image imgCatZhestoko = getImage("Kategorii/zhestokoBackground.png","category");
        imageService.saveImage(imgCatPizza);
        imageService.saveImage(imgCatKafe);
        imageService.saveImage(imgCatZhestoko);
        imageService.saveImage(imgCatPivo);
        imageService.saveImage(imgCatSok);

        Category catPizza = categoryService.createCategory(new Category("Пица","Категорија за пица",imgCatPizza));
        Category catSok = categoryService.createCategory(new Category("Ладни пијалоци","Категорија за сокови",imgCatSok));
        Category catPivo = categoryService.createCategory(new Category("Пиво","Категорија за пиво",imgCatPivo));
        Category catKafe = categoryService.createCategory(new Category("Кафе","Категорија за кафе",imgCatKafe));
        Category catZhestoko = categoryService.createCategory(new Category("Жестоко","Категорија за жестоко",imgCatZhestoko));


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
        Image imgCocacola = getImage("Pijaloci/Sok/coca_cola.png","Ladni Pijaloci");
        Image imgCedevita = getImage("Pijaloci/Sok/cedevita.png","Ladni Pijaloci");
        Image imgFanta = getImage("Pijaloci/Sok/fanta.png","Ladni Pijaloci");
        Image imgSprite = getImage("Pijaloci/Sok/sprite.png","Ladni Pijaloci");
        Image imgPelisterska = getImage("Pijaloci/Sok/pelisterska.png","Ladni Pijaloci");
        Image imgBitter = getImage("Pijaloci/Sok/scchweppes_bitter_lemon.png","Ladni Pijaloci");
        Image imgPink = getImage("Pijaloci/Sok/schwepees_pink_soda.png","Ladni Pijaloci");
        Image imgMandarina = getImage("Pijaloci/Sok/schweppes_mandarina.png","Ladni Pijaloci");
        Image imgSchweppes = getImage("Pijaloci/Sok/schweppes.png","Ladni Pijaloci");

        //PIVO SLIKI
        Image imgAmstel = getImage("Pijaloci/Pivo/amstel.png","Pivo");
        Image imgHeineken = getImage("Pijaloci/Pivo/heineken.png","Pivo");
        Image imgSkopsko = getImage("Pijaloci/Pivo/skopsko.png","Pivo");
        Image imgSmooth = getImage("Pijaloci/Pivo/skopsko_smooth.png","Pivo");

        //KAFE SLIKI
        Image imgAmericanEspresso = getImage("Pijaloci/Kafe/american_espresso.png","Kafe");
        Image imgCappucino = getImage("Pijaloci/Kafe/cappucino.png","Kafe");
        Image imgEspresso = getImage("Pijaloci/Kafe/espresso.png","Kafe");
        Image imgFreddoEspresso = getImage("Pijaloci/Kafe/freddo_espresso.png","Kafe");
        Image imgIceCoffee = getImage("Pijaloci/Kafe/ice_coffee.png","Kafe");
        Image imgLatteMacchiato = getImage("Pijaloci/Kafe/latte_macchiato.png","Kafe");
        Image imgMacchiato = getImage("Pijaloci/Kafe/macchiato.png","Kafe");
        Image imgNescafe = getImage("Pijaloci/Kafe/nescafe.png","Kafe");
        Image imgTursko = getImage("Pijaloci/Kafe/tursko.png","Kafe");

        //ZHESTOKO SLIKI
        Image imgAperol = getImage("Pijaloci/Zhestoko/aperol.png","Zhestoko");
        Image imgBaileys = getImage("Pijaloci/Zhestoko/baileys.png","Zhestoko");
        Image imgCampari = getImage("Pijaloci/Zhestoko/campari.png","Zhestoko");
        Image imgCaptainMorgan = getImage("Pijaloci/Zhestoko/captain_morgan.png","Zhestoko");
        Image imgGordons = getImage("Pijaloci/Zhestoko/gordons.png","Zhestoko");
        Image imgJackDaniels = getImage("Pijaloci/Zhestoko/jack_daniels.png","Zhestoko");
        Image imgJagermeister = getImage("Pijaloci/Zhestoko/jagermeister.png","Zhestoko");
        Image imgJameson = getImage("Pijaloci/Zhestoko/jameson.png","Zhestoko");
        Image imgJB = getImage("Pijaloci/Zhestoko/jb.png","Zhestoko");
        Image imgJohnnieWalker = getImage("Pijaloci/Zhestoko/johnnie_walker.png","Zhestoko");
        Image imgMartini = getImage("Pijaloci/Zhestoko/martini.png","Zhestoko");
        Image imgPelinkovac = getImage("Pijaloci/Zhestoko/pelinkovac.png","Zhestoko");
        Image imgSmirnoff = getImage("Pijaloci/Zhestoko/smirnoff.png","Zhestoko");
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
        Product margarita = new Product("Маргарита", 320, "Пица со доматен сос, моцарела, босилек, маслиново масло", true, false, kaprichozaIngredients, imgMargarita, catPizza,0);
        productService.createProduct(margarita);

        Product kaprichoza = new Product("Капричиоза", 340, "Пица со доматен сос, едамер, шунка, печурки", true, false, margaritaIngredients, imgKaprichoza, catPizza,1);
        productService.createProduct(kaprichoza);

        Product formadzhi = new Product("Чинкве Фромаџи", 400, "Пица со доматен сос, едамер, моцарела, провола, горгонзола, пармезан", true, true, formadzhiIngredients, imgFormadzhi, catPizza,2);
        productService.createProduct(formadzhi);

        Product vekia = new Product("Векиа Наполи", 350, "Пица со моцарела, маслинки, пиперки, песто, рукола", true, true, vekiaIngredients, imgVekia, catPizza,3);
        productService.createProduct(vekia);

        Product pulchinela = new Product("Пулчинела", 370, "Пица со доматен сос, моцарела, сланина, печурки, пиперки, кромид", true, true, pulchinelaIngredients, imgPulchinela, catPizza,4);
        productService.createProduct(pulchinela);

        Product anduja = new Product("Андуја Калабрезе", 400, "Пица со доматен сос, моцарела, н'дуја спианата салами", true, true, andujaIngredients, imgAnduja, catPizza,5);
        productService.createProduct(anduja);

        Product prshuto = new Product("Пршуто крудо и рукола", 420, "Пица со доматен сос, моцарела, пршута, рукола, пармезан, балсамик крем, ореви", true, true, prshutoIngredients, imgPrshuto, catPizza,6);
        productService.createProduct(prshuto);

        Product ventrichina = new Product("Вентричина Диавола", 400, "Пица со доматен сос, моцарела, вентричина салами, чили, печурки", true, true, ventrichinaIngredients, imgVentrichina, catPizza,7);
        productService.createProduct(ventrichina);

        Product napoletana = new Product("Наполетана", 380, "Пица со доматен сос, лук, моцарела, маслинки, инчуни, капери", true, true, napoletanaIngredients, imgNapoletana, catPizza,8);
        productService.createProduct(napoletana);

        Product alpesto = new Product("Ал Песто и Мортадела", 380, "Пица со моцарела, песто, мортадела, ореви", true, true, alpestoIngredients, imgAlpesto, catPizza,9);
        productService.createProduct(alpesto);

        //SOKOVI PRODUCTS
        productService.createProduct(new Product("Кока кола / Coca Cola",80,"Сок",false,true, new ArrayList<>(),imgCocacola,catSok));
        productService.createProduct(new Product("Цедевита / Cedevita", 60, "Сок", false, true, new ArrayList<>(), imgCedevita, catSok));
        productService.createProduct(new Product("Фанта / Fanta", 80, "Сок", false, true, new ArrayList<>(), imgFanta, catSok));
        productService.createProduct(new Product("Спрајт / Sprite", 80, "Сок", false, true, new ArrayList<>(), imgSprite, catSok));
        productService.createProduct(new Product("Пелистерка / Pelisterka", 60, "Сок", false, true, new ArrayList<>(), imgPelisterska, catSok));
        productService.createProduct(new Product("Швепс / Schweppes", 80, "Сок", false, true, new ArrayList<>(), imgBitter, catSok));
        productService.createProduct(new Product("Швепс Розев Миксер / Schweppes Pink Mixer", 80, "Сок", false, true, new ArrayList<>(), imgPink, catSok));
        productService.createProduct(new Product("Швепс Портокал / Schweppes Orange", 80, "Сок", false, true, new ArrayList<>(), imgMandarina, catSok));
        productService.createProduct(new Product("Швепс Тоник / Schweppes Tonic", 80, "Сок", false, true, new ArrayList<>(), imgSchweppes, catSok));

        //PIVO PRODUCTS
        productService.createProduct(new Product("Амстел / Amstel", 100, "Пиво", false, true, new ArrayList<>(), imgAmstel, catPivo));
        productService.createProduct(new Product("Хаинекен / Heineken", 130, "Пиво", false, true, new ArrayList<>(), imgHeineken, catPivo));
        productService.createProduct(new Product("Скопско / Skopsko", 100, "Пиво", false, true, new ArrayList<>(), imgSkopsko, catPivo));
        productService.createProduct(new Product("Скопско Смут / Skopsko Smooth", 100, "Пиво", false, true, new ArrayList<>(), imgSmooth, catPivo));

        //KAFE PRODUCTS
        productService.createProduct(new Product("Американско Еспресо / American Espresso", 70, "Кафе", false, true, new ArrayList<>(), imgAmericanEspresso, catKafe));
        productService.createProduct(new Product("Капучино / Cappucino", 80, "Кафе", false, true, new ArrayList<>(), imgCappucino, catKafe));
        productService.createProduct(new Product("Еспресо / Espresso", 60, "Кафе", false, true, new ArrayList<>(), imgEspresso, catKafe));
        productService.createProduct(new Product("Фредо Еспресо / Freddo Espresso", 80, "Кафе", false, true, new ArrayList<>(), imgFreddoEspresso, catKafe));
        productService.createProduct(new Product("Ајс Кафе / Ice Coffee", 100, "Кафе", false, true, new ArrayList<>(), imgIceCoffee, catKafe));
        productService.createProduct(new Product("Лате Макијато / Latte Macchiato", 80, "Кафе", false, true, new ArrayList<>(), imgLatteMacchiato, catKafe));
        productService.createProduct(new Product("Макијато / Macchiato", 70, "Кафе", false, true, new ArrayList<>(), imgMacchiato, catKafe));
        productService.createProduct(new Product("Нескафе / Nescafe", 100, "Кафе", false, true, new ArrayList<>(), imgNescafe, catKafe));
        productService.createProduct(new Product("Турско / Tursko", 60, "Кафе", false, true, new ArrayList<>(), imgTursko, catKafe));

        //ZHESTOKO PRODUCTS
        productService.createProduct(new Product("Аперол / Aperol", 150, "Алкохолен пијалок", false, true, new ArrayList<>(), imgAperol, catZhestoko));
        productService.createProduct(new Product("Бејлис / Baileys", 120, "Алкохолен пијалок", false, true, new ArrayList<>(), imgBaileys, catZhestoko));
        productService.createProduct(new Product("Кампари / Campari", 120, "Алкохолен пијалок", false, true, new ArrayList<>(), imgCampari, catZhestoko));
        productService.createProduct(new Product("Морган / Captain Morgan", 120, "Алкохолен пијалок", false, true, new ArrayList<>(), imgCaptainMorgan, catZhestoko));
        productService.createProduct(new Product("Џин Гордонс / Gordons", 110, "Алкохолен пијалок", false, true, new ArrayList<>(), imgGordons, catZhestoko));
        productService.createProduct(new Product("Џек Даниелс / Jack Daniels", 150, "Алкохолен пијалок", false, true, new ArrayList<>(), imgJackDaniels, catZhestoko));
        productService.createProduct(new Product("Јегер / Jagermeister", 150, "Алкохолен пијалок", false, true, new ArrayList<>(), imgJagermeister, catZhestoko));
        productService.createProduct(new Product("Џејмисон / Jameson", 290.0, "Алкохолен пијалок", false, true, new ArrayList<>(), imgJameson, catZhestoko));
        productService.createProduct(new Product("ЏиБи / JB", 120, "Алкохолен пијалок", false, true, new ArrayList<>(), imgJB, catZhestoko));
        productService.createProduct(new Product("Џони Вокер / Johnnie Walker", 150, "Алкохолен пијалок", false, true, new ArrayList<>(), imgJohnnieWalker, catZhestoko));
        productService.createProduct(new Product("Мартини / Martini", 120, "Алкохолен пијалок", false, true, new ArrayList<>(), imgMartini, catZhestoko));
        productService.createProduct(new Product("Пелинковац / Pelinkovac", 90, "Алкохолен пијалок", false, true, new ArrayList<>(), imgPelinkovac, catZhestoko));
        productService.createProduct(new Product("Смирноф / Smirnoff", 110, "Алкохолен пијалок", false, true, new ArrayList<>(), imgSmirnoff, catZhestoko));
        List<OrderItem> listItems = new ArrayList<>();
        List<OrderItem> list2 = new ArrayList<>();
        product_qtyRepository.save(new OrderItem(productService.getProductById(1L), 2));
        product_qtyRepository.save(new OrderItem(productService.getProductById(2L), 3));
        product_qtyRepository.save(new OrderItem(productService.getProductById(11L), 1));
        product_qtyRepository.save(new OrderItem(productService.getProductById(15L), 2));
        listItems.add(product_qtyRepository.findById(1L).orElseThrow());
        listItems.add(product_qtyRepository.findById(2L).orElseThrow());
        list2.add(product_qtyRepository.findById(3L).orElseThrow());
        list2.add(product_qtyRepository.findById(4L).orElseThrow());
        Order order1 = new Order(listItems,"Gorjan","Spirovski","gorjanspiroski@gmail.com","070344899", LocalDateTime.now());
        Order order2 = new Order(listItems,"Dragan","Bozhinoski","test@test123.com","071519218", LocalDateTime.of(2023,11,10, 0,0,0));
        Order order3 = new Order(listItems,"Martin","Fidanovski","martin@test123.com","075222358", LocalDateTime.of(2023,7,10, 13,10,0));
        Order order4 = new Order(list2,"Martin2","Fidanovski2","martin@test123.com","075222358", LocalDateTime.of(2023,7,10, 13,10,0));
        orderService.createOrder(order1);
        orderService.createOrder(order2);
        orderService.createOrder(order3);
        orderService.createOrder(order4);
        categoryService.getCategoryById(1L).setProducts(productService.getAllProducts());

        userService.save("dbozhinoski","Dragan","Bozhinoski","123",Role.ROLE_ADMIN);
    }
}
