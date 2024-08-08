package ru.netology.entity;

import java.util.Objects;

public class Location {

    private final String city;

    private final Country country;

    private final String street;

    private final int builing;

    public Location(String city, Country country, String street, int builing) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.builing = builing;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public String getStreet() {
        return street;
    }

    public int getBuiling() {
        return builing;
    }


    @Override
    public int hashCode() {
        return Objects.hash(city, country, street, builing);
    }

    @Override
    public boolean equals(Object obj) {
        Location o = (Location) obj;

        if (country == null) {
            return o.country == null;
        }

        if (street == null) {
            return city.equals(o.city) && country.equals(o.country) && o.street == null && builing == 0;
        }

        return city.equals(o.city) && country.equals(o.country) && street.equals(o.street) && builing == o.builing;
    }
}
