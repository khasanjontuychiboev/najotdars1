package demo.demo39;

public class LivelockExample {
    public static void main(String[] args) {
        // Create two friends
        Friend friend1 = new Friend("Alice");
        Friend friend2 = new Friend("Bob");

        // Start a conversation
        new Thread(() -> friend1.greet(friend2)).start();
        new Thread(() -> friend2.greet(friend1)).start();
    }

    static class Friend {
        private final String name;
        private boolean isBusy;

        public Friend(String name) {
            this.name = name;
            this.isBusy = false;
        }

        public String getName() {
            return name;
        }

        public synchronized void greet(Friend otherFriend) {
            while (isBusy) {
                try {
                    System.out.println(name + ": I'm waiting for " + otherFriend.getName() + " to finish.");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(name + ": Hi, " + otherFriend.getName() + "!");
            isBusy = true;

            try {
                Thread.sleep(1000); // Simulate some processing
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            isBusy = false;
        }
    }
}