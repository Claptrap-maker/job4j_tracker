package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Класс описывает работу простейшей банковской системы.
 *  @author IVANOVA JULIA
 *  @version 1.0
 */
public class BankService {
    /**
     * Хранение всех клиентов банка с привязанными к ним счетами
     * осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет клиента в систему.
     * Если такой клиент уже есть в системе, то добавления
     * не происходит.
     * @param user ссылка на объект типа User, которая добавляется
     * в список всех клиентов системы.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет клиента из системы.
     * Если в метод было передано значение null, то в таком случае
     * удаления не происходит.
     * @param passport серия и номер паспорта, по которым в последствии
     * будет удален клиент
     * @return {@code true} если удаление произведено успешно, в
     * ином случае {@code false}
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод добавляет новый счет клиенту.
     * Здесь также присутствует проверка входного параметра на null,
     * в случае которой метод добавления счета не произойдет.
     * Счет будет добавлен только в том случае, если такого
     * счета у клиента еще нет.
     * @param passport серия и номер паспорта клиента
     * @param account счет, который нужно добавить клиенту
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод находит клиента в системе по серии и номеру паспорта.
     * @param passport серия и номер паспорта клиента
     * @return {@code rsl} возвращает клиента по предоставленному паспорту
     * или null, если такого клиента найдено не было.
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter((x) -> x.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод находит счет клиента в системе по его реквизитам.
     * Присутствует проверка на то, есть ли такой клиент в системе.
     * @param passport серия и номер паспорта клиента
     * @param requisite реквизиты счета, по которым будет произведен поиск
     * в системе
     * @return {@code result} возвращает счет по предоставленным реквизитам
     * или null, если такого найдено не было
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user).stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод переводит деньги с одного банковского счета на другой.
     * Если счета по предоставленным реквизитам существуют, и сумма
     * на отправительном счете не менее суммы, указанной в параметрах метода,
     * тогда и только тогда будет произведен перевод средств.
     * @param srcPassport серия и номер паспорта отправителя
     * @param srcRequisite реквизиты счета, с которого отправляются деньги
     * @param destPassport серия и номер паспорта получателя
     * @param destRequisite реквизиты счета, на который будут отправлены деньги
     * @param amount сумма, которую необходимо отправить
     * @return {@code true} если перевод был успешно произведен
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
