import java.util.ArrayList;
import java.util.List;

class Client {
    String id;
    int riskScore;
    double accountBalance;

    public Client(String id, int riskScore, double accountBalance) {
        this.id = id;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }
}

public class P2_ClientRiskScoreRanking {

    public static void bubbleSortAsc(Client[] clients) {
        int n = clients.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (clients[j].riskScore > clients[j + 1].riskScore) {
                    Client temp = clients[j];
                    clients[j] = clients[j + 1];
                    clients[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSortDesc(Client[] clients) {
        for (int i = 1; i < clients.length; i++) {
            Client key = clients[i];
            int j = i - 1;

            while (j >= 0 && (clients[j].riskScore < key.riskScore ||
                    (clients[j].riskScore == key.riskScore && clients[j].accountBalance < key.accountBalance))) {
                clients[j + 1] = clients[j];
                j = j - 1;
            }
            clients[j + 1] = key;
        }
    }

    public static List<Client> getTop10Risks(Client[] sortedClients) {
        List<Client> top10 = new ArrayList<>();
        for (int i = 0; i < Math.min(10, sortedClients.length); i++) {
            top10.add(sortedClients[i]);
        }
        return top10;
    }
}