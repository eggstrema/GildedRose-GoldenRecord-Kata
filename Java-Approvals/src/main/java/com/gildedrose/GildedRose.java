package com.gildedrose;

import java.util.concurrent.ThreadLocalRandom;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.endsWith("Aged Brie")
                && !items[i].name.endsWith("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.endsWith("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    if (!items[i].name.startsWith("Quirky")) {
                        items[i].quality = items[i].quality + 1;
                    } else {
                        items[i].quality = items[i].quality + ThreadLocalRandom.current().nextInt(2, 10);
                        if (items[i].quality > 50) items[i].quality = 50;
                    }

                    if (items[i].name.endsWith("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].name.startsWith("Quirky")) {
                                if (items[i].quality < 50) {
                                    items[i].quality = items[i].quality + ThreadLocalRandom.current().nextInt(2, 10);
                                }
                                if (items[i].quality > 50) items[i].quality = 50;
                            } else {
                                if (items[i].quality < 50) {
                                    items[i].quality = items[i].quality + 1;
                                }
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (!items[i].name.startsWith("Quirky")) {
                                if (items[i].quality < 50) {
                                    items[i].quality = items[i].quality + 1;
                                }
                            } else {
                                int random = ThreadLocalRandom.current().nextInt(2, 10);
                                if (items[i].quality + random >= 50) {
                                    items[i].quality = 50;
                                } else {
                                    items[i].quality = items[i].quality + random;
                                }
                            }
                        }
                    }
                }
            }

            if (!items[i].name.endsWith("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.endsWith("Aged Brie")) {
                    if (!items[i].name.endsWith("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.endsWith("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (!items[i].name.startsWith("Quirky")) {
                        if (items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1;
                        }
                    } else {
                        int random = ThreadLocalRandom.current().nextInt(2, 10);
                        if (items[i].quality > 50 - random) {
                            items[i].quality = items[i].quality + random;
                        } else {
                            items[i].quality = 50;
                        }
                    }
                }
            }
        }
    }
}
