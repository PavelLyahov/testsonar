package jae;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * нужно посчитать общий баланс пользователей старше 18, у которых аккаунт не помечен как suspended
 */
public class UsersBalance {
    public static void main(String[] args) {
        List<UserAccount> users = Arrays.asList(
                new UserAccount("Andrew", 19, 350, false),
                new UserAccount("Graham", 36, -15, true),
                new UserAccount("Fred", 18, 10, false),
                new UserAccount("Stuart", 23, 1000, false),
                new UserAccount("Martyn", 26, 350, true)
        );

        System.out.println(getNonSuspendBalance(users));

    }

    public static long getNonSuspendBalance(List<UserAccount> users) {
        return users.stream()
                .filter(Objects::nonNull)
                .filter(x -> !x.suspended)
                .filter(x -> x.age > 18)
                .mapToLong(UserAccount::getBalance)
                .sum();
    }

    static class UserAccount {
        public String name;
        public int age;
        public long balance;
        public boolean suspended;

        public long getBalance() {
            return this.balance;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public boolean isSuspended() {
            return suspended;
        }

        public UserAccount(String name, int age, long balance, boolean suspended) {
            this.name = name;
            this.age = age;
            this.balance = balance;
            this.suspended = suspended;
        }
    }
}



