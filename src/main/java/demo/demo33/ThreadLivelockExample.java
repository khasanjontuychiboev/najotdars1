package demo.demo33;

public class ThreadLivelockExample {
    static class Spoon {
        private Diner owner;

        public Spoon(Diner owner) {
            this.owner = owner;
        }

        public Diner getOwner() {
            return owner;
        }

        public synchronized void setOwner(Diner diner) {
            this.owner = diner;
        }

        public synchronized void use() {
            System.out.println(owner.getName() + " is using the spoon.");
        }
    }

    static class Diner {
        private String name;
        private boolean isHungry;

        public Diner(String name) {
            this.name = name;
            this.isHungry = true;
        }

        public String getName() {
            return name;
        }

        public boolean isHungry() {
            return isHungry;
        }

        public void eatWith(Spoon spoon, Diner spouse) {
            while (isHungry) {
                // Check if spouse has the spoon
                if (spoon.getOwner() != this) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        continue;
                    }
                    continue;
                }

                // Check if spouse is hungry
                if (spouse.isHungry) {
                    System.out.println(name + ": You eat first, my darling " + spouse.getName());
                    spoon.setOwner(spouse);
                    continue;
                }

                // Eat
                spoon.use();
                isHungry = false;
                System.out.println(name + ": I am done eating. " + spouse.getName() + ", it's your turn.");
                spoon.setOwner(spouse);
            }
        }
    }

    public static void main(String[] args) {
        final Diner husband = new Diner("Husband");
        final Diner wife = new Diner("Wife");

        final Spoon sharedSpoon = new Spoon(husband);

        Thread husbandThread = new Thread(() -> husband.eatWith(sharedSpoon, wife));
        Thread wifeThread = new Thread(() -> wife.eatWith(sharedSpoon, husband));

        husbandThread.start();
        wifeThread.start();
    }
}