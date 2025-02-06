public class Bell_LaPadula {
    enum ClearanceLevel {
        NOMINAL, // Equivalent to "Unclassified (U)"
        RESTRICTED, // Equivalent to "Confidential (C)"
        SECURE, // Equivalent to "Secret (S)"
        THAUMIEL, // Equivalent to "Top Secret (TS)"
        APOLLYON // Equivalent to "Cosmic Top Secret (CTS)"
    }

    static class Secured_Object {
        String name;
        ClearanceLevel clearanceLevel;

        String content;

        public Secured_Object(String name, ClearanceLevel clearanceLevel, String content) {
            this.name = name;
            this.clearanceLevel = clearanceLevel;
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public ClearanceLevel getClearanceLevel() {
            return clearanceLevel;
        }

        public String getName() {
            return name;
        }
    }

    static class User {
        String name;
        ClearanceLevel clearanceLevel;

        public User(String name, ClearanceLevel clearanceLevel) {
            this.name = name;
            this.clearanceLevel = clearanceLevel;
        }

        public ClearanceLevel getClearanceLevel() {
            return clearanceLevel;
        }

        public String getName() {
            return name;
        }

        public void tryRead(Secured_Object object) {
            System.out.println("I'm " + this.getName() + ", my clearance level is " + this.getClearanceLevel());
            System.out.println("I'm trying to read " + object.getName() + ", which has a clearance level of "
                    + object.getClearanceLevel());
            if (canRead(this, object)) {
                System.out.println("I can read this object! Here's the content: " + object.getContent());
            } else {
                System.out.println("I can't read this object!");
            }
            System.out.println();
        }
    }

    public static boolean canRead(User user, Secured_Object object) {
        return user.getClearanceLevel().ordinal() >= object.getClearanceLevel().ordinal();
    }

    public static boolean canWrite(User user, Secured_Object object) {
        return user.getClearanceLevel().ordinal() == object.getClearanceLevel().ordinal();
    }

    public static void main(String[] args) {
        User userAlice = new User("Alice", ClearanceLevel.NOMINAL);
        User userBob = new User("Bob", ClearanceLevel.RESTRICTED);
        User userCharlie = new User("Charlie", ClearanceLevel.SECURE);
        User userDave = new User("Dave", ClearanceLevel.THAUMIEL);
        User userEve = new User("Eve", ClearanceLevel.APOLLYON);

        User[] users = { userAlice, userBob, userCharlie, userDave, userEve };

        Secured_Object objectWelcomeMessage = new Secured_Object("Welcome Message", ClearanceLevel.NOMINAL,
                "Welcome to the company!");
        Secured_Object objectLocationList = new Secured_Object("Location List", ClearanceLevel.RESTRICTED,
                "A list of all locations we work...");
        Secured_Object objectDirectorContact = new Secured_Object("Director Contact List", ClearanceLevel.SECURE,
                "The contact numbers for our directors.");
        Secured_Object objectNuclearCodes = new Secured_Object("Nuclear Codes", ClearanceLevel.THAUMIEL,
                "Nuclear codes. Be careful with them!");
        Secured_Object objectSpecialChicken = new Secured_Object("Special Chicken", ClearanceLevel.APOLLYON,
                "A recipe for very special chicken. Everyone loves it!");

        Secured_Object[] objects = { objectWelcomeMessage, objectLocationList, objectDirectorContact,
                objectNuclearCodes, objectSpecialChicken };

    }
}