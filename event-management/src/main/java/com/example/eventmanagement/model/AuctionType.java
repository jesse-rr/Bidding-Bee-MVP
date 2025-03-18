package com.example.eventmanagement.model;

import lombok.Getter;

@Getter
public enum AuctionType {
    ENGLISH_AUCTION("A traditional auction where the highest bid wins."),
    DUTCH_AUCTION("An auction where the price decreases until someone accepts the current price."),
    SEALED_BID_AUCTION("Bidders submit secret bids and the highest bidder wins."),
    REVERSE_AUCTION("Bidders compete to offer the lowest price."),
    VICKREY_AUCTION("A sealed-bid auction where the second-highest bid determines the price."),
    SILENT_AUCTION("Bids are written down in private, with no live bidding."),
    ABSOLUTE_AUCTION("An auction without a reserve price; the highest bid wins."),
    RESERVE_AUCTION("The item will only be sold if a minimum price is met."),
    TIMED_AUCTION("An auction with a set time limit; the highest bid at the end wins."),
    ONLINE_AUCTION("An auction conducted over the internet."),
    PENNY_AUCTION("Bidders pay a fee for each bid and each bid raises the price by a small amount."),
    LOTTERY_AUCTION("Bidders purchase entries and the winner is drawn at random."),
    BLIND_AUCTION("Bidders submit bids without knowing what others have bid."),
    BIDDING_WAR_AUCTION("A highly competitive auction where bids escalate quickly."),
    CHARITY_AUCTION("Items are auctioned off to raise funds for a charitable cause."),
    ITEM_OR_SERVICE_AUCTION("An auction for goods or services."),
    CASH_AUCTION("An auction where only cash payments are accepted."),
    MULTI_UNIT_AUCTION("Multiple identical units of an item are sold at the same auction."),
    ESTATE_AUCTION("An auction of items from a deceased person's estate."),
    LIVE_AUCTION("A real-time auction, often with an auctioneer present."),
    BIDDING_POOL_AUCTION("A group of bidders pool resources to bid on an item.");

    private final String description;

    AuctionType(String description) {
        this.description = description;
    }
}
