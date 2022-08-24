package io.bayrktlihn.springsecuritytutorial;

import io.bayrktlihn.springsecuritytutorial.model.*;
import io.bayrktlihn.springsecuritytutorial.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    public static final long ONE_DAY_AS_MILLISECOND = 24L * 60L * 60L * 100L;
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    private final AccountTransactionRepository accountTransactionRepository;
    private final LoanRepository loanRepository;
    private final CardRepository cardRepository;
    private final NoticeRepository noticeRepository;
    private final AuthorityRepository authorityRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initCustomers();
        initAccounts();
        initAccountTransactions();
        initLoans();
        initCards();
        initNotices();
        initAuthorities();
    }

    private void initAuthorities() {
        Customer customer = customerRepository.getReferenceById(1L);

//        authorityRepository.save(new Authority(customer, "WRITE"));
//        authorityRepository.save(new Authority(customer, "READ"));

        authorityRepository.save(new Authority(customer, "ROLE_XXX"));
        authorityRepository.save(new Authority(customer, "ROLE_ADMIN"));

    }

    private void initNotices() {
        Date nowDate = new Date();

        Date noticBegDt = createDate(2020, 10, 14);
        noticeRepository.save(new Notice("Home Loan Interest rates reduced", "Home loan interest rates are reduced as per the goverment guidelines. The updated rates will be effective immediately", noticBegDt, createDate(2020, 11, 30), nowDate, null));
        noticeRepository.save(new Notice("Net Banking Offers", "Customers who will opt for Internet banking while opening a saving account will get a $50 amazon voucher", noticBegDt, createDate(2020, 12, 5), nowDate, null));
        noticeRepository.save(new Notice("Mobile App Downtime", "The mobile application of the EazyBank will be down from 2AM-5AM on 12/05/2020 due to maintenance activities'", noticBegDt, createDate(2020, 12, 1), nowDate, null));
        noticeRepository.save(new Notice("E Auction notice", "There will be a e-auction on 12/08/2020 on the Bank website for all the stubborn arrears.Interested parties can participate in the e-auction", noticBegDt, createDate(2020, 12, 8), nowDate, null));
        noticeRepository.save(new Notice("Launch of Millennia Cards", "Millennia Credit Cards are launched for the premium customers of EazyBank. With these cards, you will get 5% cashback for each purchase", noticBegDt, createDate(2020, 11, 28), nowDate, null));
        noticeRepository.save(new Notice("COVID-19 Insurance", "EazyBank launched an insurance policy which will cover COVID-19 expenses. Please reach out to the branch for more details", noticBegDt, createDate(2020, 12, 31), nowDate, null));
    }

    private void initCards() {

        Customer customer = customerRepository.getReferenceById(1L);

        Date nowDate = new Date();

        cardRepository.save(new Card("4565XXXX4656", customer, CardType.CREDIT, 10000, 500, 9500, nowDate));
        cardRepository.save(new Card("3455XXXX8673", customer, CardType.CREDIT, 7500, 600, 6900, nowDate));
        cardRepository.save(new Card("2359XXXX9346", customer, CardType.CREDIT, 20000, 4000, 16000, nowDate));
    }

    private void initLoans() {
        Customer customer = customerRepository.getReferenceById(1L);

        loanRepository.save(new Loan(customer, createDate(2020, 10, 13), LoanType.HOME, 200000, 50000, 150000, createDate(2020, 10, 13)));
        loanRepository.save(new Loan(customer, createDate(2020, 6, 6), LoanType.VEHICLE, 40000, 10000, 30000, createDate(2020, 6, 6)));
        loanRepository.save(new Loan(customer, createDate(2018, 2, 14), LoanType.HOME, 50000, 10000, 40000, createDate(2018, 2, 14)));
        loanRepository.save(new Loan(customer, createDate(2018, 2, 14), LoanType.PERSONAL, 10000, 3500, 6500, createDate(2018, 2, 14)));
    }

    private void initAccountTransactions() {


        Supplier<String> randomIdGetter = () -> UUID.randomUUID().toString();

        Date nowDate = new Date();


        Account account = accountRepository.getReferenceById(186576453434L);
        Customer customer = customerRepository.getReferenceById(1L);

        accountTransactionRepository.save(new AccountTransaction(randomIdGetter.get(), account, customer, minusDay(nowDate, 7), "Coffe Shop", TransactionType.WITHDRAWAL, 30, 34500, minusDay(nowDate, 7)));
        accountTransactionRepository.save(new AccountTransaction(randomIdGetter.get(), account, customer, minusDay(nowDate, 6), "Uber", TransactionType.WITHDRAWAL, 100, 34400, minusDay(nowDate, 6)));
        accountTransactionRepository.save(new AccountTransaction(randomIdGetter.get(), account, customer, minusDay(nowDate, 5), "Self Deposit", TransactionType.DEPOSIT, 500, 34900, minusDay(nowDate, 5)));
        accountTransactionRepository.save(new AccountTransaction(randomIdGetter.get(), account, customer, minusDay(nowDate, 4), "Ebay", TransactionType.WITHDRAWAL, 600, 34300, minusDay(nowDate, 4)));
        accountTransactionRepository.save(new AccountTransaction(randomIdGetter.get(), account, customer, minusDay(nowDate, 2), "OnlineTransfer", TransactionType.DEPOSIT, 700, 35000, minusDay(nowDate, 2)));
        accountTransactionRepository.save(new AccountTransaction(randomIdGetter.get(), account, customer, minusDay(nowDate, 1), "Amazon.com", TransactionType.WITHDRAWAL, 100, 34900, minusDay(nowDate, 1)));
    }

    private void initAccounts() {
        Customer customer = customerRepository.getReferenceById(1L);

        Account account = new Account();
        account.setCustomer(customer);
        account.setAccountNumber(186576453434L);
        account.setAccountType("Savings");
        account.setBranchAddress("23 Main Street, New York");
        account.setCreateDt(new Date());

        accountRepository.save(account);
    }

    private void initCustomers() {
        Customer customer = new Customer();
        customer.setName("happy");
        customer.setEmail("happy@example.com");
        customer.setMobileNumber("9876548337");
        customer.setPwd("$2a$12$DPSnfzu7aY1OrHhsBkU.BuYWDOw8NUUqe8Cx9wOToV7cJmZxdusJS");
        customer.setRole(Role.ROLE_ADMIN);
        customer.setCreateDt(new Date());


        customerRepository.save(customer);
    }

    private Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return calendar.getTime();
    }

    private Date addDay(Date date, long day) {
        long newTime = date.getTime() + day * ONE_DAY_AS_MILLISECOND;
        return new Date(newTime);
    }

    private Date minusDay(Date date, long day) {
        if (day < 0) {
            day = -day;
        }
        return addDay(date, -day);
    }
}
