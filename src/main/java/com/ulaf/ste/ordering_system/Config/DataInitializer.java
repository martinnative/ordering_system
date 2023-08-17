package com.ulaf.ste.ordering_system.Config;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.*;
import com.ulaf.ste.ordering_system.Repository.OrderItemRepository;
import com.ulaf.ste.ordering_system.Service.*;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
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
    private final OrderItemRepository product_qtyRepository;
    private final UserService userService;



    @PostConstruct
    public void initializeData() throws NotFoundByIdException {

        String imgCatPizza = "https://nativecreativa.com/wp-content/uploads/images/Kategorii/pizzaBackground.png";
        String imgCatSok = "https://nativecreativa.com/wp-content/uploads/images/Kategorii/ladniBackground.png";
        String imgCatPivo = "https://nativecreativa.com/wp-content/uploads/images/Kategorii/pivoBackground.png";
        String imgCatKafe = "https://nativecreativa.com/wp-content/uploads/images/Kategorii/kafeBackground.png";
        String imgCatZhestoko = "https://nativecreativa.com/wp-content/uploads/images/Kategorii/zhestokoBackground.png";


        Category catPizza = categoryService.createCategory(new Category("Пица","Категорија за пица",imgCatPizza));
        Category catSok = categoryService.createCategory(new Category("Ладни пијалоци","Категорија за сокови",imgCatSok));
        Category catPivo = categoryService.createCategory(new Category("Пиво","Категорија за пиво",imgCatPivo));
        Category catKafe = categoryService.createCategory(new Category("Кафе","Категорија за кафе",imgCatKafe));
        Category catZhestoko = categoryService.createCategory(new Category("Жестоко","Категорија за жестоко",imgCatZhestoko));


        //INGREDIENTS SLIKI
        String imgBalsamicCream = "https://nativecreativa.com/wp-content/uploads/images/icons/balsamic_cream.png";
        String imgBosilek = "https://nativecreativa.com/wp-content/uploads/images/icons/bosilek.png";
        String imgBrokula = "https://nativecreativa.com/wp-content/uploads/images/icons/brokula.png";
        String imgChili = "https://nativecreativa.com/wp-content/uploads/images/icons/chili.png";
        String imgEdamer = "https://nativecreativa.com/wp-content/uploads/images/icons/edamer.png";
        String imgGorgonzola = "https://nativecreativa.com/wp-content/uploads/images/icons/gorgonzola.png";
        String imgInchuni = "https://nativecreativa.com/wp-content/uploads/images/icons/inchuni.png";
        String imgKaperi = "https://nativecreativa.com/wp-content/uploads/images/icons/kaperi.png";
        String imgKromid = "https://nativecreativa.com/wp-content/uploads/images/icons/kromid.png";
        String imgLuk = "https://nativecreativa.com/wp-content/uploads/images/icons/luk.png";
        String imgMaslinke = "https://nativecreativa.com/wp-content/uploads/images/icons/maslinke.png";
        String imgMaslinovoMaslo = "https://nativecreativa.com/wp-content/uploads/images/icons/maslinovo_maslo.png";
        String imgMortadela = "https://nativecreativa.com/wp-content/uploads/images/icons/mortadela.png";
        String imgMozzarella = "https://nativecreativa.com/wp-content/uploads/images/icons/mozzarella.png";
        String imgNdujaSpianataSalami = "https://nativecreativa.com/wp-content/uploads/images/icons/nduja_spianata_salami.png";
        String imgOrevi = "https://nativecreativa.com/wp-content/uploads/images/icons/orevi.png";
        String imgParmezan = "https://nativecreativa.com/wp-content/uploads/images/icons/parmezan.png";
        String imgPatlidzhan = "https://nativecreativa.com/wp-content/uploads/images/icons/patlidzhan.png";
        String imgPechurki = "https://nativecreativa.com/wp-content/uploads/images/icons/pechurki.png";
        String imgPesto = "https://nativecreativa.com/wp-content/uploads/images/icons/pesto.png";
        String imgPiper = "https://nativecreativa.com/wp-content/uploads/images/icons/piper.png";
        String imgProvola = "https://nativecreativa.com/wp-content/uploads/images/icons/provola.png";
        String imgPrshuta = "https://nativecreativa.com/wp-content/uploads/images/icons/prshuta.png";
        String imgRukola = "https://nativecreativa.com/wp-content/uploads/images/icons/rukola.png";
        String imgSlanina = "https://nativecreativa.com/wp-content/uploads/images/icons/slanina.png";
        String imgVentricinaSalami = "https://nativecreativa.com/wp-content/uploads/images/icons/ventricina_salami.png";
        String imgShunka = "https://nativecreativa.com/wp-content/uploads/images/icons/shunka.png";

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
        String imgMargarita = "https://nativecreativa.com/wp-content/uploads/images/Pica/margarita.png";
        String imgKaprichoza = "https://nativecreativa.com/wp-content/uploads/images/Pica/kaprichoza.png";
        String imgFormadzhi = "https://nativecreativa.com/wp-content/uploads/images/Pica/formadzhi.png";
        String imgVekia = "https://nativecreativa.com/wp-content/uploads/images/Pica/vekia.png";
        String imgPulchinela = "https://nativecreativa.com/wp-content/uploads/images/Pica/pulchinela.png";
        String imgAnduja = "https://nativecreativa.com/wp-content/uploads/images/Pica/anduja.png";
        String imgPrshuto = "https://nativecreativa.com/wp-content/uploads/images/Pica/prshuto.png";
        String imgVentrichina = "https://nativecreativa.com/wp-content/uploads/images/Pica/ventrichina.png";
        String imgAlpesto = "https://nativecreativa.com/wp-content/uploads/images/Pica/alpesto.png";
        String imgNapoletana = "https://nativecreativa.com/wp-content/uploads/images/Pica/napoletana.png";

        //SOKOVI SLIKI
        String imgCocacola = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Sok/coca_cola.png";
        String imgCedevita = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Sok/cedevita.png";
        String imgFanta = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Sok/fanta.png";
        String imgSprite = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Sok/sprite.png";
        String imgPelisterska = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Sok/pelisterska.png";
        String imgBitter = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Sok/scchweppes_bitter_lemon.png";
        String imgPink = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Sok/schwepees_pink_soda.png";
        String imgMandarina = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Sok/schweppes_mandarina.png";
        String imgSchweppes = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Sok/schweppes.png";

        //PIVO SLIKI
        String imgAmstel = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Pivo/amstel.png";
        String imgHeineken = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Pivo/heineken.png";
        String imgSkopsko = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Pivo/skopsko.png";
        String imgSmooth = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Pivo/skopsko_smooth.png";

        //KAFE SLIKI
        String imgAmericanEspresso = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Kafe/american_espresso.png";
        String imgCappucino = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Kafe/cappucino.png";
        String imgEspresso = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Kafe/espresso.png";
        String imgFreddoEspresso = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Kafe/freddo_espresso.png";
        String imgIceCoffee = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Kafe/ice_coffee.png";
        String imgLatteMacchiato = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Kafe/latte_macchiato.png";
        String imgMacchiato = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Kafe/macchiato.png";
        String imgNescafe = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Kafe/nescafe.png";
        String imgTursko = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Kafe/tursko.png";

        //ZHESTOKO SLIKI
        String imgAperol = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Zhestoko/aperol.png";
        String imgBaileys = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Zhestoko/baileys.png";
        String imgCampari = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Zhestoko/campari.png";
        String imgCaptainMorgan = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Zhestoko/captain_morgan.png";
        String imgGordons = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Zhestoko/gordons.png";
        String imgJackDaniels = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Zhestoko/jack_daniels.png";
        String imgJagermeister = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Zhestoko/jagermeister.png";
        String imgJameson = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Zhestoko/jameson.png";
        String imgJB = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Zhestoko/jb.png";
        String imgJohnnieWalker = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Zhestoko/johnnie_walker.png";
        String imgMartini = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Zhestoko/martini.png";
        String imgPelinkovac = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Zhestoko/pelinkovac.png";
        String imgSmirnoff = "https://nativecreativa.com/wp-content/uploads/images/Pijaloci/Zhestoko/smirnoff.png";


        //PIZZA PRODUCTS

        Product kaprichoza = new Product("Капричиоза", 340, "Пица со доматен сос, едамер, шунка, печурки", true, false, kaprichozaIngredients, imgKaprichoza, catPizza,1);
        productService.createProduct(kaprichoza);

        Product margarita = new Product("Маргарита", 320, "Пица со доматен сос, моцарела, босилек, маслиново масло", true, false, margaritaIngredients, imgMargarita, catPizza,2);
        productService.createProduct(margarita);

        Product formadzhi = new Product("Чинкве Фромаџи", 400, "Пица со доматен сос, едамер, моцарела, провола, горгонзола, пармезан", true, true, formadzhiIngredients, imgFormadzhi, catPizza,3);
        productService.createProduct(formadzhi);

        Product vekia = new Product("Векиа Наполи", 350, "Пица со моцарела, маслинки, пиперки, песто, рукола", true, true, vekiaIngredients, imgVekia, catPizza,4);
        productService.createProduct(vekia);

        Product pulchinela = new Product("Пулчинела", 370, "Пица со доматен сос, моцарела, сланина, печурки, пиперки, кромид", true, true, pulchinelaIngredients, imgPulchinela, catPizza,5);
        productService.createProduct(pulchinela);

        Product anduja = new Product("Андуја Калабрезе", 400, "Пица со доматен сос, моцарела, н'дуја спианата салами", true, true, andujaIngredients, imgAnduja, catPizza,6);
        productService.createProduct(anduja);

        Product prshuto = new Product("Пршуто крудо и рукола", 420, "Пица со доматен сос, моцарела, пршута, рукола, пармезан, балсамик крем, ореви", true, true, prshutoIngredients, imgPrshuto, catPizza,7);
        productService.createProduct(prshuto);

        Product ventrichina = new Product("Вентричина Диавола", 400, "Пица со доматен сос, моцарела, вентричина салами, чили, печурки", true, true, ventrichinaIngredients, imgVentrichina, catPizza,8);
        productService.createProduct(ventrichina);

        Product napoletana = new Product("Наполетана", 380, "Пица со доматен сос, лук, моцарела, маслинки, инчуни, капери", true, true, napoletanaIngredients, imgNapoletana, catPizza,9);
        productService.createProduct(napoletana);

        Product alpesto = new Product("Ал Песто и Мортадела", 380, "Пица со моцарела, песто, мортадела, ореви", true, true, alpestoIngredients, imgAlpesto, catPizza,10);
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
        List<String> notIngredients = new ArrayList<>();
        notIngredients.add("Test");
        List<Ingredient> notIngredientsObjects = notIngredients.stream().map(ingredientService::findByName).toList();
        product_qtyRepository.save(new OrderItem(productService.getProductById(1L), 2, notIngredientsObjects));
        product_qtyRepository.save(new OrderItem(productService.getProductById(2L), 3,notIngredientsObjects));
        product_qtyRepository.save(new OrderItem(productService.getProductById(11L), 1,notIngredientsObjects));
        product_qtyRepository.save(new OrderItem(productService.getProductById(15L), 2,notIngredientsObjects));
        listItems.add(product_qtyRepository.findById(1L).orElseThrow());
        listItems.add(product_qtyRepository.findById(2L).orElseThrow());
        list2.add(product_qtyRepository.findById(3L).orElseThrow());
        list2.add(product_qtyRepository.findById(4L).orElseThrow());
        Order order1 = new Order(listItems,"Gorjan","Spirovski","gorjanspiroski@gmail.com","070344899", LocalDateTime.now());
        Order order2 = new Order(listItems,"Dragan","Bozhinoski","test@test123.com","071519218", LocalDateTime.of(2023,8,3, 0,0,0));
        Order order3 = new Order(listItems,"Martin","Fidanovski","martin@test123.com","075222358", LocalDateTime.of(2023,7,10, 13,10,0));
        Order order4 = new Order(list2,"Martin2","Fidanovski2","martin@test123.com","075222358", LocalDateTime.of(2023,7,10, 13,10,0));
        orderService.createOrder(order1);
        orderService.createOrder(order2);
        orderService.createOrder(order3);
        orderService.createOrder(order4);
        categoryService.getCategoryById(1L).setProducts(productService.getAllProducts());

        userService.save("dbozhinoski","123","Dragan","Bozhinoski",Role.ADMIN);
        userService.save("martinnative","200200200Ss#","Martin","Fidanovski",Role.ADMIN);
        }
}
