package model;

public class MenuItem {
    private int id;
    private String category;
    private String description;
    private double price;
    private boolean vegetarian;

    public MenuItem(int id, String category, String description, double price, boolean vegetarian) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.price = price;
        this.vegetarian = vegetarian;
    }

    public MenuItem(int id, String category, String description, double price) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.price = price;
    }
    
    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MenuItem other = (MenuItem) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
} // end class MenuItem
