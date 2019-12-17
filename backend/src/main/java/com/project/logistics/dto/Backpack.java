package com.project.logistics.dto;

import com.project.logistics.dto.neworder.NewOrPaidOrder;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private List<NewOrPaidOrder> bestItems;

    private Double maxW;

    private Double bestPrice;

    public Backpack() {
    }

    public Backpack(Double maxW) {
        this.maxW = maxW;
    }

    public void setBestItems(List<NewOrPaidOrder> bestItems) {
        this.bestItems = bestItems;
    }

    public void setMaxW(Double maxW) {
        this.maxW = maxW;
    }

    public void setBestPrice(Double bestPrice) {
        this.bestPrice = bestPrice;
    }

    public List<NewOrPaidOrder> getBestItems() {
        return bestItems;
    }

    public Double getMaxW() {
        return maxW;
    }

    public Double getBestPrice() {
        return bestPrice;
    }

    private double calcWeight(List<NewOrPaidOrder> items) {
        double sumW = 0;
        for (NewOrPaidOrder item : items) {
            sumW += item.getWeight();
        }

        return sumW;
    }

    private double calcPrice(List<NewOrPaidOrder> items) {
        double sumPrice = 0;
        for (NewOrPaidOrder item : items) {
            sumPrice += item.getCost();
        }

        return sumPrice;
    }

    private void checkSet(List<NewOrPaidOrder> items) {
        if (this.bestItems == null) {
            if (calcWeight(items) <= this.maxW) {
                this.bestItems = items;
                this.bestPrice = calcPrice(items);
            }
        } else {
            if (calcWeight(items) <=
                    this.maxW &&
                    calcPrice(items) >
                            this.bestPrice) {
                this.bestItems = items;
                this.bestPrice = calcPrice(items);
            }
        }
    }

    public void makeAllSets(List<NewOrPaidOrder> items) {
        if (items.size() > 0) {
            checkSet(items);
        }

        for (int i = 0; i < items.size(); i++) {
            List<NewOrPaidOrder> newSet = new ArrayList<>(items);
            newSet.remove(i);
            makeAllSets(newSet);
        }
    }
}
