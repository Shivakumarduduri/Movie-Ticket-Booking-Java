import java.util.Scanner;

public class MovieBooking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int pricePerSeat = 200;
        int totalSeats = 20;

        String[] movies = {"Avengers", "Leo", "Pushpa"};

        boolean[][] seats = new boolean[3][totalSeats];

        int user = 1;

        while (true) {

            System.out.println("\n--- User " + user + " ---");

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            // Show movies
            System.out.println("Movies:");
            for (int i = 0; i < movies.length; i++) {
                System.out.println((i + 1) + ". " + movies[i]);
            }

            System.out.print("Select movie (1-3): ");
            int mChoice = sc.nextInt();
            sc.nextLine();

            if (mChoice < 1 || mChoice > 3) {
                System.out.println("Invalid movie");
                continue;
            }

            int movieIndex = mChoice - 1;

            // Show available seats
            System.out.print("Available seats: ");
            for (int i = 0; i < totalSeats; i++) {
                if (!seats[movieIndex][i]) {
                    System.out.print((i + 1) + " ");
                }
            }
            System.out.println();

            // seat limit (1 to 4)
            int count;
            while (true) {
                System.out.print("Enter number of seats (max 4): ");
                count = sc.nextInt();

                if (count >= 1 && count <= 4) break;
                else System.out.println("Only 1 to 4 seats allowed");
            }

            int[] bookedSeats = new int[count];

            for (int i = 0; i < count; i++) {
                System.out.print("Enter seat number " + (i + 1) + ": ");
                int seat = sc.nextInt();

                if (seat < 1 || seat > totalSeats || seats[movieIndex][seat - 1]) {
                    System.out.println("Seat not available");
                    i--;
                } else {
                    bookedSeats[i] = seat;
                }
            }

            int totalAmount = count * pricePerSeat;

            System.out.println("Total Amount: Rs." + totalAmount);
            System.out.print("Enter amount: ");
            int paid = sc.nextInt();
            sc.nextLine();

            if (paid == totalAmount) {

                for (int s : bookedSeats) {
                    seats[movieIndex][s - 1] = true;
                }

                System.out.println("\nTicket:");
                System.out.println("Name: " + name);
                System.out.println("Movie: " + movies[movieIndex]);

                System.out.print("Seats: ");
                for (int s : bookedSeats) {
                    System.out.print(s + " ");
                }

                System.out.println("\nBooking Confirmed");
            } else {
                System.out.println("Payment failed");
            }

            // 🔥 continue option
            System.out.print("\nDo you want to continue booking? (yes/no): ");
            String cont = sc.nextLine();

            if (!cont.equalsIgnoreCase("yes")) {
                break;
            }

            user++;
        }

        sc.close();
    }
}
