package co.za.izinga.menuupdater.nandos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class NandosMenu {

    public String status;
    public Data data;

    public static class Badge {
        public String id;
        public String path;
        public String name;
        public int width;
        public int height;
        public int size;
        public String contentType;
    }

    public static class Category {
        public String id;
        public String displayType;
        public String name;
        public String description;
        public ArrayList<Child> children;
        public ArrayList<Image> images;
    }

    public static class Child {
        public String destinationType;
        public String destinationId;
        public int displayOrder;
    }

    public static class Data {
        public Menu menu;
    }

    public static class Icon {
        public String id;
        public String path;
        public String name;
        public int width;
        public int height;
        public int size;
        public String contentType;
    }

    public static class Image {
        public String id;
        public String path;
        public String name;
        public int width;
        public int height;
        public int size;
        public String contentType;
    }

    public static class Menu {
        public String id;
        public ArrayList<Product> products;
        public ArrayList<ProductDefinition> productDefinitions;
        public ArrayList<ProductFeature> productFeatures;
        public ArrayList<ProductAllergen> productAllergens;
        public ArrayList<NutritionalComponent> nutritionalComponents;
        public ArrayList<RootCategory> rootCategories;
        public ArrayList<Category> categories;
        public ArrayList<QuickLink> quickLinks;
        public ArrayList<SearchKeyword> searchKeywords;
        public boolean baseMenu;
    }

    public static class NutritionalComponent {
        public String destinationType;
        public String destinationId;
        public double weight;
        public int displayOrder;
        public String id;
        public String name;
        public Object description;
        public String unit;
        public boolean subComponent;
    }

    public static class Product {
        public String id;
        public String srcId;
        public String productDefinitionId;
        public String productType;
        public int price;
        public ArrayList<RelatedProduct> relatedProducts;
    }

    public static class ProductAllergen {
        public String id;
        public String name;
        public String description;
    }

    public static class ProductDefinition {
        public String id;
        public String name;
        public String shortName;
        public String description;
        public double servingSize;
        public ArrayList<String> searchKeywords;
        public Object deliveryDisclaimer;
        public String generalDisclaimer;
        public ArrayList<Image> images;
        public ArrayList<String> allergens;
        public ArrayList<NutritionalComponent> nutritionalComponents;
        public ArrayList<String> autoconfigKeywords;
        public double searchBias;
        public ArrayList<String> features;
        public Badge badge;
        public ArrayList<Upsell> upsells;
    }

    public static class ProductFeature {
        public String id;
        public String name;
        public Object description;
        public Icon icon;
    }

    public static class QuickLink {
        public String id;
        public String name;
        public ArrayList<Child> children;
    }

    public static class RelatedProduct {
        public String id;
        public String srcId;
        public String productDefinitionId;
        public String productType;
        public int quantity;
        public ArrayList<RelatedProduct> relatedProducts;
        @JsonProperty("default")
        public boolean mydefault;
        public boolean mandatory;
        public int price;
    }

    public static class RootCategory {
        public String destinationType;
        public String destinationId;
        public int displayOrder;
    }

    public static class SearchKeyword {
        public String keyword;
        public ArrayList<String> synonyms;
    }

    public static class Upsell {
        public String destinationType;
        public String destinationId;
        public double weight;
        public int displayOrder;
    }

}


