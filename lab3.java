import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Tariff {
    private String name;
    private double subscriptionFee;

    public Tariff(String name, double subscriptionFee) {
        this.name = name;
        this.subscriptionFee = subscriptionFee;
    }

    public String getName() {
        return name;
    }

    public double getSubscriptionFee() {
        return subscriptionFee;
    }

    @Override
    public String toString() {
        return "Tariff{" +
                "name='" + name + '\'' +
                ", subscriptionFee=" + subscriptionFee +
                '}';
    }
}

// хранения и управления списком тарифов
class TariffManager {
    private List<Tariff> tariffs = new ArrayList<>();

    public void addTariff(Tariff tariff) {
        tariffs.add(tariff);
    }

    public int getTotalCustomers() {
        return tariffs.size();
    }

    public void sortTariffsBySubscriptionFee() {
        Collections.sort(tariffs, Comparator.comparingDouble(Tariff::getSubscriptionFee));
    }

    public Tariff findTariffBySubscriptionFeeRange(double minFee, double maxFee) {
        for (Tariff tariff : tariffs) {
            if (tariff.getSubscriptionFee() >= minFee && tariff.getSubscriptionFee() <= maxFee) {
                return tariff;
            }
        }
        return null;
    }

    public void displayTariffs() {
        for (Tariff tariff : tariffs) {
            System.out.println(tariff);
        }
    }
}

public class lab3 {
    public static void main(String[] args) {
        // Создаем объект менеджера тарифов
        TariffManager tariffManager = new TariffManager();

        // Добавляем тарифы
        tariffManager.addTariff(new Tariff("Тариф A", 20.0));
        tariffManager.addTariff(new Tariff("Тариф B", 15.0));
        tariffManager.addTariff(new Tariff("Тариф C", 25.0));

        // Выводим общее количество клиентов
        System.out.println("Общее количество клиентов: " + tariffManager.getTotalCustomers());

        tariffManager.sortTariffsBySubscriptionFee();
        System.out.println("Отсортированные тарифы по размеру абонентской платы:");
        tariffManager.displayTariffs();

        // Находим тариф в заданном диапазоне абонентской платы
        double minFee = 15.0;
        double maxFee = 20.0;
        Tariff foundTariff = tariffManager.findTariffBySubscriptionFeeRange(minFee, maxFee);
        if (foundTariff != null) {
            System.out.println("Тариф в заданном диапазоне абонентской платы [" + minFee + " - " + maxFee + "]: " + foundTariff.getName());
        } else {
            System.out.println("Тариф в заданном диапазоне абонентской платы [" + minFee + " - " + maxFee + "] не найден");
        }
    }
}