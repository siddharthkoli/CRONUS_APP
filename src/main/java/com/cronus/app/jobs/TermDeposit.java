package com.cronus.app.jobs;

import java.util.ArrayList;
import java.time.*;
import java.util.Date;

import com.cronus.app.PropertiesReader;
import com.cronus.app.notifications.TelegramNotification;
import com.cronus.app.utils.ExcelAPI;
import com.cronus.app.utils.ExcelRow;

import java.util.Calendar;

public class TermDeposit extends BaseInvestmentJob {

    public TermDeposit(String accNo, String[] names, Double intDeposited, Double principal, String medium, String date,
            String nominee, String master) {
        super(accNo, names, intDeposited, principal, medium, date, nominee, master);
    }

    public static void executeJob() {
        try {
            ArrayList<ExcelRow> rows = ExcelAPI
                    .readExcel(PropertiesReader.getExcelProperty("SHEET.TERM_DEPOSIT"));
            Date currDate = new Date();
            Instant inst = currDate.toInstant();
            LocalDate localDate = inst.atZone(ZoneId.of("Asia/Kolkata")).toLocalDate();
            Instant dayInst = localDate.atStartOfDay(ZoneId.of("Asia/Kolkata")).toInstant();
            currDate = Date.from(dayInst);
            Calendar calendar = Calendar.getInstance();
            for (ExcelRow row : rows) {
                if (calendar.get(Calendar.YEAR) <= row.getMaturityYear()
                        && calendar.get(Calendar.MONTH) == row.getMaturityMonth()
                        && calendar.get(Calendar.DATE) == row.getMaturityDay()) {
                    boolean multipleUsers = false;
                    if (row.getNames().length > 1)
                        multipleUsers = true;
                    TermDeposit job = new TermDeposit(row.getAccNo(), row.getNames(),
                            row.getIntDeposited(), row.getPrincipal(), row.getMedium(), row.getMaturityDate(), "",
                            row.getMaster());
                    TelegramNotification masterTelegramNotification = new TelegramNotification(
                            PropertiesReader.getChatId(row.getMaster().toUpperCase()));
                    String notificationString = multipleUsers ? job.generateMultipleUsersNotificationString()
                            : job.generateNotificationString();
                    masterTelegramNotification.sendNotification(notificationString);

                    for (String name : row.getNames()) {
                        if (name != "") {
                            new TelegramNotification(PropertiesReader.getChatId(name))
                                    .sendNotification(notificationString);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    String generateNotificationString() {
        return String.format(
                "This is to remind you that your account number %s should be credited with Rs. %f today (%s) for the principal of Rs. %f in %s. This account is in the name of %s for Term Deposit.\n\nSent with concern,\nCRONUS.",
                this.getAccNo(), this.getIntDeposited(), this.getDate(), this.getPrincipal(), this.getMedium(),
                this.getNames());
    }

    private String generateMultipleUsersNotificationString() {
        return String.format(
                "This is to remind you that your account number %s should be credited with Rs. %f today (%s) for the principal of Rs. %f in %s. This account is in the name of %s and %s for Term Deposit.\n\nSent with concern,\nCRONUS.",
                this.getAccNo(), this.getIntDeposited(), this.getDate(), this.getPrincipal(), this.getMedium(),
                this.getNames()[0], this.getNames()[1]);
    }

}