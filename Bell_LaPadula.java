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
        User user1 = new User("Alice", ClearanceLevel.NOMINAL);
        User user2 = new User("Bob", ClearanceLevel.RESTRICTED);
        User user3 = new User("Charlie", ClearanceLevel.SECURE);
        User user4 = new User("Dave", ClearanceLevel.THAUMIEL);
        User user5 = new User("Eve", ClearanceLevel.APOLLYON);
    }
}