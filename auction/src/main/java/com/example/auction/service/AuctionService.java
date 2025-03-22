package com.example.auction.service;

import com.example.auction.dto.AuctionRequestDTO;
import com.example.auction.model.Auction;
import com.example.auction.repository.AuctionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuctionService {

    private final AuctionRepository auctionRepository;
    private final AuctionMapper auctionMapper;

    public void addAuction(AuctionRequestDTO request) {
        log.info("ADDING AUCTION REQUEST :: {}", request);
        auctionRepository.save(auctionMapper.toAuction(request));
    }

    public Auction getAccountById(Long auctionId) {
        log.info("RETRIEVING AUCTION WITH ID :: {}",auctionId);
        return auctionRepository.findById(auctionId)
                .orElseThrow(() -> new EntityNotFoundException("AUCTION NOT FOUND WITH ID :: "+ auctionId));
    }

    private boolean verifyDates(Long auctionId) {
        var auction = getAccountById(auctionId);
        if (auction.getStartDate().get()) {

        }
        if (auction.getStartDate() != null && auction.getEndDate() != null) {
            return true;
        }
    }

    @Async
    @Scheduled(cron = "0")
    private
}
