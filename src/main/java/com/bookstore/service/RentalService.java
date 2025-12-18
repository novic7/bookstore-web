package com.bookstore.service;

import com.bookstore.entity.Rental;
import com.bookstore.repository.RentalRepository;
import com.bookstore.util.EmailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class RentalService {

    private final RentalRepository rentalRepository;
    private final EmailService emailService;

    // Внедрение зависимостей через конструктор
    public RentalService(RentalRepository rentalRepository, EmailService emailService) {
        this.rentalRepository = rentalRepository;
        this.emailService = emailService;
    }

    @Transactional
    public void rentBook(Long bookId, Long userId, int durationInMonths) {
        // !!! Этот метод все еще не используется (предупреждение IDEA),
        // но синтаксически он корректен.
    }

    @Scheduled(fixedRate = 900000)
    public void checkRentalDueDatesAndSendReminders() {
        LocalDate tomorrow = LocalDate.now().plusDays(1);

        List<Rental> rentalsDueTomorrow = rentalRepository.findByRentalEndDateBeforeAndIsActiveTrue(tomorrow);

        for (Rental rental : rentalsDueTomorrow) {
            String subject = "Напоминание: Срок аренды книги истекает завтра";
            String body = String.format("Здравствуйте, %s! Срок аренды книги '%s' истекает завтра, %s.",
                    rental.getUser().getUsername(),
                    rental.getBook().getTitle(),
                    rental.getRentalEndDate());
            emailService.sendReminderEmail(rental.getUser().getEmail(), subject, body);
        }
    }
}

