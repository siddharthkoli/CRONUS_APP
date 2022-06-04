package com.cronus.app;

import com.cronus.app.jobs.MonthlyIncomeScheme;
import com.cronus.app.jobs.NationalSavingsCertificate;
import com.cronus.app.jobs.TermDeposit;
import com.cronus.app.notifications.TelegramNotification;

public class App {
    public static void main(String[] args) {
        try {
            TelegramNotification.getUpdates();
            MonthlyIncomeScheme.executeJob();
            NationalSavingsCertificate.executeJob();
            TermDeposit.executeJob();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
